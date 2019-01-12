package org.fasttrackit;

public class Dog extends Animal {

    private String collarcolor;
    private boolean collar;

    @Override
    public void happiness(Animal animal) {
        System.out.println(animal.getName() + " a dat din coada de bucurie!");
        super.happiness(animal);
    }

    public Dog()                           //Constructor
    {
        this.collarcolor = collarcolor;
        this.collar = collar;
    }                                      //Constructor

    public String getCollarcolor() {
        return collarcolor;
    }

    public void setCollarcolor(String collarcolor) {
        this.collarcolor = collarcolor;
    }

    public boolean isCollar() {
        return collar;
    }

    public void setCollar(boolean collar) {
        this.collar = collar;
    }
}
