package org.fasttrackit;

public class Cat extends Animal {

    private String sandboxcolor;
    private boolean sandbox;

    public void happiness(Animal animal) {
        System.out.println(animal.getName() + " a tors de bucurie.");
        super.happiness(animal);
    }

    public Cat()                        //Constructor
    {
        this.sandboxcolor = sandboxcolor;
        this.sandbox = sandbox;
    }                                   //Constructor

    public String getSandboxcolor() {
        return sandboxcolor;
    }

    public void setSandboxcolor(String sandboxcolor) {
        this.sandboxcolor = sandboxcolor;
    }

    public boolean isSandbox() {
        return sandbox;
    }

    public void setSandbox(boolean sandbox) {
        this.sandbox = sandbox;
    }
}
