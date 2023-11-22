package com.example.roomie.mapper;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.FavouriteAdvert;
import com.example.roomie.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FavouriteAdvertMapper {

    public FavouriteAdvert createFavouriteAdvert(Advert advert, User user) throws Exception{

        return FavouriteAdvert.builder()
                .advert(advert)
                .user(user)
                .build();
    }
}
