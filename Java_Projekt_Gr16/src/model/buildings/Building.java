package model.buildings;

import model.resources.ResourceInventory;

public interface Building {
    String getName();
    void performAction(ResourceInventory resourceInventory);
    BuildingCost getBuildingCost();
    int getWorkersRequired();
    int getAssignedWorkers();
    void setAssignedWorkers(int workers);
}
