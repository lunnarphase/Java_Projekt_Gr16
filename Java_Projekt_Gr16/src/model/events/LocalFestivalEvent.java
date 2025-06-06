package model.events;

import service.GameService;
import model.resources.ResourceInventory;

public class LocalFestivalEvent implements Event {
    @Override
    public String getName() {
        return "Lokalny festyn";
    }

    @Override
    public String getDescription() {
        return "Mieszkańcy, pragnąc rozrywki, zorganizowali wielki festyn. Zabawa była przednia, ale kosztowna.";
    }

    @Override
    public String getEffectDescription() {
        return "–10 beczek piwa, –10 jednostek jedzenia, +5 punktów popularności.";
    }

    @Override
    public void applyEffect(GameService gameService) {
        ResourceInventory inventory = gameService.getResourceInventory();
        inventory.consumeResource("Piwo", 10);
        inventory.consumeResource("Jedzenie", 10);
        gameService.changePopularity(5);
    }
}
