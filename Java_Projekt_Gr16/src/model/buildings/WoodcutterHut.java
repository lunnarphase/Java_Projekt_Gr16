package model.buildings;

import model.resources.ResourceInventory;

public class WoodcutterHut implements Building {
    private int workersRequired = 2; // Wymagana liczba pracowników do osiągnięcia pełnej efektywności chatki drwala.
    private int assignedWorkers = 0;

    @Override
    public String getName() {
        return "Chatka Drwala";
    }

    @Override
    public void performAction(ResourceInventory resourceInventory, double productionModifier) {
        if (assignedWorkers > 0) {
            int baseProduction = assignedWorkers * 5; // Każdy pracownik produkuje 5 jednostek drewna.
            int actualProduction = (int) (baseProduction * productionModifier);
            resourceInventory.addResource("Drewno", actualProduction);
            System.out.println(getName() + " wyprodukowała " + actualProduction + " jednostek drewna." + (productionModifier != 1.0 ? " (produkcja zmodyfikowana przez wyidarzene losowe)" : ""));
        } else {
            System.out.println(getName() + " nie ma pracowników i nie produkuje surowców.");
        }
    }

    @Override
    public BuildingCost getBuildingCost() {
        BuildingCost cost = new BuildingCost();
        cost.addResourceCost("Drewno", 20);
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
