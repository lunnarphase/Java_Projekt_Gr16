package model.buildings;

import java.util.HashMap;
import java.util.Map;

public class BuildingCost {
    private Map<String, Integer> costResources; // Mapa przechowująca koszt surowców (NazwaSurowca, Ilość)

    public BuildingCost() {
        costResources = new HashMap<>();
    }

    // Dodaje koszt surowca do całkowitego kosztu budowy
    public void addResourceCost(String resourceName, int amount) {
        costResources.put(resourceName, amount);
    }

    // Zwraca mapę kosztów surowców
    public Map<String, Integer> getCostResources() {
        return costResources;
    }
}
