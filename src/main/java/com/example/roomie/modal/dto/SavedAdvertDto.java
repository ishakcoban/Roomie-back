package com.example.roomie.modal.dto;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.Location;
import com.example.roomie.entity.User;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavedAdvertDto {

    private String id;
    private Advert advert;
    private User user;

}
