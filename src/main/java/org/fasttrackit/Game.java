package org.fasttrackit;

import com.sun.corba.se.spi.activation.ActivatorOperations;

import javax.print.Doc;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Game {

    Owner owner;
    Animal animal;
    Doctor doctor;

    private List<PetFood> availableFood = new ArrayList<>();
    private Activity[] availableActivities = new Activity[10];

    public void start(){
        initFood(1);
        initActivities(2);
        displayFood();
        displayActivities();
    }

    private void initFood(int foodCount){
        for (int i = 0; i < foodCount; i++) {
            PetFood petFood = new PetFood("Chicken");
            PetFood petFood2 = new PetFood("Fish");
            PetFood petFood3 = new PetFood("Milk");
            PetFood petFood4 = new PetFood("Mice");
            PetFood petFood5 = new PetFood("Bones");
            availableFood.add(0, petFood);
            availableFood.add(1, petFood2);
            availableFood.add(2, petFood3);
            availableFood.add(3, petFood4);
            availableFood.add(4, petFood5);
        }
    }

    private void initActivities(int activitiesCount){

    Activity activity1 = new Activity("The ball");
    Activity activity2 = new Activity("Walk");

    availableActivities[0] = activity1;
    availableActivities[1] = activity2;
}

    private void displayFood(){
        System.out.println("Available food is : ");
        for (int i = 0; i < availableFood.size(); i++){
            System.out.println(availableFood.get(i).getName());
        }
    }

    private void displayActivities() {
        System.out.println("Available activities are : ");
        for (Activity activity : availableActivities) {
            if (activity != null) {
                System.out.println(activity.getName());
            }
        }
    }

    public Game() {
        this.owner = owner;
        this.animal = animal;
        this.doctor = doctor;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
