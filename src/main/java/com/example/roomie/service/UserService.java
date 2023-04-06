package com.example.roomie.service;

import com.example.roomie.entity.User;
import com.example.roomie.exception.RestResponseEntityExceptionHandler;
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

        User user = userRepository.findById(id).orElseThrow();
        UserDto user1 = userMapper.toDto(userRepository.findById(id).orElseThrow());
       // System.out.println(userRepository.findById(id).orElseThrow().getUsername());
        System.out.println(userRepository.findByEmail(userRepository.findById(id).orElseThrow().getEmail()).orElseThrow().getUsername());
        //System.out.println(userMapper.toDto(userRepository.findById(id).orElseThrow()).getUserName());
        return userMapper.toDto(userRepository.findById(id).orElseThrow());
    }

    public void updateUser(String id,User user){
        userMapper.toDto(userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found!")));
        userRepository.save(user);
    }
}
