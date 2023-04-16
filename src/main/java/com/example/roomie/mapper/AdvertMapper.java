package com.example.roomie.mapper;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.User;
import com.example.roomie.modal.dto.AdvertDto;
import com.example.roomie.modal.request.AdvertRequest;
import com.example.roomie.modal.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AdvertMapper {
    private final UserMapper userMapper;

    public AdvertDto toDto(Advert advert){

        return AdvertDto.builder()
                .id(advert.getId())
                .header(advert.getHeader())
                .description(advert.getDescription())
                .price(advert.getPrice())
                .createdDate(advert.getCreatedDate())
                .updatedDate(advert.getUpdatedDate())
                .saved(advert.isSaved())
                .location(advert.getLocation())
                .user(userMapper.toDto(advert.getUser()))
                .build();
    }
    public static Advert createAdvert(AdvertRequest advertRequest,User user) throws Exception{

        return Advert.builder()
                .header(advertRequest.getHeader())
                .description(advertRequest.getDescription())
                .price(advertRequest.getPrice())
                .createdDate(LocalDateTime.now())
                .updatedDate(null)
                .user(user)
                .location(advertRequest.getLocation())
                .build();
    }
    public java.util.List<AdvertDto> toDtoList(java.util.List<Advert> adverts) {
        return adverts.stream().map(this::toDto).collect(Collectors.toList());
    }
}
