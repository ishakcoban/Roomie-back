package com.example.roomie.mapper;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.SavedAdvert;
import com.example.roomie.entity.User;
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
                .advert(savedAdvert.getAdvert())
                .user(savedAdvert.getUser())
                .build();
    }

    public SavedAdvert saveAdvert(Advert advert, User user){

        return SavedAdvert.builder()
                .user(user)
                .advert(advert)
                .build();
    }

    public java.util.List<SavedAdvertDto> toDtoList(java.util.List<SavedAdvert> savedAdverts) {
        return savedAdverts.stream().map(this::toDto).collect(Collectors.toList());
    }
}
