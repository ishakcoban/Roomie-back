package com.example.roomie.mapper;

import com.example.roomie.entity.User;
import com.example.roomie.modal.dto.UserDto;
import com.example.roomie.modal.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;
   // private final ValidationUtils validationUtils;

    public UserDto toDto(User user){

        return UserDto.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .deneme(user.getDeneme())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .gender(user.getGender())
                .email(user.getEmail())
                .photoUrl(user.getPhotoUrl())
                .build();
    }

    public User register(RegisterRequest request) throws Exception{

        return User.builder()
                .userName(request.getUserName())
                .deneme(request.getDeneme())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(request.getGender())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
    }
    public List<UserDto> listToDto(List<User> users){
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }

  /*  public UserResponse toResponse(Page<User> userPage){

        return UserResponse.builder()
                .content(listToDto(userPage.getContent()))
                .pageNo(userPage.getNumber())
                .pageSize(userPage.getSize())
                .totalPages(userPage.getTotalPages())
                .totalElements(userPage.getTotalElements())
                .last(userPage.isLast())
                .build();

    }*/

}
