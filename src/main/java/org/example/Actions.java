package org.example;

public class Actions {
    private String room;  // Optional, falls der Raum gewechselt wird
    private String message;  // Nachricht, die an den Spieler ausgegeben wird
    private String addState;  // Optional, wenn ein neuer Status hinzugefügt wird
    private String ifState;  // Optional, wenn eine Aktion von einem bestimmten Status abhängt

    // Getter und Setter
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAddState() {
        return addState;
    }

    public void setAddState(String addState) {
        this.addState = addState;
    }

    public String getIfState() {
        return ifState;
    }

    public void setIfState(String ifState) {
        this.ifState = ifState;
    }
}

