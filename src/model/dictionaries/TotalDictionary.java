package model.dictionaries;

import org.json.JSONObject;
import persistence.Writable;

public class TotalDictionary implements Writable {

   // public static List<Word> wordList = new ArrayList<>();
    public static VerbDict verbDict = new VerbDict();


    public static NounDict nounDict = new NounDict();

//    public CombinedDict() {
//    }

//    public void addWord(Word word) {
//        wordList.add(word);
//    }
//
//    public void removeWord(Word word) {
//        wordList.remove(word);
//    }

    public static void setVerbDict(VerbDict verbDict) {
        TotalDictionary.verbDict = verbDict;
    }

    public static void setNounDict(NounDict nounDict) {
        TotalDictionary.nounDict = nounDict;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("nounDict", nounDict.toJson());
        json.put("verbDict", verbDict.toJson());
        return json;
    }



}
