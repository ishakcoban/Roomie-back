package com.example.roomie.controller;

import com.example.roomie.entity.Advert;
import com.example.roomie.modal.request.AdvertRequest;
import com.example.roomie.service.AdvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/adverts")
@RequiredArgsConstructor
public class AdvertController {

    private final AdvertService advertService;

    @PostMapping
    public ResponseEntity<?> postAdvert(@RequestBody AdvertRequest advertRequest) throws Exception {
        advertService.postAdvert(advertRequest);
        return ResponseEntity.ok(/*userService.getUserById(MDC.get(MdcConstant.X_USER_ID))*/"");
    }

    @GetMapping
    public ResponseEntity<?> getAdvert() throws Exception {
        return ResponseEntity.ok(advertService.getAdvert("344cdf63-5a97-4459-b175-60195fc34ebc"));
    }
}
