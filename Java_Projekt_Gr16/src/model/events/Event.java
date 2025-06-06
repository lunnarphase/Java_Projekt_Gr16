package model.events;

import service.GameService;

// Interfejs reprezentujący zdarzenie w grze
public interface Event {
    // Zwraca nazwę zdarzenia
    String getName();
    // Zwraca opis zdarzenia
    String getDescription();
    // Zwraca opis efektu zdarzenia
    String getEffectDescription();
    // Stosuje efekt zdarzenia na stanie gry
    void applyEffect(GameService gameService);
}
