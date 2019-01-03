package org.fasttrackit;

/**
 * :)
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Animal animal = new Animal();
        animal.name = "Spike";
        animal.age = 3;
        animal.health = 9;
        animal.hunger = 7;
        animal.happy = 9;
        animal.favfood = "Chicken";
        animal.favactivity = "Walk";
        animal.color = "black";
        animal.pawscount = 4;
        animal.gender = "male";
        animal.type = "Dog";

        Owner owner = new Owner();
        owner.gender = "Male";
        owner.haircolor = "white";
        owner.coins = 512;
        owner.name = "Peter";
        owner.skincolor = "black";
        owner.eyecolor = "green";

        Doctor doctor = new Doctor();
        doctor.name = "John";
        doctor.haircolor = "yellow";
        doctor.pills = true;
        doctor.vitamins = true;
        doctor.specialization = "Vet";
        doctor.eyecolor = "brown";

        Activity activity = new Activity();
        activity.name = "Walk";
        activity.name = "Ball";
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


        owner.animal = animal;
    }
}
