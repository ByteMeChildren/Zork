package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;

//Use Map | MAP<RoomOne, Object...>
public class YamlReader {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            GameData gameData = mapper.readValue(new File("game.yaml"), GameData.class);
            System.out.println("Start room: " + gameData.getStartRoom());
            System.out.println("Game description: " + gameData.getDescription());
            System.out.println("Number of rooms: " + gameData.getRooms().size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}