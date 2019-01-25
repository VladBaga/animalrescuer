package org.fasttrackit;


public class Owner extends Human {

    private double coins;
    private Animal animal;

    public void feed(Owner owner, Animal animal, PetFood petFood) {

        System.out.println(owner.getName() + " just fed " + animal.getName() + " with " + petFood.getName());
        double hungerLevel = animal.getHunger() - 1;
        System.out.println(animal.getName() + " 's hunger level is : " + hungerLevel);

        if (animal.getFavfood().equals(petFood.getName())) {
            double happyLevel = animal.getHappy() + 1;
            System.out.println("and happy status is : " + happyLevel);
        }
    }

    public void play(Owner owner, Animal animal, Activity activity){
        System.out.println(owner.getName() + " just played with " + animal.getName() + " with " + activity.getName());
        double happyLevel = animal.getHappy() + 1;
        System.out.println(animal.getName() + "'s happiness : " + happyLevel);

        if(animal.getFavactivity().equals(activity.getName())){
            double happyLevel2 = animal.getHappy() + 2;
            System.out.println("That's " + animal.getName() + " 's favourite activity, happiness : " + happyLevel2);
        }
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