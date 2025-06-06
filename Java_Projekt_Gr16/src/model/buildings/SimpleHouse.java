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

    // Metoda performAction jest dziedziczona z klasy bazowej House i nie wymaga nadpisywania w tej klasie,
    // ponieważ SimpleHouse (prosty dom mieszkalny) również nie generuje żadnych surowców.
    // Funkcjonalność odziedziczona z House jest wystarczająca; domy jedynie zwiększają limit populacji.
}