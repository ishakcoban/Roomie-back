package com.example.roomie.mapper;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.AdvertPhoto;
import com.example.roomie.entity.User;
import com.example.roomie.modal.dto.AdvertDto;
import com.example.roomie.modal.dto.AdvertPhotoDto;
import com.example.roomie.modal.request.AdvertRequest;
import com.example.roomie.modal.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AdvertMapper {
    private final AdvertPhotoMapper advertPhotoMapper;
    public AdvertDto toDto(Advert advert){

        return AdvertDto.builder()
                .id(advert.getId())
                .header(advert.getHeader())
                .description(advert.getDescription())
                .price(advert.getPrice())
                .city(advert.getCity())
                .district(advert.getDistrict())
                .neighbourhood(advert.getNeighbourhood())
                .rooms(advert.getRooms())
                .floorArea(advert.getFloorArea())
                .updatedOn(advert.getUpdatedOn())
                .userName(advert.getUser().getUserName())
                .photos(advertPhotoMapper.toDtoList(advert.getAdvertPhotos()))
                .build();
    }
    public Advert createAdvert(AdvertRequest advertRequest,User user) throws Exception{

        return Advert.builder()
                .header(advertRequest.getHeader())
                .description(advertRequest.getDescription())
                .price(advertRequest.getPrice())
                .user(user)
                .city(advertRequest.getCity())
                .district(advertRequest.getDistrict())
                .neighbourhood(advertRequest.getNeighbourhood())
                .rooms(advertRequest.getRooms())
                .floorArea(advertRequest.getFloorArea())
                .build();
    }
    public Advert updateAdvert(Advert existedAdvert,AdvertRequest advertRequest) throws Exception{

        return Advert.builder()
                .id(existedAdvert.getId())
                .header(advertRequest.getHeader())
                .description(advertRequest.getDescription())
                .price(advertRequest.getPrice())
                .user(existedAdvert.getUser())
                .city(advertRequest.getCity())
                .district(advertRequest.getDistrict())
                .neighbourhood(advertRequest.getNeighbourhood())
                .rooms(advertRequest.getRooms())
                .floorArea(advertRequest.getFloorArea())
                .build();
    }
    public List<AdvertDto> toDtoList(List<Advert> adverts) {
        return adverts.stream().map(this::toDto).collect(Collectors.toList());
    }
}
