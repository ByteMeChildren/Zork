package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//Use Map | MAP<RoomOne, Object...>
public class YamlReader {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            while(true){
            GameData gameData = mapper.readValue(new File("C:\\Users\\seeme\\IdeaProjects\\Zork\\src\\main\\resources\\tutorial.yaml"), GameData.class);
            System.out.println("Start room: " + gameData.getStartRoom());
            System.out.println("Game description: "+ gameData.getDescription());
            System.out.println("Number of rooms: " + gameData.getRooms().size());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            reader.readLine();}
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}