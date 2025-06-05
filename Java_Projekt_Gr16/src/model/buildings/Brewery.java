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
    public void performAction(ResourceInventory resourceInventory) {
        if (assignedWorkers > 0) {
            int production = assignedWorkers * 2; // Każdy pracownik produkuje piwo dla siebie i kolegi
            resourceInventory.addResource("Piwo", production);
            System.out.println(getName() + " wyprodukował " + production + " jednostek piwa.");
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