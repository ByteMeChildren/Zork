package das.game;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.security.Key;
import java.util.List;
import java.util.Map;

public class Verb {
    private List<String> synonyms;
    private Errors errors;


    // Getter und Setter
    public List<String> getSynonyms() {
        return synonyms;
    }

    public Errors getErrors() {
        return errors;
    }
}

