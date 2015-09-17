package com.realdolmen.course.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by YDEAX41 on 16/09/2015.
 */
public class EmailConstraintValidator implements ConstraintValidator<Passenger.Email, String>{

    @Override
    public void initialize(Passenger.Email s) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email.toUpperCase().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
    }
}
