package model.buildings;

import model.resources.ResourceInventory;

public interface Building {
    String getName();
    void performAction(ResourceInventory resourceInventory);
}
