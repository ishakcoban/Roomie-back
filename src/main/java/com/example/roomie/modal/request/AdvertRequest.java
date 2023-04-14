package com.example.roomie.modal.request;

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
    private int price;
}