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

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Map<String, List<Actions>>> getVerbs() {
        return verbs;
    }

    public void setVerbs(Map<String, Map<String, List<Actions>>> verbs) {
        this.verbs = verbs;
    }
}
