package com.accenture.applicationlocationvehicule.utils;

import org.springframework.stereotype.Component;

@Component
public class Validations {
    public static boolean isValidName(String name) {
        return name != null && name.matches("^[A-Za-zÀ-ÖØ-öø-ÿ' -]+$");
    }

    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }

}
