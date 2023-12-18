package com.example.roomie.mapper;

import com.example.roomie.entity.User;
import com.example.roomie.modal.dto.UserDto;
import com.example.roomie.modal.request.RegisterRequest;
import lombok.NonNull;
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
    private final AdvertMapper advertMapper;
    private final FavouriteAdvertMapper favouriteAdvertMapper;
    public UserDto toDto(User user){

        return UserDto.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .gender(user.getGender())
                .email(user.getEmail())
                .adverts(advertMapper.toDtoList(user.getAdverts()))
                .photoUrl(user.getPhotoUrl())
                .build();
    }

    public User register(RegisterRequest request) throws Exception{

        return User.builder()
                .userName(request.getUserName())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .gender(request.getGender())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
    }
    public List<UserDto> toDtoList(List<User> users){
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }

}
