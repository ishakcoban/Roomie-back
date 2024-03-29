package com.example.roomie.modal.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdvertRequest {
    private String header;
    private String description;
    private String city;
    private String district;
    private String neighbourhood;
    private int floorArea;
    private int rooms;
    private int price;
}