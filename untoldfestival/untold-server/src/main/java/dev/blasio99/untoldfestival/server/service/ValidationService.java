package dev.blasio99.untoldfestival.server.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    private final Pattern usernamePattern = Pattern.compile("[A-Za-z]\\w{4,25}");
    private final Pattern passwordPattern = Pattern.compile("\\w{8,20}");
    
    public boolean validateUsername(String username) {
        return usernamePattern.matcher(username).matches();
    }

    public boolean validatePassword(String password) {
        return passwordPattern.matcher(password).matches();
    }

}