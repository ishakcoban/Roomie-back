package com.example.roomie.modal.dto;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.AdvertPhoto;
import com.example.roomie.entity.Location;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertPhotoDto {

    private String id;
    private int photoOrder;
    private String fileName;
    private String contentType;
    private byte[] fileData;
}
