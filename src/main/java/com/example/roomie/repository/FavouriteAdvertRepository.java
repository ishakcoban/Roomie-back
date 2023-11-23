package com.example.roomie.repository;

import com.example.roomie.entity.FavouriteAdvert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavouriteAdvertRepository extends JpaRepository<FavouriteAdvert, String> {

    FavouriteAdvert findByUserIdAndAdvertId(String userId, String advertId);
    List<FavouriteAdvert> findAllByUserId(String userId);
}
