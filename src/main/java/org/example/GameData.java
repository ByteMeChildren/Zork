package org.example;

import java.util.Map;

public class GameData {
    private String startRoom;
    private String description;
    private Map<String, Room> rooms;
    private Map<String, Verb> verbs;

    // Getter und Setter
    public String getStartRoom() {
        return startRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Room> getRooms() {
        return rooms;
    }

    public void setRooms(Map<String, Room> rooms) {
        this.rooms = rooms;
    }

    public Map<String, Verb> getVerbs() {
        return verbs;
    }

    public void setVerbs(Map<String, Verb> verbs) {
        this.verbs = verbs;
    }
}

