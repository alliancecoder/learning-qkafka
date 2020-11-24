package org.protechskillsinstitute.learning;

import java.util.UUID;

public class RpgCharacter {

    private UUID id;
    private String race;
    private String adventure_class;
    private String name;

    public RpgCharacter() {
        this.id = UUID.randomUUID();
    }

    public RpgCharacter(String race, String adventure_class, String name) {
        this.id = UUID.randomUUID();
        this.race = race;
        this.adventure_class = adventure_class;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getAdventure_class() {
        return adventure_class;
    }

    public void setAdventure_class(String adventure_class) {
        this.adventure_class = adventure_class;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
