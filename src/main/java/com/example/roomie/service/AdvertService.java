package com.example.roomie.service;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.User;
import com.example.roomie.mapper.AdvertMapper;
import com.example.roomie.modal.request.AdvertRequest;
import com.example.roomie.repository.AdvertRepository;
import com.example.roomie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvertService {
    private final AdvertRepository advertRepository;

    public void postAdvert(AdvertRequest advertRequest) throws Exception {

        Advert advert = AdvertMapper.postAdvert(advertRequest);

        advertRepository.save(advert);

    }

    public Advert getAdvert(String id) throws Exception {

        return advertRepository.findById(id).orElseThrow();

    }
}
