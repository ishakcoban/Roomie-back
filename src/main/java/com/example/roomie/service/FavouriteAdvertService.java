package com.example.roomie.service;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.AdvertPhoto;
import com.example.roomie.entity.FavouriteAdvert;
import com.example.roomie.entity.User;
import com.example.roomie.mapper.AdvertMapper;
import com.example.roomie.mapper.FavouriteAdvertMapper;
import com.example.roomie.modal.dto.AdvertDto;
import com.example.roomie.modal.dto.FavouriteAdvertDto;
import com.example.roomie.repository.AdvertPhotoRepository;
import com.example.roomie.repository.AdvertRepository;
import com.example.roomie.repository.FavouriteAdvertRepository;
import com.example.roomie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavouriteAdvertService {
    private final AdvertRepository advertRepository;
    private final UserRepository userRepository;
    private final FavouriteAdvertMapper favouriteAdvertMapper;
    private final FavouriteAdvertRepository favouriteAdvertRepository;
    private final AdvertPhotoRepository advertPhotoRepository;
    private final AdvertMapper advertMapper;
    public List<AdvertDto> getAllFavouriteAdvertsByUser(Long userId) throws Exception {
        List<FavouriteAdvert> favouriteAdverts = favouriteAdvertRepository.findAllByUserId(userId);
        List<Advert> adverts = favouriteAdverts.stream()
                .map(FavouriteAdvert::getAdvert)
                .collect(Collectors.toList());
        List<AdvertPhoto> advertPhotos = advertPhotoRepository.findAllByUserId(userId);

        return null/*advertMapper.toDtoList(adverts,advertPhotos)*/;
    }

    public void changeFavouriteAdvertStatus(Long userId,Long advertId) throws Exception {

        Advert existedAdvert = advertRepository.findById(advertId).orElseThrow();
        User existedUser = userRepository.findById(userId).orElseThrow();

        FavouriteAdvert favouriteAdvert = favouriteAdvertRepository.findByUserIdAndAdvertId(userId,advertId);

        if (favouriteAdvert == null){
            FavouriteAdvert newFavouriteAdvert = favouriteAdvertMapper.createFavouriteAdvert(existedAdvert,existedUser);
            favouriteAdvertRepository.save(newFavouriteAdvert);
        }else {
            favouriteAdvertRepository.delete(favouriteAdvert);
        }

    }
}
