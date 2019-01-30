package org.fasttrackit;

public class PetFood {

    private String name;
    private int price;
    private int quantity;
    private boolean available;

    public PetFood(String name) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
