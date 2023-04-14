package com.example.roomie.mapper;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.SavedAdvert;
import com.example.roomie.modal.dto.AdvertDto;
import com.example.roomie.modal.dto.SavedAdvertDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SavedAdvertMapper {

    public SavedAdvertDto toDto(SavedAdvert savedAdvert){

        return SavedAdvertDto.builder()
                .id(savedAdvert.getId())
                .user(savedAdvert.getUser())
                .advert(savedAdvert.getAdvert())
                .build();
    }

    public java.util.List<SavedAdvertDto> toDtoList(java.util.List<SavedAdvert> savedAdverts) {
        return savedAdverts.stream().map(this::toDto).collect(Collectors.toList());
    }
}
