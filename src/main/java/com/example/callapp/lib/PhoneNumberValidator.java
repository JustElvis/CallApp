package com.example.callapp.lib;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {
    private static final String PHONE_NUMBER_VALIDATION_REGEX = "^(1[ \\-\\+]{0,3}|\\+1[ -\\+]"
            + "{0,3}|\\+1|\\+)?((\\(\\+?1-"
            + "[2-9][0-9]{1,2}\\))|(\\(\\+?[2-8][0-9][0-9]\\))|(\\(\\+?"
            + "[1-9][0-9]\\))|(\\(\\+?[17]\\))|(\\([2-9][2-9]"
            + "\\))|([ \\-\\.]{0,3}[0-9]{2,4}))?([ \\-\\.][0-9])?"
            + "([ \\-\\.]{0,3}[0-9]{2,4}){2,3}$";

    @Override
    public boolean isValid(String field, ConstraintValidatorContext context) {
        return field != null && field.matches(PHONE_NUMBER_VALIDATION_REGEX);
    }
}
