package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        validationSystem valSys = new validationSystem();

        // Registration
        System.out.println("==== Registration ====");
        System.out.print("Enter your first name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter your username: ");
        String username = sc.nextLine();

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        System.out.print("Enter your phone number: ");
        String phoneNumber = sc.nextLine();

        // Capture register result
        String regResult = valSys.registerUser(username, password, phoneNumber, firstName, lastName);
        System.out.println("\n" + regResult);

        if (!regResult.contains("Registration successful")) {
            System.out.println("Restart program to try again.");
            sc.close();
            return;
        }

        // Login
        System.out.println("\n==== Login ====");
        System.out.print("Enter your username: ");
        String lu = sc.nextLine();

        System.out.print("Enter your password: ");
        String lp = sc.nextLine();

        String status = valSys.returnLoginStatus(lu, lp);
        System.out.println(status);

        sc.close();
    }
}
