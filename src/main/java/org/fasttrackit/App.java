package org.fasttrackit;

import javax.print.Doc;
import java.sql.SQLOutput;

/**
 * :)
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Game game = new Game();
        game.start();

       Animal dog = new Dog();
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
       ((Dog) dog).setCollar(true);
       ((Dog) dog).setCollarcolor("red");

       Animal cat = new Cat();
       cat.setName("Tom");
       cat.setAge(5);
       cat.setHealth(10);
       cat.setHunger(5);
       cat.setHappy(7);
       cat.setFavfood("Fish");
       cat.setFavactivity("The ball");
       cat.setColor("grey");
       cat.setPawscount(4);
       cat.setGender("Female");
       ((Cat) cat).setSandbox(false);
       ((Cat) cat).setSandboxcolor("pink");


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

       Activity activity = new Activity("The ball");

       PetFood petFood = new PetFood("Chicken");
       petFood.setName("Chicken");
       petFood.setPrice(512);
       petFood.setQuantity(121);
       petFood.setAvailable(true);

       PetFood petFood2 = new PetFood("Fish");
       petFood2.setName("Fish");
       petFood2.setPrice(256);
       petFood2.setAvailable(true);
       petFood2.setQuantity(312);

       owner.feed(owner,dog,petFood);
       owner.play(owner,cat,activity);

       dog.happiness();
       cat.happiness();

    }

}
