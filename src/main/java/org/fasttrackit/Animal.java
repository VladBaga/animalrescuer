package org.fasttrackit;


public class Animal {

    private String name;
    private String color;
    private String favfood;
    private String favactivity;
    private String gender;
    private int age;
    private int happy;
    private int health;
    private int hunger;
    private int pawscount;

    public void happiness(Animal animal){
        return;
    }

    public Animal()                     //Constructor
    {
        this.name = name;
        this.color = color;
        this.favfood = favfood;
        this.favactivity = favactivity;
        this.gender = gender;
        this.age = age;
        this.happy = happy;
        this.health = health;
        this.hunger = hunger;
        this.pawscount = pawscount;
    }                                   //Constructor

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFavfood() {
        return favfood;
    }

    public void setFavfood(String favfood) {
        this.favfood = favfood;
    }

    public String getFavactivity() {
        return favactivity;
    }

    public void setFavactivity(String favactivity) {
        this.favactivity = favactivity;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getHappy() {
        return happy;
    }

    public void setHappy(int happy) {
        this.happy = happy;
    }

    public int getPawscount() {
        return pawscount;
    }

    public void setPawscount(int pawscount) {
        this.pawscount = pawscount;
    }

}
