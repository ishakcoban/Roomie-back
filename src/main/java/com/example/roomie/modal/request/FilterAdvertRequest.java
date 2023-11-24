package com.example.roomie.modal.request;

import com.example.roomie.modal.enums.DateStatus;
import com.example.roomie.modal.enums.PriceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilterAdvertRequest {

    private DateStatus dateStatus;
    private PriceStatus priceStatus;
    private String city;
    private String district;
    private String neighbourhood;
    private int floorArea;
    private int rooms;
    private int price;
}
