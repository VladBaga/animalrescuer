package org.fasttrackit;

import java.sql.SQLOutput;

/**
 * :)
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Dog dog = new Dog();
        dog.setName("Spike");
        dog.setAge(3);
        dog.setHealth(9);
        dog.setHunger(4);
        dog.setHappy(8);
        dog.setFavfood("Chicken");
        dog.setFavactivity("Walk");
        dog.setColor("black");
        dog.setPawscount(4);
        dog.setGender("Male");
        dog.setCollar(true);
        dog.setCollarcolor("red");

        Cat animal = new Cat();
        animal.setName("Tom");
        animal.setAge(5);
        animal.setHealth(10);
        animal.setHunger(5);
        animal.setHappy(7);
        animal.setFavfood("Fish");
        animal.setFavactivity("Ball");
        animal.setColor("grey");
        animal.setPawscount(4);
        animal.setGender("Female");
        animal.setSandbox(false);
        animal.setSandboxcolor("pink");


        Owner owner = new Owner(animal);
        owner.setGender("Male");
        owner.setHaircolor("white");
        owner.setCoins(512);
        owner.setName("Peter");
        owner.setSkincolor("black");
        owner.setEyecolor("green");

        Doctor doctor = new Doctor(animal);
        doctor.setName("John");
        doctor.setHaircolor("blonde");
        doctor.setPills(true);
        doctor.setVitamins(true);
        doctor.setSpecialization("Vet");
        doctor.setEyecolor("brown");

        Activity activity = new Activity();
        activity.setName("The ball");

        PetFood petFood = new PetFood();
        petFood.setName("Chicken");
        petFood.setPrice(512);
        petFood.setQuantity(121);
        petFood.setAvailable(true);

        PetFood petFood2 = new PetFood();
        petFood2.setName("Fish");
        petFood2.setPrice(256);
        petFood2.setAvailable(true);
        petFood2.setQuantity(312);

        System.out.println(owner.getName()+ Owner.feed + dog.getName() + " with " + petFood.getName());
        System.out.println(owner.getName()+ Owner.play + "with " + animal.getName() + " with " + activity.getName());
    }
}
