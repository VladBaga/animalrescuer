package org.fasttrackit;


public class Owner extends Human {

    private double coins;
    private Animal animal;

    public double getCoins() {
        return coins;
    }

    public void setCoins(double coins) {
        this.coins = coins;
    }

    @Override
    public Animal getAnimal() {
        return animal;
    }

    @Override
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Owner(Animal animal) {
        super(animal);
    }
}
