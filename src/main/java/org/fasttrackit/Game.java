package org.fasttrackit;

public class Game {

    Owner owner;
    Animal animal;
    Doctor doctor;

    public Game(Owner owner, Animal animal, Doctor doctor) {
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
