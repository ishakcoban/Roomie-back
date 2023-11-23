package com.example.roomie.modal.dto;

import com.example.roomie.entity.AdvertPhoto;
import com.example.roomie.entity.Location;
import com.example.roomie.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertDto {

    private String id;
    private String header;
    private String description;
    private Location location;
    private List<AdvertPhotoDto> photos;
    private UserDto user;
    private int price;
}
