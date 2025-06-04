package model.buildings;

import model.resources.ResourceInventory;

import java.util.ArrayList;
import java.util.List;

public class BuildingManager {
    private List<Building> buildings;

    public BuildingManager() {
        buildings = new ArrayList<>();
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public void performBuildingsActions(ResourceInventory resourceInventory) {
        for (Building building : buildings) {
            building.performAction(resourceInventory);
        }
    }

    public int getBuildingsCount() {
        return buildings.size();
    }
}
