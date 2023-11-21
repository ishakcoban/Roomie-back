package com.example.roomie.modal.request;

import com.example.roomie.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdvertRequest {
    private String header;
    private String description;
    private Location location;
    private int floorArea;
    private int rooms;
    private int price;
}