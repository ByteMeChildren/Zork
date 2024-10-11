package das.game;

import java.util.Map;

public class GameData {
    private String startRoom;
    private String description;
    private Map<String, Room> rooms;
    private Map<String, Verb> verbs;

    // Getter
    public String getStartRoom() {
        return startRoom;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Room> getRooms() { return rooms; }

    public Map<String, Verb> getVerbs() { return verbs; }
}


