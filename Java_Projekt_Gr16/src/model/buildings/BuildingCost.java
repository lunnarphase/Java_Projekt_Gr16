package model.buildings;

import java.util.HashMap;
import java.util.Map;

public class BuildingCost {
    private Map<String, Integer> costResources;

    public BuildingCost() {
        costResources = new HashMap<>();
    }

    public void addResourceCost(String resourceName, int amount) {
        costResources.put(resourceName, amount);
    }

    public Map<String, Integer> getCostResources() {
        return costResources;
    }
}
