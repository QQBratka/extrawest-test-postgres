package com.example.ewwithpostgres.controller;

import com.example.ewwithpostgres.dto.request.UserRequestDto;
import com.example.ewwithpostgres.dto.response.UserResponseDto;
import com.example.ewwithpostgres.model.User;
import com.example.ewwithpostgres.service.UserService;
import com.example.ewwithpostgres.service.mapper.UserMapper;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;

    @PostMapping
    @PreAuthorize("hasAuthority('users:write')")
    public UserResponseDto create(@RequestBody @Valid UserRequestDto userRequestDto) {
        return userMapper.toDto(userService.save(userMapper.toModel(userRequestDto)));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    public UserResponseDto update(@PathVariable Long id,
                                  @RequestBody @Valid UserRequestDto requestDto) {
        User user = userMapper.toModel(requestDto);
        user.setId(id);
        return userMapper.toDto(userService.save(user));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
