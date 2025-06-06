package model.buildings;

import model.resources.ResourceInventory;

public class Quarry implements Building {
    private int workersRequired = 2; // Wymagana liczba pracowników do osiągnięcia pełnej efektywności kamieniołomu.
    private int assignedWorkers = 0;

    @Override
    public String getName() {
        return "Kamieniołom";
    }

    @Override
    public void performAction(ResourceInventory resourceInventory, double productionModifier) {
        if (assignedWorkers > 0) {
            int baseProduction = assignedWorkers * 4; // Każdy pracownik produkuje 4 jednostki kamienia.
            int actualProduction = (int) (baseProduction * productionModifier);
            resourceInventory.addResource("Kamień", actualProduction);
            System.out.println(getName() + " wyprodukował " + actualProduction + " jednostek kamienia." + (productionModifier != 1.0 ? " (produkcja zmodyfikowana przez wydarzenie losowe)" : ""));
        } else {
            System.out.println(getName() + " nie ma pracowników i nie produkuje surowców.");
        }
    }

    @Override
    public BuildingCost getBuildingCost() {
        BuildingCost cost = new BuildingCost();
        cost.addResourceCost("Drewno", 30);
        cost.addResourceCost("Kamień", 15);
        return cost;
    }

    @Override
    public int getWorkersRequired() {
        return workersRequired;
    }

    @Override
    public int getAssignedWorkers() {
        return assignedWorkers;
    }

    @Override
    public void setAssignedWorkers(int workers) {
        this.assignedWorkers = workers;
    }
}