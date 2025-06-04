package model.buildings;

import model.resources.ResourceInventory;

public class IronMine implements Building {

    @Override
    public String getName() {
        return "Kopalnia Żelaza";
    }

    @Override
    public void performAction(ResourceInventory resourceInventory) {
        // 5 jednostek żelaza na turę
        resourceInventory.addResource("Żelazo", 5);
        System.out.println("Kopalnia Żelaza wyprodukowała 5 jednostek żelaza.");
    }
}
