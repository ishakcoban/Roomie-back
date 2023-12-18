package com.example.roomie.modal.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertDto {

    private long id;
    private String userName;
    private String header;
    private String description;
    private String city;
    private String district;
    private String neighbourhood;
    private LocalDateTime updatedOn;
    private List<AdvertPhotoDto> photos;
    private int rooms;
    private int floorArea;
    private int price;
}
