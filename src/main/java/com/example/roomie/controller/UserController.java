package com.example.roomie.controller;

import com.example.roomie.modal.dto.UserDto;
import com.example.roomie.modal.request.UserUpdateRequest;
import com.example.roomie.service.UserService;
import com.example.roomie.utils.MdcConstant;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public UserDto getUser() throws Exception {
        return userService.getUserById(Long.valueOf(MDC.get(MdcConstant.X_USER_ID)));
    }

    @PutMapping
    public void updateUser(@RequestBody UserUpdateRequest userUpdateRequest) throws Exception {
        userService.updateUser(Long.valueOf(MDC.get(MdcConstant.X_USER_ID)),userUpdateRequest);
    }

    @DeleteMapping
    public void deleteUser() throws Exception {
       userService.deleteUser(Long.valueOf(MDC.get(MdcConstant.X_USER_ID)));
    }

}

