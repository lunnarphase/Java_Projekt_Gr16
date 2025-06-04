package model.buildings;

import model.resources.ResourceInventory;

public class WoodcutterHut implements Building {

    @Override
    public String getName() {
        return "Chatka Drwala";
    }

    @Override
    public void performAction(ResourceInventory resourceInventory) {
        // 10 jednostek drewna na turę
        resourceInventory.addResource("Drewno", 10);
        System.out.println("Chatka Drwala wyprodukowała 10 jednostek drewna.");
    }
}
