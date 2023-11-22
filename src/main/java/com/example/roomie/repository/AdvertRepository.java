package com.example.roomie.repository;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.Location;
import com.example.roomie.modal.dto.AdvertDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertRepository extends JpaRepository<Advert, String> {

    List<Advert> findAllByUserId(String userId);
}
