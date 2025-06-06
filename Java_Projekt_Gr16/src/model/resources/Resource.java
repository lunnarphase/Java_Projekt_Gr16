package model.resources;

public interface Resource {
    String getName(); // Zwraca nazwę surowca
    int getQuantity(); // Zwraca aktualną ilość surowca
    void addQuantity(int amount); // Dodaje określoną ilość surowca
}
