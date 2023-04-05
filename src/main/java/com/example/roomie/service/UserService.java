package com.example.roomie.service;

import com.example.roomie.mapper.UserMapper;
import com.example.roomie.modal.dto.UserDto;
import com.example.roomie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public void checkEmailExist(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The email already taken!");
        }
    }

    public UserDto getUserById(String id){
        System.out.println(id);
        return userMapper.toDto(userRepository.findById(id).orElseThrow());
    }
}
