package model.events;

import service.GameService;
import model.resources.ResourceInventory;

public class PestInfestationEvent implements Event {
    @Override
    public String getName() {
        return "Plaga w magazynach";
    }

    @Override
    public String getDescription() {
        return "Do spichlerza zakradły się myszy. Część zapasów w magazynach uległa zniszczeniu.";
    }

    @Override
    public String getEffectDescription() {
        return "–10 jednostek jedzenia.";
    }

    @Override
    public void applyEffect(GameService gameService) {
        ResourceInventory inventory = gameService.getResourceInventory();
        inventory.consumeResource("Jedzenie", 10);
    }
}
