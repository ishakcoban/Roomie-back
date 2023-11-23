package com.example.roomie.modal.dto;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.Location;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavouriteAdvertDto {

    private String id;
    private AdvertDto advertDto;
    private List<AdvertPhotoDto> photos;
}
