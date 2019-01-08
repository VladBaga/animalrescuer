package org.fasttrackit;

/**
 * :)
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Dog dog = new Dog();
        dog.name = "Spike";
        dog.age = 3;
        dog.health = 9;
        dog.hunger = 7;
        dog.happy = 9;
        dog.favfood = "Chicken";
        dog.favactivity = "Walk";
        dog.color = "black";
        dog.pawscount = 4;
        dog.gender = "male";
        dog.collar = true;
        dog.collarcolor = "red";

        Cat animal = new Cat();
        animal.name = "Tom";
        animal.age = 5;
        animal.health = 8;
        animal.hunger = 6;
        animal.happy = 7;
        animal.favfood = "Fish";
        animal.favactivity = "Scratch";
        animal.color = "grey";
        animal.pawscount = 4;
        animal.gender = "female";
        animal.sandbox = false;
        animal.sandboxcolor = "pink";


        Owner owner = new Owner(animal);
        owner.gender = "Male";
        owner.haircolor = "white";
        owner.coins = 512;
        owner.name = "Peter";
        owner.skincolor = "black";
        owner.eyecolor = "green";

        Doctor doctor = new Doctor(animal);
        doctor.name = "John";
        doctor.haircolor = "yellow";
        doctor.pills = true;
        doctor.vitamins = true;
        doctor.specialization = "Vet";
        doctor.eyecolor = "brown";

        Activity activity = new Activity();
        activity.name = "Walk";
        activity.name = "Boomerang";
        activity.name = "Bath";
        activity.name = "Race";
        activity.name = "Sleep";

        PetFood petFood = new PetFood();
        petFood.name = "Chicken";
        petFood.price = 512;
        petFood.quantity = 121;
        petFood.available = true;

        PetFood petFood2 = new PetFood();
        petFood2.name = "Bones";
        petFood2.price = 256;
        petFood2.available = true;
        petFood2.quantity = 312;

    }
}
