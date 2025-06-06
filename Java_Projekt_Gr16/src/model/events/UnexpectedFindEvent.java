package model.events;

import service.GameService;
import model.resources.ResourceInventory;
import java.util.Random;

public class UnexpectedFindEvent implements Event {
    private String resourceWon;
    private int amountWon;

    @Override
    public String getName() {
        return "Niespodziewane znalezisko";
    }

    @Override
    public String getDescription() {
        return "Robotnicy pracujący przy wydobyciu natrafili na nieoczekiwane złoże cennego surowca.";
    }

    @Override
    public String getEffectDescription() {
        if (resourceWon == null) {
            // Określ efekt przed zwróceniem opisu, jeśli nie został jeszcze zastosowany
            determineEffect();
        }
        return "+" + amountWon + " jednostek " + resourceWon.toLowerCase() + ".";
    }

    private void determineEffect() {
        Random random = new Random();
        int choice = random.nextInt(3); // Losowy wybór jednego z trzech możliwych zasobów
        switch (choice) {
            case 0:
                resourceWon = "Kamień";
                amountWon = 10;
                break;
            case 1:
                resourceWon = "Żelazo";
                amountWon = 10;
                break;
            case 2:
                resourceWon = "Drewno";
                amountWon = 15;
                break;
        }
    }

    @Override
    public void applyEffect(GameService gameService) {
        if (resourceWon == null) {
            determineEffect(); // Upewnij się, że efekt (zasób i ilość) jest określony
        }
        ResourceInventory inventory = gameService.getResourceInventory();
        inventory.addResource(resourceWon, amountWon);
    }
}
