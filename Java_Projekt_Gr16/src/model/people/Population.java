package model.people;

public class Population {
    private int peasants; // Aktualna liczba kmieci
    private int maxPopulation; // Maksymalna liczba kmieci, jaką może pomieścić osada

    public Population() {
        this.peasants = 5; // Początkowa liczba kmieci
        this.maxPopulation = 5; // Początkowa maksymalna populacja (np. z jednego domu startowego)
    }

    // Zwiększa maksymalny limit populacji (np. po zbudowaniu domu)
    public void increaseMaxPopulation(int amount) {
        this.maxPopulation += amount;
    }

    // Zmienia liczbę kmieci (dodaje lub odejmuje)
    public void changePopulation(int amount) {
        this.peasants += amount;
        if (peasants > maxPopulation) { // Populacja nie może przekroczyć maksimum
            peasants = maxPopulation;
        }
        if (peasants < 0) { // Populacja nie może być ujemna
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
