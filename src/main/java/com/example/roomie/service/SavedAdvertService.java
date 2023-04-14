package com.example.roomie.service;

import com.example.roomie.entity.SavedAdvert;
import com.example.roomie.mapper.SavedAdvertMapper;
import com.example.roomie.modal.dto.SavedAdvertDto;
import com.example.roomie.repository.SavedAdvertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SavedAdvertService {

    private final SavedAdvertRepository savedAdvertRepository;
    private final SavedAdvertMapper savedAdvertMapper;

    public List<SavedAdvertDto> getAllByUser(String userId){
        return savedAdvertMapper.toDtoList(savedAdvertRepository.findAllByUserId(userId));
    }
}
