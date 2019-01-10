package org.fasttrackit;


public class Owner extends Human {

    private double coins;
    private Animal animal;

    public void feed(Animal animal, PetFood petFood){
        System.out.println(" Your human just fed " + animal.getName() + " with " + petFood.getName());
        return;
    }

    public void play(Animal animal, Activity activity){
        System.out.println(" Your human just played with " + animal.getName() + " with " + activity.getName());
        return;
    }

    public Owner(Animal animal) {
        super(animal);
        this.coins = coins;
    }

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
}