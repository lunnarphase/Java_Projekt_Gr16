package utils;

import java.util.Scanner;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String message) {
        System.out.println(message);
        while (!scanner.hasNextInt()) {
            System.out.println("Proszę wpisać liczbę całkowitą.");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Oczyszczenie bufora
        return value;
    }

    public static String getStringInput(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}