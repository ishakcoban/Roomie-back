package com.example.roomie.mapper;

import com.example.roomie.entity.AdvertPhoto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@RequiredArgsConstructor
public class AdvertPhotoMapper {

    public AdvertPhoto createAdvertPhoto(MultipartFile file) throws Exception{

        return AdvertPhoto.builder()
                .fileData(file.getBytes())
                .contentType(file.getContentType())
                .fileName(file.getOriginalFilename())
                .build();
    }
}
