package com.example.roomie.modal.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavouriteAdvertDto {

    private long id;
    private AdvertDto advertDto;
}
