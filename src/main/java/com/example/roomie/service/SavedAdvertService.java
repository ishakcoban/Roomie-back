package com.example.roomie.service;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.SavedAdvert;
import com.example.roomie.entity.User;
import com.example.roomie.mapper.SavedAdvertMapper;
import com.example.roomie.modal.dto.SavedAdvertDto;
import com.example.roomie.repository.AdvertRepository;
import com.example.roomie.repository.SavedAdvertRepository;
import com.example.roomie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SavedAdvertService {

    private final SavedAdvertRepository savedAdvertRepository;
    private final AdvertRepository advertRepository;
    private final UserRepository userRepository;
    private final SavedAdvertMapper savedAdvertMapper;

    public List<SavedAdvertDto> getAllByUser(String userId){
        List<SavedAdvert> savedAdverts = savedAdvertRepository.findAllByUserId(userId);
        return savedAdvertMapper.toDtoList(savedAdverts);
    }

    public void saveAdvert(String userId,String advertId){
        Advert advert = advertRepository.findById(advertId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();
        SavedAdvert savedAdvert = savedAdvertMapper.saveAdvert(advert,user);
        savedAdvertRepository.save(savedAdvert);
    }

    public void deleteSavedAdvertByUser(String savedAdvertId){
        SavedAdvert savedAdvert = savedAdvertRepository.findById(savedAdvertId).orElseThrow();
        savedAdvertRepository.delete(savedAdvert);
    }


}
