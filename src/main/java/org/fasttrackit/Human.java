package org.fasttrackit;

public class Human {

    String name;
    String gender;
    String haircolor;
    String skincolor;
    String eyecolor;
    private Animal animal;

    public Human(Animal animal){
        this.animal = animal;
        System.out.println("Custom animal invoked.");

    }
}
