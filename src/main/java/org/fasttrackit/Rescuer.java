package org.fasttrackit;


public class Rescuer extends Human {

    private double coins;
    private Animal animal;

    public Rescuer() {

    }

    public void feed(Rescuer rescuer, Animal animal, PetFood petFood) {

        System.out.println(rescuer.getName() + " just fed " + animal.getName() + " with " + petFood.getName());
        double hungerLevel = animal.getHunger() - 1;
        System.out.println(animal.getName() + " 's hunger level is : " + String.format( "%.0f", hungerLevel));

        if (animal.getFavfood().equals(petFood.getName())) {
            double happyLevel = animal.getHappy() + 1;
            System.out.println("and happy status is : " + String.format( "%.0f", happyLevel));
        }
    }

    public void play(Rescuer rescuer, Animal animal, Activity activity){
        System.out.println(rescuer.getName() + " just played with " + animal.getName() + " with " + activity.getName());
        double happyLevel = animal.getHappy() + 1;
        System.out.println(animal.getName() + "'s happiness : " + String.format( "%.0f",happyLevel));

        if(animal.getFavactivity().equals(activity.getName())){
            double happyLevel2 = animal.getHappy() + 2;
            System.out.println("That's " + animal.getName() + " 's favourite activity, happiness : " + String.format( "%.0f", happyLevel2));
        }
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