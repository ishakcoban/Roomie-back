package com.example.roomie.controller;


import com.example.roomie.entity.AdvertPhoto;
import com.example.roomie.repository.AdvertPhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/advertPhotos")
@RequiredArgsConstructor
public class AdvertPhotoController {
private final AdvertPhotoRepository advertPhotoRepository;
    @GetMapping("/getAll")
    public List<AdvertPhoto> getAll() throws Exception {
        return advertPhotoRepository.findAll();
    }
}
