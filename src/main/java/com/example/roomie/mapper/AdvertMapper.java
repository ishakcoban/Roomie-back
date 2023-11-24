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
    private final UserMapper userMapper;
    private final AdvertPhotoMapper advertPhotoMapper;

    public AdvertDto toDto(Advert advert,List<AdvertPhotoDto> advertPhotos) {

        return AdvertDto.builder()
                .id(advert.getId())
                .header(advert.getHeader())
                .description(advert.getDescription())
                .price(advert.getPrice())
                .city(advert.getCity())
                .district(advert.getDistrict())
                .neighbourhood(advert.getNeighbourhood())
                .user(userMapper.toDto(advert.getUser()))
                .photos(advertPhotos)
                .build();
    }
    public static Advert createAdvert(AdvertRequest advertRequest,User user) throws Exception{

        return Advert.builder()
                .header(advertRequest.getHeader())
                .description(advertRequest.getDescription())
                .price(advertRequest.getPrice())
                .user(user)
                .city(advertRequest.getCity())
                .district(advertRequest.getDistrict())
                .neighbourhood(advertRequest.getNeighbourhood())
                .build();
    }
    public List<AdvertDto> toDtoList(List<Advert> adverts,List<AdvertPhoto> advertPhotos) {

        Map<String, List<AdvertPhoto>> advertPhotoMap = advertPhotos.stream()
                .collect(Collectors.groupingBy(photo -> photo.getAdvert().getId()));

        return adverts.stream()
                .map(advert -> toDto(advert,advertPhotoMapper.toDtoList(advertPhotoMap.get(advert.getId()))))
                .toList();
    }
}
