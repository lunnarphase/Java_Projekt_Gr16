package model.buildings;

import model.resources.ResourceInventory;

public abstract class House implements Building {

    @Override
    public String getName() {
        return "Dom";
    }

    @Override
    public void performAction(ResourceInventory resourceInventory) {
        // Dom nie produkuje surowców
    }

    @Override
    public BuildingCost getBuildingCost() {
        BuildingCost cost = new BuildingCost();
        cost.addResourceCost("Drewno", 15);
        cost.addResourceCost("Kamień", 5);
        return cost;
    }
}
