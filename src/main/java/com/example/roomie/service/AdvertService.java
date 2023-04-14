package com.example.roomie.service;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.Location;
import com.example.roomie.entity.User;
import com.example.roomie.mapper.AdvertMapper;
import com.example.roomie.modal.dto.AdvertDto;
import com.example.roomie.modal.request.AdvertRequest;
import com.example.roomie.repository.AdvertRepository;
import com.example.roomie.repository.LocationRepository;
import com.example.roomie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdvertService {
    private final AdvertRepository advertRepository;
    private final UserRepository userRepository;
    private final LocationRepository locationRepository;
    private final AdvertMapper advertMapper;

    public void createAdvert(AdvertRequest advertRequest,String userId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow();
        Advert advert = AdvertMapper.createAdvert(advertRequest,user);
        advertRepository.save(advert);
    }

    public List<AdvertDto> getAllByUser(String userId) throws Exception {
        return advertMapper.toDtoList(advertRepository.findAllByUserId(userId));
    }

    public AdvertDto getAdvert(String advertId) throws Exception {
        return advertMapper.toDto(advertRepository.findById(advertId).orElseThrow());
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
