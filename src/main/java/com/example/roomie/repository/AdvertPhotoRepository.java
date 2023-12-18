package com.example.roomie.repository;

import com.example.roomie.entity.AdvertPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AdvertPhotoRepository extends JpaRepository<AdvertPhoto, Long>, JpaSpecificationExecutor<AdvertPhoto> {
    List<AdvertPhoto> findAllByUserId(Long userId);
}
