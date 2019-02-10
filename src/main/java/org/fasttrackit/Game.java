package org.fasttrackit;

import java.util.*;

import static java.lang.String.valueOf;

public class Game {

    private Owner owner;
    private Animal animal;
    private Doctor doctor;
    private PetFood petFood;

    private List<PetFood> availableFood = new ArrayList<>();
    private Activity[] availableActivities = new Activity[10];
    private List<Animal> availableAnimals = new ArrayList<>();

    public void start() {
        System.out.println("***Welcome to PetRescuer***");
        getOwnerNameFromUser();
        initAnimal();
        displayAnimals();
        getAnimalFromUser();
        getAnimalNameFromUser();
        requireFeeding(getOwner(),getAnimal(),getPetFood());
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
            System.out.println("The name cannot be empty !");
            return getOwnerNameFromUser();
        }
        return name;
    }

    private void getAnimalFromUser() {
        System.out.println("Choose the animal you want to rescue :");
        Scanner scanner = new Scanner(System.in);
        String animalFromUser = scanner.nextLine();
        if (animalFromUser.matches("Dog") || animalFromUser.matches("Cat")) {
            System.out.println("You rescued : " + animalFromUser);
        } else {
            System.out.println("The animal you want is unavailable !");
            getAnimalFromUser();
        }
    }

    private String getAnimalNameFromUser() {
        System.out.println("Please select a name for your pet");
//        log.print("Please select a name for your pet : add input in same line");
        Scanner scanner = new Scanner(System.in);
        String animalname = scanner.nextLine();
        if (!animalname.isEmpty()) {
            System.out.println("Your animal's name is : " + animalname);
        } else {
            System.out.println("The name cannot be empty !");
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
        animal1.setAge(0);
        animal1.setHappy(5);
        animal1.setHealth(5);
        animal1.setHunger(5);
        animal1.setFavactivity("Walk");
        animal1.setFavfood("Bones");
        Animal animal2 = new Animal();
        animal2.setName("Cat");
        animal2.setAge(0);
        animal2.setHappy(5);
        animal1.setHealth(5);
        animal1.setHunger(5);
        animal1.setFavactivity("The ball");
        animal1.setFavfood("Fish");

        availableAnimals.add(0, animal1);
        availableAnimals.add(1, animal2);
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
        System.out.println("Available animals are :");
        for (Animal animal : availableAnimals) {
            if (animal != null) {
                System.out.println(animal.getName());

            }
        }
    }

    private void requireFeeding(Owner owner, Animal animal, PetFood petFood) {
        System.out.println("Your animal is hungry, please feed him.");
        initFood();
        displayFood();
        System.out.println("Choose a type of food : ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        owner.feed(owner,animal,petFood);
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
    public PetFood getPetFood() {
        return petFood;
    }

    public void setPetFood(PetFood petFood) {
        this.petFood = petFood;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
