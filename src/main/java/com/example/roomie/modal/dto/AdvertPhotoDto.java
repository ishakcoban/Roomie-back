package com.example.roomie.modal.dto;

import lombok.*;

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
