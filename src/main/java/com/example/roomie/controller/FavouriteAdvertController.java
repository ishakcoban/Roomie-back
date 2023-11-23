package com.example.roomie.controller;

import com.example.roomie.modal.dto.AdvertDto;
import com.example.roomie.service.FavouriteAdvertService;
import com.example.roomie.utils.MdcConstant;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/favouriteAdverts")
@RequiredArgsConstructor
public class FavouriteAdvertController {
    private final FavouriteAdvertService favouriteAdvertService;

    @GetMapping
    public List<AdvertDto> getAllFavouriteAdvertsByUser() throws Exception {

        return favouriteAdvertService.getAllFavouriteAdvertsByUser(MDC.get(MdcConstant.X_USER_ID));
    }
    @PatchMapping("/{advertID}")
    public void changeFavouriteAdvertStatus(@PathVariable String advertID) throws Exception {
        favouriteAdvertService.changeFavouriteAdvertStatus(MDC.get(MdcConstant.X_USER_ID),advertID);
    }
}