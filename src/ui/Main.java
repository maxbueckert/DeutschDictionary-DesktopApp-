package ui;

import model.Verb;
import model.dictionaries.TotalDictionary;
import persistence.JsonReader;
import ui.subs.AbstractUI;
import ui.subs.MainMenu;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        loadDict();

        // reconjugate incase change has been made to logic
        ArrayList<Verb> verbs = TotalDictionary.verbDict.getVerbs();
        for (Verb verb : verbs) {
            if(verb.isRegular()) {
                verb.conjugate();
            }
        }


        new MainMenu();
    }

    // BORROWED FROM 210
    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private static void loadDict() {
        String JSON_STORE = "./data/dict.json";
        JsonReader jsonReader = new JsonReader(JSON_STORE);
        try {
            AbstractUI.dict = jsonReader.read();
            System.out.println("Loaded semester from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        } catch (Exception e) {
            System.out.println("No previous backups were found at " + JSON_STORE);
        }
    }
}