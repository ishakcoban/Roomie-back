package com.example.roomie.repository;

import com.example.roomie.entity.SavedAdvert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavedAdvertRepository extends JpaRepository<SavedAdvert, String> {

    List<SavedAdvert> findAllByUserId(String userId);
}
