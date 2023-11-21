package com.example.roomie.service;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.AdvertPhoto;
import com.example.roomie.entity.User;
import com.example.roomie.mapper.AdvertMapper;
import com.example.roomie.mapper.AdvertPhotoMapper;
import com.example.roomie.modal.request.AdvertRequest;
import com.example.roomie.repository.AdvertPhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class AdvertPhotoService {
    private final AdvertPhotoRepository advertPhotoRepository;
    private final AdvertPhotoMapper advertPhotoMapper;
    public void savePhotos(MultipartFile[] files) throws Exception {



    }

}
