package com.example.roomie.service;

import com.example.roomie.entity.SavedAdvert;
import com.example.roomie.repository.SavedAdvertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SavedAdvertService {

    private final SavedAdvertRepository savedAdvertRepository;

    public List<SavedAdvert> getAllByUserId(String userId){
        return savedAdvertRepository.findAllByUserId(userId);
    }
}
