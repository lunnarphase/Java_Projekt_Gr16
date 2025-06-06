package model.buildings;

import model.resources.ResourceInventory;

import java.util.ArrayList;
import java.util.List;

public class BuildingManager {
    private List<Building> buildings; // Lista wszystkich budynków w osadzie

    public BuildingManager() {
        buildings = new ArrayList<>();
    }

    // Dodaje nowy budynek do listy
    public void addBuilding(Building building) {
        buildings.add(building);
    }

    // Wykonuje akcje produkcyjne dla wszystkich budynków
    // Przekazuje modyfikator produkcji do każdego budynku
    public void performBuildingsActions(ResourceInventory resourceInventory, double productionModifier) {
        for (Building building : buildings) {
            building.performAction(resourceInventory, productionModifier);
        }
    }

    // Zwraca liczbę wszystkich budynków
    public int getBuildingsCount() {
        return buildings.size();
    }

    // Zwraca listę wszystkich budynków
    public List<Building> getBuildings() {
        return buildings;
    }
}
