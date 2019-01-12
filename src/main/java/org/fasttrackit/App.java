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

        Cat cat = new Cat();
        cat.setName("Tom");
        cat.setAge(5);
        cat.setHealth(10);
        cat.setHunger(5);
        cat.setHappy(7);
        cat.setFavfood("Fish");
        cat.setFavactivity("Ball");
        cat.setColor("grey");
        cat.setPawscount(4);
        cat.setGender("Female");
        cat.setSandbox(false);
        cat.setSandboxcolor("pink");


        Owner owner = new Owner(cat);
        owner.setGender("Male");
        owner.setHaircolor("white");
        owner.setCoins(512);
        owner.setName("Peter");
        owner.setSkincolor("black");
        owner.setEyecolor("green");

        Doctor doctor = new Doctor(dog);
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

        owner.feed(dog,petFood);
        owner.play(cat,activity);

        dog.happiness(dog);
        cat.happiness(cat);

    }

}
