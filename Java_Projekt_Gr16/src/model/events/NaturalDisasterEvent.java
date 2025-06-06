package model.events;

import service.GameService;
import model.resources.ResourceInventory;

public class NaturalDisasterEvent implements Event {
    @Override
    public String getName() {
        return "Klęska żywiołowa";
    }

    @Override
    public String getDescription() {
        return "Gwałtowna klęska żywiołowa uszkodziła zabudowania i zapasy w osadzie.";
    }

    @Override
    public String getEffectDescription() {
        return "–10 jednostek drewna, –10 jednostek jedzenia, –2 punkty popularności.";
    }

    @Override
    public void applyEffect(GameService gameService) {
        ResourceInventory inventory = gameService.getResourceInventory();
        inventory.consumeResource("Drewno", 10);
        inventory.consumeResource("Jedzenie", 10);
        gameService.changePopularity(-2);
    }
}
