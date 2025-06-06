package model.resources;

import java.util.HashMap;
import java.util.Map;

public class ResourceInventory {
    private Map<String, Integer> resources; // Mapa przechowująca nazwy surowców i ich ilości

    public ResourceInventory() {
        resources = new HashMap<>();

        // Inicjalizacja startowych surowców
        resources.put("Drewno", 50);
        resources.put("Kamień", 30);
        resources.put("Żelazo", 20);
        resources.put("Jedzenie", 0); // Początkowo brak jedzenia, gracz musi je wyprodukować lub kupić
        resources.put("Piwo", 0);    // Początkowo brak piwa
    }

    // Dodaje określoną ilość surowca do inwentarza
    public void addResource(String name, int quantity) {
        resources.put(name, resources.getOrDefault(name, 0) + quantity);
    }

    // Konsumuje (odejmuje) określoną ilość surowca z inwentarza
    // Zwraca true, jeśli operacja się powiodła (było wystarczająco surowca), w przeciwnym razie false
    public boolean consumeResource(String name, int quantity) {
        int currentQuantity = resources.getOrDefault(name, 0);
        if (currentQuantity >= quantity) {
            resources.put(name, currentQuantity - quantity);
            return true;
        } else {
            // Opcjonalnie: można tutaj ustawić ilość na 0, jeśli próba zużycia przekracza dostępną ilość,
            // ale obecna logika zwraca po prostu false, co jest często preferowane.
            return false;
        }
    }

    // Zwraca aktualną ilość danego surowca
    public int getResourceQuantity(String name) {
        return resources.getOrDefault(name, 0); // Zwraca 0, jeśli surowiec nie istnieje w mapie
    }

    // Wyświetla aktualny stan surowców na konsoli
    public void displayResources() {
        System.out.println("Aktualne surowce:");
        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}