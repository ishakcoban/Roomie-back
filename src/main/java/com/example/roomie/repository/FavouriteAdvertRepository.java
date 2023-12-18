package com.example.roomie.repository;

import com.example.roomie.entity.FavouriteAdvert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavouriteAdvertRepository extends JpaRepository<FavouriteAdvert, Long> {

    FavouriteAdvert findByUserIdAndAdvertId(Long userId, Long advertId);
    List<FavouriteAdvert> findAllByUserId(Long userId);
}
