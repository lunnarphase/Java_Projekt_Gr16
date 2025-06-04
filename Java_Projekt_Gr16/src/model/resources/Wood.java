package model.resources;

public class Wood implements Resource {
    private int quantity;

    public Wood(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return "Drewno";
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void addQuantity(int amount) {
        this.quantity += amount;
    }
}
