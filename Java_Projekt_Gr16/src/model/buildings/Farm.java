package model.buildings;

import model.resources.ResourceInventory;

public class Farm implements Building {
    private int workersRequired = 2;
    private int assignedWorkers = 0;

    @Override
    public String getName() {
        return "Farma";
    }

    @Override
    public void performAction(ResourceInventory resourceInventory) {
        if (assignedWorkers > 0) {
            int production = assignedWorkers * 6; // Każdy pracownik produkuje 6 jedzenia
            resourceInventory.addResource("Jedzenie", production);
            System.out.println(getName() + " wyprodukowała " + production + " jednostek jedzenia.");
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