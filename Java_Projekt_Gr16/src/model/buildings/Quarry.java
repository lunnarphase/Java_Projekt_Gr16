package model.buildings;

import model.resources.ResourceInventory;

public class Quarry implements Building {
    private int workersRequired = 2; // Maksymalna liczba pracowników
    private int assignedWorkers = 0;

    @Override
    public String getName() {
        return "Kamieniołom";
    }

    @Override
    public void performAction(ResourceInventory resourceInventory) {
        if (assignedWorkers > 0) {
            int production = assignedWorkers * 4; // Każdy pracownik produkuje 4 kamienia
            resourceInventory.addResource("Kamień", production);
            System.out.println(getName() + " wyprodukował " + production + " jednostek kamienia.");
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