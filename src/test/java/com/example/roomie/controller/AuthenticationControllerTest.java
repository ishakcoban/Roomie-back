package com.example.roomie.controller;

import com.example.roomie.entity.User;
import com.example.roomie.mapper.UserMapper;
import com.example.roomie.modal.request.RegisterRequest;
import com.example.roomie.service.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.mockito.quality.Strictness;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthenticationControllerTest {

    @Mock
    private UserMapper userMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationService authenticationService;

    @InjectMocks
    private AuthenticationController authenticationController;

    @Test
    public void it_should_register() throws Exception {
        //BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //when(passwordEncoder.bCryptPasswordEncoder()).thenReturn(bCryptPasswordEncoder);
        // given
        RegisterRequest request = RegisterRequest.builder()
                .firstName(null)
                .lastName("asddsa")
                .userName("asd")
                .photoUrl(null)
                .gender("male")
                .email("user@gmail.com")
                .password(passwordEncoder.encode("user123"))
                .build();

        doNothing().when(authenticationService).register(request);
        //when(authenticationService.register(request)).thenReturn(expected);
        //doNothing().when(authenticationService).register(request);
        //doThrow(new ResponseStatusException(HttpStatus.FORBIDDEN, "Forbidden"))
        //        .when(authenticationController)
        //        .register(request);
        assertEquals(HttpStatus.BAD_REQUEST.value(), 403);
        //User result = userMapper.register(request);

        /*User user = User.builder()
                .id(1L)
                .userName("user")
                .email("user@gmail.com")
                .password(passwordEncoder.encode("user123"))
                .build();*/



        //assertEquals(user.getPocketName(), result.getPocketName());
        //assertEquals(user.getEmail(), result.getEmail());

        // when
        // then

    }

    @Test
    public void it_should_register1() throws Exception {
        //BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //when(passwordEncoder.bCryptPasswordEncoder()).thenReturn(bCryptPasswordEncoder);
        System.out.println("---------------------------------------------------");

        RegisterRequest request = RegisterRequest.builder()
                .firstName("user")
                .email("user@gmail.com")
                .password(passwordEncoder.encode("user123"))
                .build();

        User user = User.builder()
                .id(1L)
                .userName("user")
                .email("user@gmail.com")
                .password(passwordEncoder.encode("user123"))
                .build();

        User result = userMapper.register(request);

        //assertEquals(user.getPocketName(), result.getPocketName());
        assertEquals(user.getEmail(), result.getEmail());

    }
}
