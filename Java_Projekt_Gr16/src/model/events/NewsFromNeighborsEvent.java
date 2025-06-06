package model.events;

import service.GameService;

public class NewsFromNeighborsEvent implements Event {
    @Override
    public String getName() {
        return "Wieści z Sąsiedztwa";
    }

    @Override
    public String getDescription() {
        return "Do naszych granic docierają wieści o obfitych zbiorach w sąsiednich krainach. Ceny żywności na targach tymczasowo spadają.";
    }

    @Override
    public String getEffectDescription() {
        return "W tej turze koszt zakupu 1 surowca (jedzenia) jest obniżony z 100 do 75 złota."; // Zakładając domyślną cenę jedzenia 100, rzeczywista logika w GameService
    }

    @Override
    public void applyEffect(GameService gameService) {
        gameService.setFoodPriceModifier(0.75); // Zakładamy, że GameService ma metodę do ustawiania tymczasowego modyfikatora ceny jedzenia
    }
}
