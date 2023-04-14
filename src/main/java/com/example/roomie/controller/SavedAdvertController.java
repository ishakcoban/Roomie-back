package com.example.roomie.controller;

import com.example.roomie.entity.SavedAdvert;
import com.example.roomie.modal.dto.AdvertDto;
import com.example.roomie.repository.SavedAdvertRepository;
import com.example.roomie.service.AuthenticationService;
import com.example.roomie.service.SavedAdvertService;
import com.example.roomie.service.UserService;
import com.example.roomie.utils.MdcConstant;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/savedAdverts")
@RequiredArgsConstructor
public class SavedAdvertController {

    private final SavedAdvertService savedAdvertService;

    @GetMapping
    public List<SavedAdvert> getAllByUser() throws Exception {
        return savedAdvertService.getAllByUser(MDC.get(MdcConstant.X_USER_ID));
    }
}
