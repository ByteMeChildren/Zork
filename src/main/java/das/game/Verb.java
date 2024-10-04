package das.game;

import java.util.List;
import java.util.Map;

public class Verb {
    private List<String> synonyms;
    private Map<String, String> errors;  // Verb-Fehlermeldungen

    // Getter und Setter
    public List<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.synonyms = synonyms;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}

