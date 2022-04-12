package com.example.ewwithpostgres.controller;

import com.example.ewwithpostgres.dto.request.UserRequestDto;
import com.example.ewwithpostgres.dto.response.UserResponseDto;
import com.example.ewwithpostgres.model.User;
import com.example.ewwithpostgres.service.AuthenticationService;
import com.example.ewwithpostgres.service.mapper.UserMapper;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        User user = authenticationService.register(requestDto.getEmail(), requestDto.getPassword());
        return userMapper.toDto(user);
    }
}
