package model.events;

import service.GameService;
import model.resources.ResourceInventory;
import java.util.Random;

public class ArtisanVisitEvent implements Event {
    private String randomResource;

    @Override
    public String getName() {
        return "Wizyta rzemieślnika";
    }

    @Override
    public String getDescription() {
        return "Do Twojej osady przybył wędrowny mędrzec rzemieślnik, który podzielił się z mieszkańcami swoją wiedzą i umiejętnościami.";
    }

    @Override
    public String getEffectDescription() {
        if (randomResource == null) {
             determineResource(); // Upewnij się, że zasób jest określony, jeśli opis jest wywoływany jako pierwszy
        }
        return "+5 jednostek " + randomResource.toLowerCase() + ", +2 punkty popularności.";
    }

    private void determineResource() {
        Random random = new Random();
        String[] resources = {"Drewno", "Kamień", "Żelazo", "Jedzenie", "Piwo"};
        randomResource = resources[random.nextInt(resources.length)];
    }

    @Override
    public void applyEffect(GameService gameService) {
        if (randomResource == null) {
            determineResource(); // Określ losowy zasób, jeśli jeszcze nie został określony
        }
        ResourceInventory inventory = gameService.getResourceInventory();
        inventory.addResource(randomResource, 5);
        gameService.changePopularity(2);
    }
}