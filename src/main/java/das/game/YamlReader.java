package das.game;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//Use Map | MAP<RoomOne, Object...>
public class YamlReader
{
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String input()       //Methode zum Input auffordern
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

    var roomId = gameData.getStartRoom(); //Speichert den Key der Map(String)

          while(true)
          {

              var currentRoom = gameData.getRooms().get(roomId); //Mit Schlüssel gibt RoomObjekt zurück
              System.out.println(currentRoom.getDescription());
              var text = input().trim();

                  while(text.equalsIgnoreCase(""))
                  {
                      System.out.println("Your input is invalid");
                      text = input().trim();
                  }
              String[] ausgabe = text.split(" ");
              var verb = ausgabe[0];             
              var object = ausgabe[1];
                  if(ausgabe.length > 2)
                  {
                      System.out.println("The input syntax is limited to a maximum of 2 strings, I'm just gonna ignore everything behind " + "\"" + object + "\"");
                  }
              var currentVerbs = currentRoom.getVerbs().keySet();
              var inputVerb = gameData.getVerbs().keySet();
              var conditionMet = false;

                  for (var i : inputVerb)       //i speichert bei jedem durchgang eines der generellen Verben und prüft ob dein Input == eines der verben ist
                  {
                      var synonymList = gameData.getVerbs().get(i).getSynonyms();  //Setzt die Synonymliste immer neu bei jedem druchgang, da wir bei allen verben die synonyme prüfen wollen
                      if(verb.equalsIgnoreCase(i))
                      {
                          conditionMet = true;
                          break;
                      }
                      else if(synonymList != null) //wenn input nicht == generelles verb, dann prüfen wir ob das Generelle verb überhaupt eine synonym kategorie hat. falls ja, dann geht es in die Loop
                      {
                          if(synonymList.contains(verb)) //wenn die synonymList deinen input enthält, dann geht es aus der For-Loop raus und geht weiter
                          {
                              conditionMet = true;
                              verb = i;
                              break;
                          }
                      }
                  }
                  if (!conditionMet) //wenn nicht true ist-->
                  {
                      System.out.println("I don't understand what you're saying \n" + "Writing \"help\" might help you out, who knows \n \n");
                      //ist noch provisorisch
                  }


              var actions = currentRoom.getVerbs().get(verb).get(object);
              var currentVerb = currentRoom.getVerbs().get(verb);
                  if(actions != null)
                  {
                      for(var new_action : actions)
                      {
                          roomId = new_action.getRoom();
                      }
                  }
          }
    }
}