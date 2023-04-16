package com.example.roomie.modal.dto;

import com.example.roomie.entity.Location;
import com.example.roomie.entity.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertDto {

    private String id;
    private String header;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private Location location;
    private User user;
    private int price;
}
