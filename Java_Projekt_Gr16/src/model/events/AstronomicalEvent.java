package model.events;

import service.GameService;

public class AstronomicalEvent implements Event {
    @Override
    public String getName() {
        return "Wydarzenie astronomiczne";
    }

    @Override
    public String getDescription() {
        return "Na niebie dochodzi do zaćmienia słońca. Kmiecie szepczą o znakach od bogów, ale po chwili wszystko wraca do normy.";
    }

    @Override
    public String getEffectDescription() {
        return "Brak.";
    }

    @Override
    public void applyEffect(GameService gameService) {
        // Brak efektu dla tego wydarzenia
    }
}
