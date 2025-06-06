package main;

import service.GameService;

public class Game {
    public static void main(String[] args) {
        GameService gameService = new GameService(); // Tworzenie instancji serwisu gry
        gameService.startGame(); // Rozpoczęcie gry
    }
}
