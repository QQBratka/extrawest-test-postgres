package com.example.ewwithpostgres.security.validation;

import com.example.ewwithpostgres.repository.UserRepository;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    private static final String EMAIL_VALIDATION_REGEX = "^(.+)@(.+)$";
    private final UserRepository userRepository;

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        return field != null
                && field.matches(EMAIL_VALIDATION_REGEX)
                && userRepository.findByEmail(field).isEmpty();
    }
}
