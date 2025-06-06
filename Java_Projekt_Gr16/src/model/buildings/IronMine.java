package model.buildings;

import model.resources.ResourceInventory;

public class IronMine implements Building {
    private int workersRequired = 2;
    private int assignedWorkers = 0;

    @Override
    public String getName() {
        return "Kopalnia Żelaza";
    }

    @Override
    public void performAction(ResourceInventory resourceInventory, double productionModifier) {
        if (assignedWorkers > 0) {
            int baseProduction = assignedWorkers * 5; // Każdy pracownik produkuje 5 jednostek żelaza.
            int actualProduction = (int) (baseProduction * productionModifier);
            resourceInventory.addResource("Żelazo", actualProduction);
            System.out.println(getName() + " wyprodukowała " + actualProduction + " jednostek żelaza." + (productionModifier != 1.0 ? " (produkcja zmodyfikowana przez wydarzenie losowe)" : ""));
        } else {
            System.out.println(getName() + " nie ma pracowników i nie produkuje surowców.");
        }
    }

    @Override
    public BuildingCost getBuildingCost() {
        BuildingCost cost = new BuildingCost();
        cost.addResourceCost("Drewno", 40);
        cost.addResourceCost("Kamień", 20);
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