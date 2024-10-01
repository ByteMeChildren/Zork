package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//Use Map | MAP<RoomOne, Object...>
public class YamlReader {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String input(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());


            GameData gameData = mapper.readValue(new File("C:\\Users\\seeme\\IdeaProjects\\Zork\\src\\main\\resources\\tutorial.yaml"), GameData.class);
            System.out.println("Start room: " + gameData.getStartRoom());
            System.out.println("Game description: "+ gameData.getDescription());
            System.out.println("Number of rooms: " + gameData.getRooms().size());

    var roomId = gameData.getStartRoom();
        while(true){
            var currentRoom = gameData.getRooms().get(roomId);
            System.out.println(currentRoom.getDescription());

            var text = input();
            String[] ausgabe = text.split(" ");
            var verb = ausgabe[0];
            var object = ausgabe[1];

            var actions = currentRoom.getVerbs().get(verb).get(object);
            for(var action : actions){
                roomId = action.getRoom();

            }


    }


}
}