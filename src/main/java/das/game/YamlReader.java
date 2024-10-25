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
            GameData gameData = mapper.readValue(new File("src/main/resources/tutorial.yaml"), GameData.class);
            System.out.println("Start room: " + gameData.getStartRoom());
            System.out.println("Game description: "+ gameData.getDescription());
            System.out.println("Number of rooms: " + gameData.getRooms().size());

    var roomId = gameData.getStartRoom();
    var space = "\n \n";
          while(true)
          {
              var defaultError = gameData.getVerbs().get("default").getErrors().verb();
              var currentRoom = gameData.getRooms().get(roomId); //Mit Schlüssel gibt RoomObjekt zurück
              System.out.println(currentRoom.getDescription());
              var text = input().trim();
                  while(text.equalsIgnoreCase(""))
                  {
                      System.out.println(defaultError);
                      text = input().trim();
                  }
              String[] ausgabe = text.split(" ");
              var verb = ausgabe[0];
              var object = "";

                  if (ausgabe.length > 1) {
                      object = ausgabe[1];
                  }
                  if(ausgabe.length > 2)
                  {
                      System.out.println("The input syntax is limited to a maximum of 2 strings, I'm just gonna ignore everything behind " + "\"" + object + "\"");
                  }
              var helpError = gameData.getVerbs().get("help").getErrors().verb();
              var helpTipp = gameData.getVerbs().get("help").getErrors().object();
              var currentVerbs = currentRoom.getVerbs().keySet();
              var inputVerb = gameData.getVerbs().keySet();
              var conditionMet = false;
                  for (var i : inputVerb)
                  {
                      var synonymList = gameData.getVerbs().get(i).getSynonyms();
                      if(verb.equalsIgnoreCase(i))
                      {
                          conditionMet = true;
                          break;
                      }
                      else if(synonymList != null)
                      {
                          if(synonymList.contains(verb))
                          {
                              conditionMet = true;
                              verb = i;
                              break;
                          }
                      }
                  }
                  if (!conditionMet)
                  {
                      System.out.println(defaultError + space);

                  }
                  else
                  {
                      var verbError = gameData.getVerbs().get(verb).getErrors().verb();
                      if (ausgabe.length == 2)
                      {
                          if (currentVerbs.contains(verb))
                          {
                              var actions = currentRoom.getVerbs().get(verb).get(object);
                              if (actions != null)
                              {
                                  for (var new_action : actions)
                                  {
                                      roomId = new_action.getRoom();
                                  }
                              }
                              else
                              {
                                  var objectError = gameData.getVerbs().get(verb).getErrors().object();
                                  System.out.println(objectError.replace("{}", object) + space);
                              }
                          }
                          else
                          {
                              System.out.println(verbError + space);
                          }
                      }
                      else
                      {
                          System.out.println(helpError + space + helpTipp + space);
                      }
                  }
          }
    }
}

//if/addstates machen