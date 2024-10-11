package das.game;
import java.util.Map;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private Map<String, Map<String, List<Actions>>> verbs;

    // Getter und Setter
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Map<String, List<Actions>>> getVerbs() {
        return verbs;
    }

    public void setVerbs(Map<String, Map<String, List<Actions>>> verbs) {
        this.verbs = verbs;
    }
}
