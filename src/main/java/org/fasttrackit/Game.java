package org.fasttrackit;

import sun.invoke.empty.Empty;

import java.security.acl.Owner;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.valueOf;

public class Game {

    private Rescuer rescuer;
    private Animal animal;
    private Doctor doctor;

    private List<Rescuer> availableRescuers = new ArrayList<>();
    private Activity[] availableActivities = new Activity[10];
    private List<Animal> availableAnimals = new ArrayList<>();
    private PetFood[] availableFood = new PetFood[10];

    public void start() {
        System.out.println("***Welcome to PetRescuer***");
        displayRescuers();
        initRescuer(1);
        initAnimal(1);
        for (Animal animal : availableAnimals) {

            if (animal.getHunger() > 0) {

                requireFeeding();

            }
            if(animal.getHappy() < 10){

                requireActivity();
            }
        }
    }

    private String getRescuerNameFromUser() {
        System.out.println("Please enter a name for your rescuer : ");
        Scanner scanner = new Scanner(System.in);
        String rescuerNameFromUser = scanner.nextLine();
        if (!rescuerNameFromUser.isEmpty()) {
            System.out.println("Your rescuer's name is : " + rescuerNameFromUser);
        } else {
            System.out.println("The name cannot be empty !");
            return getRescuerNameFromUser();
        }
        return rescuerNameFromUser;
    }

    private String getGenderFromUser() {
        System.out.println("Please enter your gender (male/female) : ");
        Scanner scanner = new Scanner(System.in);
        String genderFromUser = scanner.nextLine();
        if (genderFromUser.matches("male") || genderFromUser.matches("female")) {
            System.out.println("So you are a : " + genderFromUser);
        } else {
            System.out.println("Invalid gender  !");
            return getGenderFromUser();
        }
        return genderFromUser;
    }

    private Animal getAnimalFromUser() {
        System.out.println("Choose the animal you want to rescue (dog/cat) :");
        Scanner scanner = new Scanner(System.in);
        String animalFromUser = scanner.nextLine();
        if (animalFromUser.matches("dog") || animalFromUser.matches("cat")) {
            System.out.println("You rescued : " + animalFromUser);
        } else {
            System.out.println("Please choose dog/cat !");
            getAnimalFromUser();
        }
        return animal;
    }

    private String getAnimalNameFromUser() {
        System.out.println("Please select a name for your pet");
//        log.print("Please select a name for your pet : add input in same line");
        Scanner scanner = new Scanner(System.in);
        String animalNameFromUser = scanner.nextLine();
        if (!animalNameFromUser.isEmpty()) {
            System.out.println("Your animal's name is : " + animalNameFromUser);
        } else {
            System.out.println("The name cannot be empty !");
            return getAnimalNameFromUser();
        }
        return animalNameFromUser;
    }

    private void requireFeeding() {
        System.out.println("Your animal is hungry, please feed him.");
        System.out.println("Choose a type of food : ");
        initFood();
        displayFood();
        Scanner scanner = new Scanner(System.in);
        for (Rescuer rescuer : availableRescuers) {
            for (Animal animal : availableAnimals) {
                int foodNumberFromUser = scanner.nextInt();
                PetFood petFood = availableFood[foodNumberFromUser - 1];
                System.out.println("Selected food : " + petFood.getName());
                rescuer.feed(rescuer, animal, petFood);
            }
        }
    }

    private void requireActivity() {
        System.out.println("Your animal is unhappy, please play with him.");
        System.out.println("Choose an activity : ");
        initActivities();
        displayActivities();
        Scanner scanner = new Scanner(System.in);
        for (Rescuer rescuer : availableRescuers) {
            for (Animal animal : availableAnimals) {
                int activityNumberFromUser = scanner.nextInt();
                Activity activity = availableActivities[activityNumberFromUser - 1];
                System.out.println("Selected activity : " + activity.getName());
                rescuer.play(rescuer, animal, activity);
            }
        }
    }

    private void initFood() {
        PetFood petFood1 = new PetFood("bones");
        PetFood petFood2 = new PetFood("fish");
        PetFood petFood3 = new PetFood("milk");
        availableFood[0] = petFood1;
        availableFood[1] = petFood2;
        availableFood[2] = petFood3;
    }

    private void initActivities() {

        Activity activity1 = new Activity("ball");
        Activity activity2 = new Activity("walk");

        availableActivities[0] = activity1;
        availableActivities[1] = activity2;
    }

    private void initRescuer(int rescuersCount) {
        for (int i = 0; i < rescuersCount; i++) {
            Rescuer rescuer = new Rescuer();
            rescuer.setName(getRescuerNameFromUser());
            rescuer.setGender(getGenderFromUser());
            rescuer.setAnimal(getAnimalFromUser());
            rescuer.setCoins(50);
            System.out.println("Available coins :" + String.format( "%.0f", rescuer.getCoins()));
            availableRescuers.add(rescuer);
        }
    }

    private void initAnimal(int animalsCount) {
        for (int i = 0; i < animalsCount; i++) {
            Animal animal = new Animal();
            Animal dog = new Animal();
            Animal cat = new Animal();
            animal.setName(getAnimalNameFromUser());
            animal.setAge(0);
            animal.setHappy(ThreadLocalRandom.current().nextDouble(0, 10));
            animal.setHealth(ThreadLocalRandom.current().nextDouble(0, 10));
            animal.setHunger(ThreadLocalRandom.current().nextDouble(0, 10));
            animal.setFavactivity("walk");
            animal.setFavfood("bones");
            availableAnimals.add(animal);
        }
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
        for (Animal animal : availableAnimals) {
            if (animal != null) {
                System.out.println(animal.getName());

            }
        }
    }

    private void displayRescuers() {
        for (Rescuer rescuer : availableRescuers) {
            if (rescuer != null) {
                System.out.println(rescuer.getName());
            }
        }
    }

    public Game() {
        this.rescuer = getRescuer();
        this.animal = animal;
        this.doctor = doctor;
    }

    public Rescuer getRescuer() {
        return rescuer;
    }

    public void setRescuer(Rescuer rescuer) {
        this.rescuer = rescuer;
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
