package model.buildings;

public class SimpleHouse extends House {
    private int workersRequired = 0;
    private int assignedWorkers = 0;

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