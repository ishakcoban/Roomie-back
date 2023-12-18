package com.example.roomie.repository;

import com.example.roomie.entity.Advert;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface AdvertRepository extends JpaRepository<Advert, Long>, JpaSpecificationExecutor<Advert> {
    List<Advert> findAllByUserId(Long userId);
    List<Advert> findAll(Specification<Advert> spec);
}
