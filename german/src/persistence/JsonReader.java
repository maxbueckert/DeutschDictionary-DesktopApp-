package persistence;

import model.*;
import model.dictionaries.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public TotalDictionary read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parceTotalDictionary(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }


    private TotalDictionary parceTotalDictionary(JSONObject jsonObject) {
        JSONObject jsonVerbDict = jsonObject.getJSONObject("verbDict");
        JSONObject jsonNounDict = jsonObject.getJSONObject("nounDict");
        VerbDict verbDict = parseVerbDict(jsonVerbDict);
        NounDict nounDict = parseNounDict(jsonNounDict);
        TotalDictionary dict = new TotalDictionary();
        TotalDictionary.setVerbDict(verbDict);
        TotalDictionary.setNounDict(nounDict);
        return dict;

    }






    // EFFECTS: parses workroom from JSON object and returns it
    private VerbDict parseVerbDict(JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("verbList");
        VerbDict verbDict = new VerbDict();
        for (Object json : jsonArray) {
            JSONObject nextVerb = (JSONObject) json;
            Verb verb = makeVerb(nextVerb);
            verbDict.addWord(verb);

        }
        return verbDict;
    }


    // EFFECTS: parses workroom from JSON object and returns it
    private NounDict parseNounDict(JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("nounList");
        NounDict nounDict = new NounDict();
        for (Object json : jsonArray) {
            JSONObject nextNoun = (JSONObject) json;
            Noun noun = makeNoun(nextNoun);
            nounDict.addWord(noun);

        }
        return nounDict;
    }


    private Noun makeNoun(JSONObject jsonObject) {
        Noun noun = new Noun();
        noun.setPlural(jsonObject.getString("plural"));
        noun.setGender(jsonObject.getString("gender"));
        noun.setArticle(jsonObject.getString("article"));
        noun.setGermanRoot(jsonObject.getString("Groot"));
        noun.setEnglishRoot(jsonObject.getString("Eroot"));
        noun.setChapter(jsonObject.getInt("chapter"));
        return noun;
    }




    private Verb makeVerb(JSONObject jsonObject) {
        Verb verb = new Verb();
        verb.setIch(jsonObject.getString("ich"));
        verb.setDu(jsonObject.getString("du"));
        verb.setEr(jsonObject.getString("er"));
        verb.setWir(jsonObject.getString("wir"));
        verb.setIhr(jsonObject.getString("ihr"));
        verb.setSie(jsonObject.getString("sie"));
        verb.setEnglishRoot(jsonObject.getString("Eroot"));
        verb.setGermanRoot(jsonObject.getString("Groot"));
        verb.setChapter(jsonObject.getInt("chapter"));
        return verb;
    }

}
