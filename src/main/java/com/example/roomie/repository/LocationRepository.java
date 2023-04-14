package com.example.roomie.repository;

import com.example.roomie.entity.Location;
import com.example.roomie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, String> {
}
