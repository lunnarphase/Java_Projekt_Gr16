package model.resources;

import java.util.HashMap;
import java.util.Map;

public class ResourceInventory {
    private Map<String, Integer> resources;

    public ResourceInventory() {
        resources = new HashMap<>();
        resources.put("Drewno", 0);
        resources.put("Kamień", 0);
        resources.put("Żelazo", 0);
        resources.put("Jedzenie", 100); // Początkowe jedzenie
        resources.put("Piwo", 0);
    }

    public void addResource(String name, int quantity) {
        resources.put(name, resources.getOrDefault(name, 0) + quantity);
    }

    public boolean consumeResource(String name, int quantity) {
        int currentQuantity = resources.getOrDefault(name, 0);
        if (currentQuantity >= quantity) {
            resources.put(name, currentQuantity - quantity);
            return true;
        } else {
            return false;
        }
    }

    public int getResourceQuantity(String name) {
        return resources.getOrDefault(name, 0);
    }

    public void displayResources() {
        System.out.println("Aktualne surowce:");
        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}