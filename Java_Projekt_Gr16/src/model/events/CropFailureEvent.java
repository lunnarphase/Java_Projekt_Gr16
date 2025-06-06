package model.events;

import service.GameService;
import model.resources.ResourceInventory;

public class CropFailureEvent implements Event {
    @Override
    public String getName() {
        return "Klęska nieurodzaju";
    }

    @Override
    public String getDescription() {
        return "Plaga szkodników zniszczyła znaczną część tegorocznych plonów na polach.";
    }

    @Override
    public String getEffectDescription() {
        return "–15 jednostek jedzenia, –2 punkty popularności.";
    }

    @Override
    public void applyEffect(GameService gameService) {
        ResourceInventory inventory = gameService.getResourceInventory();
        inventory.consumeResource("Jedzenie", 15); // Zakładamy, że consumeResource obsługuje przypadki, gdy brakuje zasobów
        gameService.changePopularity(-2);
    }
}
