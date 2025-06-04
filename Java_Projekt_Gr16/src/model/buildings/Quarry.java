package model.buildings;

import model.resources.ResourceInventory;

public class Quarry implements Building {

    @Override
    public String getName() {
        return "Kamieniołom";
    }

    @Override
    public void performAction(ResourceInventory resourceInventory) {
        // 8 jednostek kamienia na turę
        resourceInventory.addResource("Kamień", 8);
        System.out.println("Kamieniołom wyprodukował 8 jednostek kamienia.");
    }
}
