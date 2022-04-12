package com.example.ewwithpostgres.service;

import com.example.ewwithpostgres.model.User;

public interface UserService {
    User save(User user);

    void delete(Long id);
}
