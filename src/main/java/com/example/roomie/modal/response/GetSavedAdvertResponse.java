package com.example.roomie.modal.response;

import com.example.roomie.entity.Advert;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetSavedAdvertResponse {

    private String id;
    private Advert advert;
}
