package com.example.roomie.service;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.AdvertPhoto;
import com.example.roomie.entity.Location;
import com.example.roomie.entity.User;
import com.example.roomie.mapper.AdvertMapper;
import com.example.roomie.mapper.AdvertPhotoMapper;
import com.example.roomie.modal.dto.AdvertDto;
import com.example.roomie.modal.request.AdvertRequest;
import com.example.roomie.repository.AdvertPhotoRepository;
import com.example.roomie.repository.AdvertRepository;
import com.example.roomie.repository.LocationRepository;
import com.example.roomie.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdvertService {
    private final AdvertRepository advertRepository;
    private final AdvertPhotoRepository advertPhotoRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final AdvertMapper advertMapper;
    private final AdvertPhotoMapper advertPhotoMapper;

    @Transactional
    public void createAdvert(String otherInformation, MultipartFile[] images,String userID) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        AdvertRequest advertRequest = objectMapper.readValue(otherInformation, AdvertRequest.class);;

        User user = userRepository.findById(userID).orElseThrow();
        Advert advert = AdvertMapper.createAdvert(advertRequest,user);
        advertRepository.save(advert);

        int photoOrder = 1;
        for (MultipartFile image : images)
        {
            AdvertPhoto advertPhoto = advertPhotoMapper.createAdvertPhoto(image,advert,photoOrder);
            advertPhotoRepository.save(advertPhoto);
            photoOrder++;
        }


    }

    public List<AdvertDto> getAllAdvertsByUser(String userId) throws Exception {

        List<Advert> adverts = advertRepository.findAllByUserId(userId);
        List<AdvertPhoto> advertPhotos = advertPhotoRepository.findAllByUserId(userId);

        return advertMapper.toDtoList(adverts,advertPhotos);
    }

    public List<AdvertDto> getAllAdverts() throws Exception {

        List<Advert> adverts = advertRepository.findAll();
        List<AdvertPhoto> advertPhotos = advertPhotoRepository.findAll();

        return advertMapper.toDtoList(adverts,advertPhotos);

    }

    public AdvertDto getAdvert(String advertId) throws Exception {
        return /*advertMapper.toDto(advertRepository.findById(advertId).orElseThrow())*/null;
    }

    public void deleteAdvert(String advertId) throws Exception {
        Advert advert = advertRepository.findById(advertId).orElseThrow();
        advertRepository.delete(advert);
    }


    public void updateAdvert(String advertId,AdvertRequest advertRequest) throws Exception {
        Advert advert = advertRepository.findById(advertId).orElseThrow();
        Location location = locationRepository.findById(advert.getLocation().getId()).orElseThrow();
        advert.setHeader(advertRequest.getHeader());
        advert.setDescription(advertRequest.getDescription());
        advert.setPrice(advertRequest.getPrice());
        location.setCity(advertRequest.getLocation().getCity());
        location.setDistrict(advertRequest.getLocation().getDistrict());
        location.setNeighbourhood(advertRequest.getLocation().getNeighbourhood());
        advert.setLocation(location);
        advertRepository.save(advert);
    }
}
