package com.example.roomie.mapper;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.User;
import com.example.roomie.modal.request.AdvertRequest;
import com.example.roomie.modal.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdvertMapper {

    /*public AdvertDto toDto(Advert user){

        return AdvertDto.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .gender(user.getGender())
                .email(user.getEmail())
                .photoUrl(user.getPhotoUrl())
                .build();
    }*/
    public static Advert postAdvert(AdvertRequest advertRequest) throws Exception{

        return Advert.builder()
                .header(advertRequest.getHeader())
                .description(advertRequest.getDescription())
                .price(advertRequest.getPrice())
                .build();
    }
}
