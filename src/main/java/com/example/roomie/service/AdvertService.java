package com.example.roomie.service;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.AdvertPhoto;
import com.example.roomie.entity.User;
import com.example.roomie.mapper.AdvertMapper;
import com.example.roomie.mapper.AdvertPhotoMapper;
import com.example.roomie.mapper.UserMapper;
import com.example.roomie.modal.dto.AdvertDto;
import com.example.roomie.modal.dto.UserDto;
import com.example.roomie.modal.request.AdvertRequest;
import com.example.roomie.modal.request.FilterAdvertRequest;
import com.example.roomie.repository.AdvertPhotoRepository;
import com.example.roomie.repository.AdvertRepository;
import com.example.roomie.repository.UserRepository;
import com.example.roomie.utils.AdvertSpecifications;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertService {
    private final AdvertRepository advertRepository;
    private final AdvertPhotoRepository advertPhotoRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AdvertMapper advertMapper;
    private final AdvertPhotoMapper advertPhotoMapper;

    @Transactional
    public void createAdvert(String otherInformation, MultipartFile[] images, Long userId) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        AdvertRequest advertRequest = objectMapper.readValue(otherInformation, AdvertRequest.class);

        User user = userRepository.findById(userId).orElseThrow();
        Advert advert = advertMapper.createAdvert(advertRequest, user);
        advertRepository.save(advert);

        int photoOrder = 1;
        for (MultipartFile image : images) {
            AdvertPhoto advertPhoto = advertPhotoMapper.createAdvertPhoto(image, advert, photoOrder);
            advertPhotoRepository.save(advertPhoto);
            photoOrder++;
        }
    }

    public UserDto getAllAdvertsByUser(Long userId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow();
        return userMapper.toDto(user);
    }

    public List<AdvertDto> getAllAdverts() throws Exception {
        List<Advert> adverts = advertRepository.findAll();
        return advertMapper.toDtoList(adverts);
    }

    public AdvertDto getAdvert(Long advertId) throws Exception {
        Advert advert = advertRepository.findById(advertId).orElseThrow();
        return advertMapper.toDto(advert);

    }

    public void deleteAdvert(Long advertId) throws Exception {
        Advert advert = advertRepository.findById(advertId).orElseThrow();
        advertRepository.delete(advert);
    }

    public void updateAdvert(Long advertId, AdvertRequest advertRequest) throws Exception {
        Advert existedAdvert = advertRepository.findById(advertId).orElseThrow();
        Advert updateAdvert = advertMapper.updateAdvert(existedAdvert,advertRequest);
        advertRepository.save(updateAdvert);
    }

    public List<AdvertDto> filterAdvert(FilterAdvertRequest filterAdvertRequest) throws Exception {
        Specification<Advert> spec = Specification.where(null);
        spec = spec.and(AdvertSpecifications.getFilterQuery(filterAdvertRequest));
        List<Advert> adverts = advertRepository.findAll(spec);
        //return advertMapper.toDtoList(adverts);
        return null;
    }
}
