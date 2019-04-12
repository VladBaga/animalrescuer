package org.fasttrackit.transfer;

public class UpdateTopRescuerRequest {

    private long id;
    private String name;
    private String rescuedAnimalName;
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

    public String getRescuedAnimalName() {
        return rescuedAnimalName;
    }

    public void setRescuedAnimalName(String rescuedAnimalName) {
        this.rescuedAnimalName = rescuedAnimalName;
    }

    public int getWonGames() {
        return wonGames;
    }

    public void setWonGames(int wonGames) {
        this.wonGames = wonGames;
    }

    @Override
    public String toString() {
        return "UpdateTopRescuerRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rescuedAnimalName='" + rescuedAnimalName + '\'' +
                ", wonGames=" + wonGames +
                '}';
    }
}
