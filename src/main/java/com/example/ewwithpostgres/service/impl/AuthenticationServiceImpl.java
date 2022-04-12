package com.example.ewwithpostgres.service.impl;

import com.example.ewwithpostgres.model.Role;
import com.example.ewwithpostgres.model.User;
import com.example.ewwithpostgres.repository.UserRepository;
import com.example.ewwithpostgres.service.AuthenticationService;
import com.example.ewwithpostgres.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final UserRepository userRepository;

    @Override
    public User register(String email, String password) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("This email already in use!");
        }
        User user = new User(email, password, Role.USER);
        userService.save(user);
        return user;
    }
}
