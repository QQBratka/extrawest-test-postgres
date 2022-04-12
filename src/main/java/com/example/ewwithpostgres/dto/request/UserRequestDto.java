package com.example.ewwithpostgres.dto.request;

import javax.validation.constraints.Size;
import com.example.ewwithpostgres.security.validation.FieldsValueMatch;
import com.example.ewwithpostgres.security.validation.ValidEmail;
import lombok.Getter;

@FieldsValueMatch(field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match!")
@Getter
public class UserRequestDto {
    @ValidEmail
    private String email;
    @Size(min = 6, max = 12)
    private String password;
    private String repeatPassword;
}
