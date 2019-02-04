package org.fasttrackit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class Game {

    private Owner owner;
    private Animal animal;
    private Doctor doctor;

    private List<PetFood> availableFood = new ArrayList<>();
    private Activity[] availableActivities = new Activity[10];
    private List<Animal> availableAnimals = new ArrayList<>();

    public void start() {
        System.out.println("Welcome to PetRescuer !");
        getOwnerNameFromUser();
        initAnimal();
        displayAnimals();
        getAnimalFromUser();
        getAnimalNameFromUser();
        // initFood();
        // initActivities();
        // displayFood();
        /// displayActivities();
    }

    private String getOwnerNameFromUser() {
        System.out.println("Please enter a name for your owner : ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            System.out.println("Your owner's name is : " + name);
        } else {
            System.out.println("Please use only letters !");
            return getOwnerNameFromUser();
        }
        return name;
    }

    private String getAnimalFromUser() {
        System.out.println("Choose the animal you want to rescue :");
        Scanner scanner = new Scanner(System.in);
        String animal = scanner.nextLine();
        if (!animal.isEmpty()) {
            System.out.println("You rescued the " + animal);
        } else {
            System.out.println("The animal you want is unavailable !");
            return getAnimalFromUser();
        }

        return animal;
    }

    private String getAnimalNameFromUser() {
        System.out.println("Please select a name for your pet");
        Scanner scanner = new Scanner(System.in);
        String animalname = scanner.nextLine();
        if (!animalname.isEmpty()) {
            System.out.println("Your pet's name is : " + animalname);
        } else {
            System.out.println("Please use only letters !");
            return getAnimalNameFromUser();
        }
        return animalname;
    }

    private void initFood() {
        PetFood petFood1 = new PetFood("Chicken");
        PetFood petFood2 = new PetFood("Fish");
        PetFood petFood3 = new PetFood("Milk");
        PetFood petFood4 = new PetFood("Mice");
        PetFood petFood5 = new PetFood("Bones");
        availableFood.add(0, petFood1);
        availableFood.add(1, petFood2);
        availableFood.add(2, petFood3);
        availableFood.add(3, petFood4);
        availableFood.add(4, petFood5);
    }

    private void initActivities() {

        Activity activity1 = new Activity("The ball");
        Activity activity2 = new Activity("Walk");

        availableActivities[0] = activity1;
        availableActivities[1] = activity2;
    }

    private void initAnimal() {
        Animal animal1 = new Animal();
        animal1.setName("Dog");
        Animal animal2 = new Animal();
        animal2.setName("Cat");
        Animal animal3 = new Animal();
        animal3.setName("Rabbit");

        availableAnimals.add(0, animal1);
        availableAnimals.add(1, animal2);
        availableAnimals.add(2, animal3);

    }

    private void displayFood() {
        System.out.println("Available food is : ");
        for (PetFood petFood : availableFood) {
            if (petFood != null) {
                System.out.println(petFood.getName());
            }
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

    private void displayAnimals() {
        System.out.println("Available animals are : ");
        for (Animal animal : availableAnimals) {
            if (animal != null) {
                System.out.println(animal.getName());
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
