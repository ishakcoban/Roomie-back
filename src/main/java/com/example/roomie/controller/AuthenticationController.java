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

  private final AuthenticationService service;

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> authenticate(
          @RequestBody AuthenticationRequest request
  ) throws Exception {
    return ResponseEntity.ok(service.login(request));
  }

  @PostMapping("/register")
  public ResponseEntity<User> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }

}
