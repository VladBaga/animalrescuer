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
        animal.name = "Dog";
        animal.color = "black";
        animal.pawscount = 4;
        animal.fed = true

        Owner owner = new Owner();
        owner.gender = "Male";
        owner.haircolor = "white";
        owner.food = true;
        owner.pills = false;
        owner.coins = 512;

        Doctor doctor = new Doctor();
        doctor.name = "John";
        doctor.haircolor = "yellow";
        doctor.food = true;
        doctor.pills = true;
        doctor.vitamins = true;

        owner.animal = animal;
    }
}
