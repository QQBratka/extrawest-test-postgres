package com.example.ewwithpostgres.controller;

import com.example.ewwithpostgres.dto.request.UserRequestDto;
import com.example.ewwithpostgres.dto.response.UserResponseDto;
import com.example.ewwithpostgres.model.User;
import com.example.ewwithpostgres.repository.UserRepository;
import com.example.ewwithpostgres.service.AuthenticationService;
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
    private final UserRepository userRepository;
    private final AuthenticationService authenticationService;

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
        if (userRepository.findById(id).isPresent()) {
            user.setId(userRepository.findById(id).get().getId());
            user.setRole(userRepository.findById(id).get().getRole());
            return userMapper.toDto(userService.save(user));
        }
        return userMapper.toDto(authenticationService
                .register(requestDto.getEmail(), requestDto.getPassword()));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
