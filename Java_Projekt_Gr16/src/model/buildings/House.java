package model.buildings;

import model.resources.ResourceInventory;

public class House implements Building {

    @Override
    public String getName() {
        return "Dom";
    }

    @Override
    public void performAction(ResourceInventory resourceInventory) {}
}
