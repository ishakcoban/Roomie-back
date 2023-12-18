package com.example.roomie.mapper;

import com.example.roomie.entity.Advert;

import com.example.roomie.entity.FavouriteAdvert;
import com.example.roomie.entity.User;
import com.example.roomie.modal.dto.FavouriteAdvertDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FavouriteAdvertMapper {

    private final AdvertMapper advertMapper;
    public FavouriteAdvertDto toDto(FavouriteAdvert favouriteAdvert){

        return FavouriteAdvertDto.builder()
                .id(favouriteAdvert.getId())
               // .advertDto(advertMapper.toDto(favouriteAdvert.getAdvert()))
                .build();
    }

    public FavouriteAdvert createFavouriteAdvert(Advert advert, User user) throws Exception{

        return FavouriteAdvert.builder()
                .advert(advert)
                .user(user)
                .build();
    }

    public List<FavouriteAdvertDto> toDtoList(List<FavouriteAdvert> favouriteAdverts) {
        return favouriteAdverts.stream().map(this::toDto).collect(Collectors.toList());
    }
}
