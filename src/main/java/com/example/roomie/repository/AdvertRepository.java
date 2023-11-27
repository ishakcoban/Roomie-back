package com.example.roomie.repository;

import com.example.roomie.entity.Advert;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertRepository extends JpaRepository<Advert, String> {
    List<Advert> findAllByUserId(String userId);
    List<Advert> findAll(Specification<Advert> spec);
}
