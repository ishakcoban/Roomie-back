package com.example.roomie.controller;

import com.example.roomie.entity.Advert;
import com.example.roomie.entity.AdvertPhoto;
import com.example.roomie.modal.dto.AdvertDto;
import com.example.roomie.modal.dto.AdvertPhotoDto;
import com.example.roomie.modal.dto.UserDto;
import com.example.roomie.modal.request.AdvertRequest;
import com.example.roomie.modal.request.FilterAdvertRequest;
import com.example.roomie.service.AdvertPhotoService;
import com.example.roomie.service.AdvertService;
import com.example.roomie.utils.MdcConstant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("api/adverts")
@RequiredArgsConstructor
public class AdvertController {

    private final AdvertService advertService;
    private final AdvertPhotoService advertPhotoService;

    @PostMapping(value = "/upload", consumes ={"multipart/form-data", "application/json"} )
    public void uploadFiles(@RequestPart("images") MultipartFile[] images, @RequestPart("otherInformation") String otherInformation) throws Exception {
        advertService.createAdvert(otherInformation,images, Long.valueOf(MDC.get(MdcConstant.X_USER_ID)));
    }

    @GetMapping("/getByUser")
    public UserDto getAllAdvertsByUser() throws Exception {
        return advertService.getAllAdvertsByUser(Long.valueOf(MDC.get(MdcConstant.X_USER_ID)));
    }

    @GetMapping("/getAll")
    public List<AdvertDto> getAllAdverts() throws Exception {
        return advertService.getAllAdverts();
    }

    @GetMapping("/{id}")
    public AdvertDto getAdvert(@PathVariable Long id) throws Exception {
        return advertService.getAdvert(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAdvert(@PathVariable Long id) throws Exception {
        advertService.deleteAdvert(id);
    }

    @PutMapping("/{id}")
    public void updateAdvert(@PathVariable Long id,@RequestBody AdvertRequest advertRequest) throws Exception {
        advertService.updateAdvert(id,advertRequest);
    }

    @PostMapping("/filter")
    public List<AdvertDto> filterAdvert(@RequestBody FilterAdvertRequest filterAdvertRequest) throws Exception {
        return advertService.filterAdvert(filterAdvertRequest);
    }

}
