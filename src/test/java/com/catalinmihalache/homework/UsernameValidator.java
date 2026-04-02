package com.catalinmihalache.homework;

import java.util.Scanner;

public class UsernameValidator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username;
        boolean isValid = false;

        do {
            System.out.print("Introdu un username: ");
            username = scanner.nextLine();

            // Regula 1 & 2: Verificăm spațiile și lungimea folosind o buclă for
            boolean hasSpace = false;
            boolean hasDigit = false;

            for (int i = 0; i < username.length(); i++) {
                char ch = username.charAt(i);
                if (Character.isWhitespace(ch)) {
                    hasSpace = true;
                    break; // Ieșim din for dacă găsim un spațiu (Regula 2)
                }
                if (Character.isDigit(ch)) {
                    hasDigit = true;
                }
            }

            // Validare Regula 2 (Fără spații)
            if (hasSpace) {
                System.out.println("Eroare: Username-ul nu trebuie să conțină spații.");
                continue; // Reluăm bucla do-while imediat
            }

            // Validare Regula 1 (Lungime 6-12)
            if (username.length() < 6 || username.length() > 12) {
                System.out.println("Eroare: Lungimea trebuie să fie între 6 și 12 caractere.");
            } 
            // Validare Regula 3 (Cel puțin o cifră)
            else if (!hasDigit) {
                System.out.println("Eroare: Username-ul trebuie să conțină cel puțin o cifră.");
            } 
            else {
                // Dacă trece de toate verificările
                isValid = true;
            }

        } while (!isValid);

        System.out.println("Username acceptat: " + username);
        scanner.close();
    }
}
