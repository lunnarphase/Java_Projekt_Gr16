package model.people;

public class Population {
    private int peasants;
    private int maxPopulation;

    public Population() {
        this.peasants = 5; // Początkowa liczba kmieci
        this.maxPopulation = 5;
    }

    public void increaseMaxPopulation(int amount) {
        this.maxPopulation += amount;
    }

    public void changePopulation(int amount) {
        this.peasants += amount;
        if (peasants > maxPopulation) {
            peasants = maxPopulation;
        }
        if (peasants < 0) {
            peasants = 0;
        }
    }

    public int getPeasants() {
        return peasants;
    }

    public int getMaxPopulation() {
        return maxPopulation;
    }
}
