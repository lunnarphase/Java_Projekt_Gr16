package service;

import java.io.*;
import java.util.*;

public class RankingManager {
    private static final String FILE_NAME = "ranking.txt"; // Nazwa pliku do przechowywania rankingu
    private static final int MAX_ENTRIES = 10; // Maksymalna liczba wpisów w rankingu

    // Wczytuje ranking z pliku
    public List<ScoreEntry> loadRanking() {
        List<ScoreEntry> ranking = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";", 2); // Dzieli linię na nick i wynik
                if (parts.length == 2) {
                    ranking.add(new ScoreEntry(parts[0], Long.parseLong(parts[1])));
                }
            }
        } catch (IOException ignored) {} // Ignoruje błąd, jeśli plik nie istnieje (np. przy pierwszym uruchomieniu)
        return ranking;
    }

    // Zapisuje ranking do pliku
    public void saveRanking(List<ScoreEntry> ranking) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (ScoreEntry entry : ranking) {
                pw.println(entry.getNickname() + ";" + entry.getScore()); // Zapisuje każdy wpis w formacie nick;wynik
            }
        } catch (IOException ignored) {} // Ignoruje błędy zapisu
    }

    // Dodaje nowy wynik do rankingu
    public void addScore(ScoreEntry entry) {
        List<ScoreEntry> ranking = loadRanking();
        ranking.add(entry);
        ranking.sort(null); // Sortuje ranking (ScoreEntry implementuje Comparable)
        if (ranking.size() > MAX_ENTRIES) {
            ranking = ranking.subList(0, MAX_ENTRIES); // Ogranicza ranking do MAX_ENTRIES najlepszych wyników
        }
        saveRanking(ranking);
    }

    // Wyświetla ranking na konsoli
    public void displayRanking() {
        List<ScoreEntry> ranking = loadRanking();
        System.out.println("\n\n#=========================#");
        System.out.println("Tabela legendarnych lordów");
        System.out.println("#=========================#");
        for (int i = 0; i < MAX_ENTRIES; i++) {
            if (i < ranking.size()) {
                ScoreEntry e = ranking.get(i);
                System.out.println((i + 1) + ". " + e.getNickname() + " - " + e.getScore());
            } else {
                System.out.println((i + 1) + "."); // Puste miejsca, jeśli ranking nie jest pełny
            }
        }
    }
}