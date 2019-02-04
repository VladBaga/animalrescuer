package org.fasttrackit;

import java.awt.*;

public class Cat extends Animal {

    private String sandboxcolor;
    private boolean sandbox;

    public void happiness() {
        System.out.println(getName() + " a tors de bucurie.");
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
