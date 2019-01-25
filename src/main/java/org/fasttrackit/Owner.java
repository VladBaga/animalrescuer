package org.fasttrackit;


public class Owner extends Human {

    private double coins;
    private Animal animal;

    public double feed(Owner owner, Animal animal, PetFood petFood){
        System.out.println(owner.getName() + " just fed " + animal.getName() + " with " + petFood.getName());
        double hungerLevel = animal.getHunger() - 1;
        System.out.println(animal.getName() + " 's hunger level is : " + hungerLevel);
        return hungerLevel;
    }

    public double play(Owner owner, Animal animal, Activity activity){
        System.out.println(owner.getName() + " just played with " + animal.getName() + " with " + activity.getName());
        double happyLevel = animal.getHappy() + 1;
        System.out.println(animal.getName() + "'s happiness " + happyLevel);
        return happyLevel;
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