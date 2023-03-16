package model;

public abstract class Word {

    private String englishRoot;
    private String germanRoot;
    private int chapter;

    public Word(String englishRoot, String germanRoot) {
        this.englishRoot = englishRoot;
        this.germanRoot = germanRoot;
    }

    public Word() {}


    public void setEnglishRoot(String englishRoot) {
        this.englishRoot =  englishRoot;
    }

    public void setGermanRoot(String germanRoot) {
        this.germanRoot =  germanRoot;
    }

    public void setChapter(int chapter) {
        this.chapter =  chapter;
    }

    public int getChapter() {
        return chapter;
    }

    public String getEnglishRoot() {
        return englishRoot;
    }

    public String getGermanRoot() {
        return germanRoot;
    }
}
