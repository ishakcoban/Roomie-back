package com.example.roomie.controller;

import com.example.roomie.entity.User;
import com.example.roomie.modal.request.AuthenticationRequest;
import com.example.roomie.modal.request.RegisterRequest;
import com.example.roomie.modal.response.AuthenticationResponse;
import com.example.roomie.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) throws Exception {
        System.out.println(request);
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public void register(
            @RequestBody RegisterRequest request
    ) throws Exception {
        authService.register(request);
    }

}
