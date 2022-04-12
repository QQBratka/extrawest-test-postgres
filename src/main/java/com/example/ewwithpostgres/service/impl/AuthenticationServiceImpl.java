package com.example.ewwithpostgres.service.impl;

import com.example.ewwithpostgres.model.Role;
import com.example.ewwithpostgres.model.User;
import com.example.ewwithpostgres.service.AuthenticationService;
import com.example.ewwithpostgres.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(Role.USER);
        userService.save(user);
        return user;
    }
}
