package com.example.ewwithpostgres.service;

import com.example.ewwithpostgres.model.User;

public interface AuthenticationService {
    User register(String userName, String password);
}
