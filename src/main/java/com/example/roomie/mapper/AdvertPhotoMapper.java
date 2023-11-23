package com.example.roomie.mapper;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.AdvertPhoto;
import com.example.roomie.modal.dto.AdvertDto;
import com.example.roomie.modal.dto.AdvertPhotoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AdvertPhotoMapper {

    public AdvertPhotoDto toDto(AdvertPhoto advertPhoto) {

        return AdvertPhotoDto.builder()
                .id(advertPhoto.getId())
                .photoOrder(advertPhoto.getPhotoOrder())
                .fileData(advertPhoto.getFileData())
                .contentType(advertPhoto.getContentType())
                .fileName(advertPhoto.getFileName())
                .build();
    }
    public AdvertPhoto createAdvertPhoto(MultipartFile image,Advert advert,int photoOrder) throws Exception{

        return AdvertPhoto.builder()
                .photoOrder(photoOrder)
                .fileData(image.getBytes())
                .contentType(image.getContentType())
                .fileName(image.getOriginalFilename())
                .advert(advert)
                .user(advert.getUser())
                .build();
    }

   public java.util.List<AdvertPhotoDto> toDtoList(java.util.List<AdvertPhoto> advertPhotos) {
       return advertPhotos.stream().map(this::toDto).collect(Collectors.toList());
   }
}
