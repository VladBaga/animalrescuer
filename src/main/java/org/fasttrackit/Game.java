package org.fasttrackit;

import org.fasttrackit.domain.TopRescuer;
import org.fasttrackit.service.TopRescuerService;
import sun.invoke.empty.Empty;

import java.io.IOException;
import java.security.acl.Owner;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.valueOf;

public class Game {

    private Rescuer rescuer;
    private Animal animal;
    private Doctor doctor;

    private TopRescuerService topRescuerService = new TopRescuerService();
    private List<Rescuer> availableRescuers = new ArrayList<>();
    private Activity[] availableActivities = new Activity[2];
    private List<Animal> availableAnimals = new ArrayList<>();
    private PetFood[] availableFood = new PetFood[3];

    public void start() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("***Welcome to PetRescuer***");
        displayRescuers();
        initRescuer(1);
        initAnimal(1);
        for (Rescuer rescuer : availableRescuers) {
            for (Animal animal : availableAnimals) {
                if (animal.getHunger() > 0) {
                    requireFeeding();

                } else {
                    System.out.println("Your animal is fed now, you won !");
                }
                if (animal.getHappy() < 10) {
                    requireActivity();
                } else {
                    System.out.println("Your animal is happy now, you won !");
                }
                TopRescuer topRescuer = new TopRescuer();
                topRescuer.setName(rescuer.getName());
                topRescuer.setRescuedAnimalName(animal.getName());
                topRescuer.setWonGames(1);
                topRescuerService.createTopRescuer(topRescuer);
            }
        }
    }
    //     while   (noWinnerYet == true){
    //     for (Animal animal : availableAnimals) {
    //         if (animal.getHappy() <= 9) {
    //             requireActivity();
    //         } else {
    //             System.out.println("You saved " + animal.getName() + "from boredom, you won !");
    //             noWinnerYet = false;
    //             break;
    //         }
    //     }
    // }

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
        System.out.println("Choose a type of food by number : ");
        initFood();
        displayFood();
        Scanner scanner = new Scanner(System.in);
        for (Rescuer rescuer : availableRescuers) {
            for (Animal animal : availableAnimals) {
                try {
                    int foodNumberFromUser = scanner.nextInt();
                    PetFood petFood = availableFood[foodNumberFromUser - 1];
                    System.out.println("Selected food : " + petFood.getName());
                    rescuer.feed(rescuer, animal, petFood);
                } catch (ArrayIndexOutOfBoundsException | InputMismatchException exception) {
                    System.out.println("Invalid food number !");
                    requireFeeding();
                }
            }
        }
    }

    private void requireActivity() {
        System.out.println("Your animal is unhappy, please play with him.");
        System.out.println("Choose an activity by number : ");
        initActivities();
        displayActivities();
        Scanner scanner = new Scanner(System.in);
        for (Rescuer rescuer : availableRescuers) {
            for (Animal animal : availableAnimals) {
                try {
                    int activityNumberFromUser = scanner.nextInt();
                    Activity activity = availableActivities[activityNumberFromUser - 1];
                    System.out.println("Selected activity : " + activity.getName());
                    rescuer.play(rescuer, animal, activity);
                } catch (ArrayIndexOutOfBoundsException | InputMismatchException exception) {
                    System.out.println("Invalid activity");
                    requireActivity();
                }

            }
        }
    }

    private void initFood() {
        PetFood petFood1 = new PetFood("1. bones");
        PetFood petFood2 = new PetFood("2. fish");
        PetFood petFood3 = new PetFood("3. milk");
        availableFood[0] = petFood1;
        availableFood[1] = petFood2;
        availableFood[2] = petFood3;
    }

    private void initActivities() {

        Activity activity1 = new Activity("1. ball");
        Activity activity2 = new Activity("2. walk");

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
            System.out.println("Available coins :" + String.format("%.0f", rescuer.getCoins()));
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
            animal.setHappy(9);
            animal.setHealth(ThreadLocalRandom.current().nextDouble(0, 10));
            animal.setHunger(1);
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
