package com.example.roomie.modal.dto;

import lombok.*;

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
    private String city;
    private String district;
    private String neighbourhood;
    private List<AdvertPhotoDto> photos;
    private UserDto user;
    private int price;
}
