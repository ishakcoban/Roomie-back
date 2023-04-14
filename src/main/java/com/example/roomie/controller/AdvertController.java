package com.example.roomie.controller;

import com.example.roomie.entity.Advert;
import com.example.roomie.modal.dto.AdvertDto;
import com.example.roomie.modal.request.AdvertRequest;
import com.example.roomie.service.AdvertService;
import com.example.roomie.utils.MdcConstant;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/adverts")
@RequiredArgsConstructor
public class AdvertController {

    private final AdvertService advertService;

    @PostMapping
    public void postAdvert(@RequestBody AdvertRequest advertRequest) throws Exception {
        advertService.createAdvert(advertRequest, MDC.get(MdcConstant.X_USER_ID));
    }

    @GetMapping
    public AdvertDto getAdvert() throws Exception {
        return advertService.getAdvert("344cdf63-5a97-4459-b175-60195fc34ebc");
    }
}
