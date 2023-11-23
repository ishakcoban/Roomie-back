package com.example.roomie.mapper;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.AdvertPhoto;
import com.example.roomie.entity.FavouriteAdvert;
import com.example.roomie.entity.User;
import com.example.roomie.modal.dto.AdvertPhotoDto;
import com.example.roomie.modal.dto.FavouriteAdvertDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FavouriteAdvertMapper {

    private final AdvertMapper advertMapper;
    private final AdvertPhotoMapper advertPhotoMapper;
    public FavouriteAdvertDto toDto(FavouriteAdvert favouriteAdvert,List<AdvertPhotoDto> advertPhotos) throws Exception{

        return FavouriteAdvertDto.builder()
                .id(favouriteAdvert.getId())
              //  .advertDto(advertMapper.toDto())
                .photos(advertPhotos)
                .build();
    }

    public FavouriteAdvert createFavouriteAdvert(Advert advert, User user) throws Exception{

        return FavouriteAdvert.builder()
                .advert(advert)
                .user(user)
                .build();
    }

  /*  public List<FavouriteAdvertDto> toDtoList(List<FavouriteAdvert> favouriteAdverts,List<AdvertPhoto> advertPhotos) {
        Map<String, List<AdvertPhoto>> advertPhotoMap = advertPhotos.stream()
                .collect(Collectors.groupingBy(photo -> photo.getAdvert().getId()));

        return favouriteAdverts.stream()
                .map(advert -> toDto(advert,advertPhotoMapper.toDtoList(advertPhotoMap.get(advert.getId()))))
                .toList();

    }*/
}
