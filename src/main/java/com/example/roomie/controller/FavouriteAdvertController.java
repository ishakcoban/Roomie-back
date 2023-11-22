package com.example.roomie.controller;

import com.example.roomie.service.FavouriteAdvertService;
import com.example.roomie.utils.MdcConstant;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/savedAdverts")
@RequiredArgsConstructor
public class FavouriteAdvertController {
    private final FavouriteAdvertService favouriteAdvertService;
    @PatchMapping("/{advertID}")
    public void changeFavouriteAdvertStatus(@PathVariable String advertID) throws Exception {

        favouriteAdvertService.changeFavouriteAdvertStatus(MDC.get(MdcConstant.X_USER_ID),advertID);
    }
}