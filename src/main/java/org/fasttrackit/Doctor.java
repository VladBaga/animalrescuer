package org.fasttrackit;

public class Doctor extends Human {

    private String specialization;
    private boolean pills;
    private boolean vitamins;

    public Doctor() {
        this.specialization = specialization;
        this.pills = pills;
        this.vitamins = vitamins;
    }


    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public boolean isPills() {
        return pills;
    }

    public void setPills(boolean pills) {
        this.pills = pills;
    }

    public boolean isVitamins() {
        return vitamins;
    }

    public void setVitamins(boolean vitamins) {
        this.vitamins = vitamins;
    }
}


