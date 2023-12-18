package com.example.roomie.modal.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private long id;
    private String userName;
    private String firstName;
    private String lastName;
    private String gender;
    private String photoUrl;
    private String email;
    private List<AdvertDto> adverts;
    private List<FavouriteAdvertDto> favouriteAdverts;

}
