package jpa_basic.hellojpa;

import javax.persistence.Entity;

@Entity
public class Movie extends Item {
    private String Director;
    private String actor;

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
