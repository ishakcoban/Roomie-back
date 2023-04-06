package com.example.roomie.controller;

import com.example.roomie.entity.User;
import com.example.roomie.modal.dto.UserDto;
import com.example.roomie.modal.request.AuthenticationRequest;
import com.example.roomie.modal.request.RegisterRequest;
import com.example.roomie.modal.request.UserUpdateRequest;
import com.example.roomie.modal.response.AuthenticationResponse;
import com.example.roomie.modal.response.SuccessMessageResponse;
import com.example.roomie.service.AuthenticationService;
import com.example.roomie.service.UserService;
import com.example.roomie.utils.MdcConstant;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final AuthenticationService service;

    @GetMapping
    public ResponseEntity<UserDto> getUser() throws Exception {
        return ResponseEntity.ok(userService.getUserById(MDC.get(MdcConstant.X_USER_ID)));
    }

    @PatchMapping
    public ResponseEntity<?> updateUser(HttpServletRequest request,@RequestBody UserUpdateRequest userUpdateRequest) throws Exception {
        userService.updateUser(MDC.get(MdcConstant.X_USER_ID),userUpdateRequest);
        return ResponseEntity.ok(new SuccessMessageResponse("User updated successfully!",request.getServletPath()));
    }

}

