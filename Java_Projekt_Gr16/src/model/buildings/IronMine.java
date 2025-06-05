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
    public void performAction(ResourceInventory resourceInventory) {
        if (assignedWorkers > 0) {
            int production = assignedWorkers * 5; // Każdy pracownik produkuje 5 żelaza
            resourceInventory.addResource("Żelazo", production);
            System.out.println(getName() + " wyprodukowała " + production + " jednostek żelaza.");
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