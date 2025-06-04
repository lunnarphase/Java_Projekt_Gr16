package model.resources;

public interface Resource {
    String getName();
    int getQuantity();
    void addQuantity(int amount);
}
