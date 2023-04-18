package model.dictionaries;

import model.Verb;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

public class VerbDict extends TotalDictionary implements Writable {


    private ArrayList<Verb> verbList;


    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray verbListToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Verb verb : verbList) {
            jsonArray.put(verb.toJson());
        }
        return jsonArray;
    }


    public VerbDict() {
        verbList = new ArrayList<>();
    }


    public void addWord(Verb verb) {
        verbList.add(verb);
        // super.addWord(verb);
    }


    public void removeWord(Verb verb) {
        verbList.remove(verb);
        // super.removeWord(verb);
    }

    public boolean validVerbRoot(String name) {
        for (Verb verb : verbList) {
            if (verb.getGermanRoot().equals(name)) {
                return true;
            }
        }
        return  false;
    }

    public Verb findVerb(String name) {
        for (Verb verb : verbList) {
            if (verb.getGermanRoot().equals(name)) {
                return verb;
            }
        }
        return null;
    }


    public ArrayList<Verb> getVerbs() {
        return verbList;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("verbList", verbListToJson());
        return json;
    }

}
