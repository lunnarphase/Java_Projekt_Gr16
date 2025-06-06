package model.events;

import service.GameService;

public class ScientistArtistVisitEvent implements Event {
    @Override
    public String getName() {
        return "Odwiedziny Naukowca/Artysty";
    }

    @Override
    public String getDescription() {
        return "Słynny kartograf odwiedza Twoje włości, aby uwiecznić je na mapie. Pozostawił Ci jedynie marną kopię.";
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
