package com.example;

public class validationSystem {
    private String storedUsername;
    private String storedPassword;
    private String storedPhoneNumber;
    private String firstName;
    private String lastName;

    public boolean checkUserName(String username) {
        return username.length() >= 5 && username.contains("_");
    }

    public boolean checkPasswordComplexity(String password) {
        return password.matches("^.*(?=.{8,})(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!#$%&? \"]).*$");
    }

    public boolean checkPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^\\+27([0-9]{1,4})[-\\s]?([0-9]{1,15})$");
    }

    // Must return a String
    public String registerUser(String username, String password, String phoneNumber, String firstName, String lastName) {
        boolean valid = true;
        String message = "";

        if (!checkUserName(username)) {
            message += "Username is not correctly formatted. Please ensure that your username contains an underscore and is at least five characters in length.\n";
            valid = false;
        } else {
            message += "Username successfully captured.\n";
        }

        if (!checkPasswordComplexity(password)) {
            message += "Password is not correctly formatted; please ensure that the password contains at least eight characters, a letter, a number, and a special character.\n";
            valid = false;
        } else {
            message += "Password successfully captured.\n";
        }

        if (!checkPhoneNumber(phoneNumber)) {
            message += "Cell phone number incorrectly formatted or does not contain international code.\n";
            valid = false;
        } else {
            message += "Cell phone number successfully added.\n";
        }

        if (valid) {
            this.storedUsername = username;
            this.storedPassword = password;
            this.storedPhoneNumber = phoneNumber;
            this.firstName = firstName;
            this.lastName = lastName;
            message += "Registration successful.";
        } else {
            message += "Registration failed.";
        }

        return message;
    }

    public boolean login(String username, String password) {
        return username != null && password != null &&
               username.equals(this.storedUsername) &&
               password.equals(this.storedPassword);
    }

    public String returnLoginStatus(String username, String password) {
        if (login(username, password)) {
            return "Welcome " + firstName + " " + lastName + ", it's great to see you again!";
        } else {
            return "Login failed. Please check your username and password.";
        }
    }
}
