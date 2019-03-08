package org.fasttrackit.domain;

import org.fasttrackit.Animal;

public class TopRescuer {

    private long id;
    private String name;
    private String rescuedAnimal;
    private int wonGames;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRescuedAnimal() {
        return rescuedAnimal;
    }

    public void setRescuedAnimal(String rescuedAnimal) {
        this.rescuedAnimal = rescuedAnimal;
    }

    public int getWonGames() {
        return wonGames;
    }

    public void setWonGames(int wonGames) {
        this.wonGames = wonGames;
    }

    @Override
    public String toString() {
        return "TopRescuer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rescuedAnimal='" + rescuedAnimal + '\'' +
                ", wonGames=" + wonGames +
                '}';
    }
}
