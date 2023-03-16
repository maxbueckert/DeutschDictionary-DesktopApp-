package model.dictionaries;

import model.Noun;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

public class NounDict extends TotalDictionary implements Writable {


    private ArrayList<Noun> nounList;


    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray nounListToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Noun noun : nounList) {
            jsonArray.put(noun.toJson());
        }
        return jsonArray;
    }


    public NounDict() {
        nounList = new ArrayList<>();
    }


    public void addWord(Noun noun) {
        nounList.add(noun);
        //super.addWord(noun);
    }


    public void removeWord(Noun noun) {
        nounList.remove(noun);
       // super.removeWord(noun);
    }

    public boolean validNounRoot(String name) {
        for (Noun noun : nounList) {
            if (noun.getGermanRoot().toLowerCase().equals(name)) {
                return true;
            }
        }
        return  false;
    }

    public Noun findNoun(String name) {
        for (Noun noun : nounList) {
            if (noun.getGermanRoot().toLowerCase().equals(name)) {
                return noun;
            }
        }
        return null;
    }


    public ArrayList<Noun> getNouns() {
        return nounList;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("nounList", nounListToJson());
        return json;
    }

}
