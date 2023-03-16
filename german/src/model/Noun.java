package model;

import persistence.Writable;
import org.json.JSONObject;

public class Noun extends Word implements Writable {

    private String plural;
    private String gender; // m, f, n
    private String article;

    public Noun(String gender, String plural, String germanRoot, String englishRoot) {
        super(englishRoot, germanRoot);
        super.setGermanRoot(capitalize(germanRoot));
        super.setEnglishRoot(capitalize(englishRoot));
        this.plural = capitalize(plural);
        this.gender = gender;
        makeArticle();
    }

    public Noun() {}

    private String capitalize(String string) {
        return string.substring(0,1).toUpperCase() + string.substring(1);
    }

    private void makeArticle() {
        if (gender.equals("m")) {
            article = "der";
        } else if (gender.equals("f")) {
            article = "die";
        } else if (gender.equals("n")) {
            article = "das";
        }
    }

    public String getPlural() {
        return plural;
    }

    public void setPlural(String plural) {
        this.plural = plural;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }



    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("plural", plural);
        json.put("gender", gender);
        json.put("article", article);
        json.put("Groot", super.getGermanRoot());
        json.put("Eroot", super.getEnglishRoot());
        json.put("chapter", super.getChapter());
        return json;
    }




}
