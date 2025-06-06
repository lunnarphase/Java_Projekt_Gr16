package model.buildings;

import model.resources.ResourceInventory;

public class Brewery implements Building {
    private int workersRequired = 2;
    private int assignedWorkers = 0;

    @Override
    public String getName() {
        return "Browar";
    }

    @Override
    public void performAction(ResourceInventory resourceInventory, double productionModifier) {
        if (assignedWorkers > 0) {
            int baseProduction = assignedWorkers * 2; // Każdy pracownik produkuje 2 jednostki piwa.
            int actualProduction = (int) (baseProduction * productionModifier);
            resourceInventory.addResource("Piwo", actualProduction);
            System.out.println(getName() + " wyprodukował " + actualProduction + " jednostek piwa." + (productionModifier != 1.0 ? " (produkcja zmodyfikowana przez wydarzenie losowe)" : ""));
        } else {
            System.out.println(getName() + " nie ma pracowników i nie produkuje surowców.");
        }
    }

    @Override
    public BuildingCost getBuildingCost() {
        BuildingCost cost = new BuildingCost();
        cost.addResourceCost("Drewno", 25);
        cost.addResourceCost("Kamień", 10);
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