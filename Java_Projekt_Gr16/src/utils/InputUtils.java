package utils;

import java.util.Scanner;

public class InputUtils {
    private static Scanner scanner = new Scanner(System.in); // Pojedyncza instancja Scannera dla całej aplikacji

    // Pobiera od użytkownika liczbę całkowitą
    public static int getIntInput(String message) {
        System.out.println(message); // Wyświetla komunikat dla użytkownika
        while (!scanner.hasNextInt()) { // Pętla dopóki użytkownik nie wprowadzi liczby całkowitej
            System.out.println("Proszę wpisać liczbę całkowitą.");
            scanner.next(); // Konsumuje nieprawidłowe dane wejściowe
        }
        int value = scanner.nextInt(); // Odczytuje liczbę całkowitą
        scanner.nextLine(); // Konsumuje znak nowej linii pozostały po nextInt()
        return value;
    }

    // Pobiera od użytkownika ciąg znaków
    public static String getStringInput(String message) {
        System.out.println(message); // Wyświetla komunikat dla użytkownika
        return scanner.nextLine(); // Odczytuje całą linię tekstu
    }
}