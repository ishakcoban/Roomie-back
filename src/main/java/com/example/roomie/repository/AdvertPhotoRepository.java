package com.example.roomie.repository;

import com.example.roomie.entity.AdvertPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertPhotoRepository extends JpaRepository<AdvertPhoto, String> {

    List<AdvertPhoto> findAllByUserId(String userId);
}
