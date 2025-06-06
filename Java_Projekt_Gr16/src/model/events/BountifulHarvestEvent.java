package model.events;

import service.GameService;
import model.resources.ResourceInventory;

public class BountifulHarvestEvent implements Event {
    @Override
    public String getName() {
        return "Obfite zbiory";
    }

    @Override
    public String getDescription() {
        return "Wyjątkowo sprzyjająca pogoda sprawiła, że chłopi wrócili z lasów i pól z obfitymi plonami, których nikt się nie spodziewał.";
    }

    @Override
    public String getEffectDescription() {
        return "+15 jednostek jedzenia.";
    }

    @Override
    public void applyEffect(GameService gameService) {
        ResourceInventory inventory = gameService.getResourceInventory();
        inventory.addResource("Jedzenie", 15);
    }
}
