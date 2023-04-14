package com.example.roomie.modal.dto;

import com.example.roomie.entity.Location;
import lombok.*;

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
    private int price;
}
