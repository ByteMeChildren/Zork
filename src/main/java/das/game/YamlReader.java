package das.game;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

//Use Map | MAP<RoomOne, Object...>
public class YamlReader
{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String input()
    {
        try
        {
            return reader.readLine();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            GameData gameData = mapper.readValue(new File("C:\\Users\\adm.kuzs\\IdeaProjects\\Zork\\src\\main\\resources\\tutorial.yaml"), GameData.class);
            System.out.println("Start room: " + gameData.getStartRoom());
            System.out.println("Game description: "+ gameData.getDescription());
            System.out.println("Number of rooms: " + gameData.getRooms().size());

    var roomId = gameData.getStartRoom(); //Gibt Map Schlüssel zurück(String)
    String[] inventory = {};


          while(true)
          {

              var currentRoom = gameData.getRooms().get(roomId); //Mit Schlüssel gibt RoomObjekt zurück
              System.out.println(currentRoom.getDescription());
              var text = input();
              var verbList = currentRoom.getVerbs().keySet();
              if(text.equalsIgnoreCase("help"))
              {
                  System.out.println(verbList);
                 input();
              }
              else
              {
              String[] ausgabe = text.split(" ");
              var verb = ausgabe[0];
              var object = ausgabe[1];
              var conditionMet = false;

                  for (var i : verbList)
                  {
                      if (verb.equalsIgnoreCase(i))
                      {
                          conditionMet = true;  // Übereinstimmung gefunden, conditionMet auf true setzen
                          break;
                      }
                  }
                  if (!conditionMet) //wenn nicht true ist-->
                  {
                      System.out.println("I don't understand what you're saying \n" + "Writing \"help\" might help you out, who knows \n \n");
                  }

              var actions = currentRoom.getVerbs().get(verb).get(object);
              var currentVerb = currentRoom.getVerbs().get(verb);
              var currentObject = currentRoom.getVerbs().get(object);
                  if(actions != null)
                  {
                      for(var new_action : actions)
                      {
                          roomId = new_action.getRoom();
                      }
                  }
                  else if (currentObject == null && currentVerb == null)
                  {
                      System.out.println("Unknown action: " + object + verb + "\n" + "\n" + "Writing \"help\" might help you out, who knows \n  \n");;
                  }
                  else if(currentVerb == null)
                  {
                      System.out.println("Unknown action: " + verb + "\n" + "\n" + "Writing \"help\" might help you out, who knows \n \n");
                  }
                  else
                  {
                      System.out.println("Unknown action: " + object + "\n" + "\n" + "Writing \"help\" might help you out, who knows \n \n");
                  }

            /*
            muss erkennen welches wort ==null
            inventory
            problem solving
             */

              }
          }
    }
}