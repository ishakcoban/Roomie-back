package com.example.roomie.repository;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertRepository extends JpaRepository<Advert, String> {
}
