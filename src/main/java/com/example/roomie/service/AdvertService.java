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

    public AdvertDto getAdvert(String id) throws Exception {
        return advertMapper.toDto(advertRepository.findById(id).orElseThrow());
    }
}
