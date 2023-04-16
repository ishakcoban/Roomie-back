package com.example.roomie.controller;

import com.example.roomie.entity.SavedAdvert;
import com.example.roomie.modal.dto.AdvertDto;
import com.example.roomie.modal.dto.SavedAdvertDto;
import com.example.roomie.repository.SavedAdvertRepository;
import com.example.roomie.service.AuthenticationService;
import com.example.roomie.service.SavedAdvertService;
import com.example.roomie.service.UserService;
import com.example.roomie.utils.MdcConstant;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/savedAdverts")
@RequiredArgsConstructor
public class SavedAdvertController {

    private final SavedAdvertService savedAdvertService;

    @GetMapping
    public List<SavedAdvertDto> getAllByUser() throws Exception {
        return savedAdvertService.getAllByUser(MDC.get(MdcConstant.X_USER_ID));
    }

    @GetMapping("/{advertId}")
    public void saveAdvert(@PathVariable String advertId) throws Exception {
        savedAdvertService.saveAdvert(MDC.get(MdcConstant.X_USER_ID),advertId);
    }

    @DeleteMapping("/{savedAdvertId}")
    public void deleteSavedAdvertByUser(@PathVariable String savedAdvertId) throws Exception {
        savedAdvertService.deleteSavedAdvertByUser(savedAdvertId);
    }
}
