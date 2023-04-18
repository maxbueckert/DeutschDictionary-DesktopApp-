package model;


import persistence.Writable;
import org.json.JSONObject;


public class Verb extends Word implements Writable {

    private boolean isRegular;

    private String ich;
    private String du;
    private String er;
    private String wir;
    private String ihr;
    private String sie;

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("ich", ich);
        json.put("du", du);
        json.put("er", er);
        json.put("wir", wir);
        json.put("ihr", ihr);
        json.put("sie", sie);
        json.put("Groot", super.getGermanRoot());
        json.put("Eroot", super.getEnglishRoot());
        json.put("chapter", super.getChapter());
        json.put("regular", isRegular);

        return json;
    }


    public Verb(Boolean isRegular, String germanRoot, String englishRoot) {
        super(englishRoot, germanRoot);
        if (isRegular) {

            conjugate();
        }


    }

    public Verb(){}



    public boolean conjugate() {
        String germanRoot = super.getGermanRoot();
        int length = germanRoot.length();
        if (germanRoot.substring(length - 3).equals("den") || (germanRoot.substring(length - 3).equals("ten"))) {
            conjugateTEN();
        }
        else if (germanRoot.substring(length - 2).equals("en")) {
            conjugateEN();
            return true;
        } else if (germanRoot.substring(length - 1).equals("n")) {
            conjugateN();
        }
        return false;
    }

    private void conjugateEN() {
        String oldGermanRoot = super.getGermanRoot();
        int cutoff = oldGermanRoot.length() - 2;
        String newGermanRoot = oldGermanRoot.substring(0, cutoff);
        this.ich = newGermanRoot + "e";
        this.wir = newGermanRoot + "en";
        this.ihr = newGermanRoot + "t";
        this.sie = newGermanRoot + "en";

        checkStem(newGermanRoot);
    }

    private void conjugateN() {
        String oldGermanRoot = super.getGermanRoot();
        int cutoff = oldGermanRoot.length() - 1;
        String newGermanRoot = oldGermanRoot.substring(0, cutoff);
        this.ich = newGermanRoot + "";

        this.wir = newGermanRoot + "n";
        this.ihr = newGermanRoot + "t";
        this.sie = newGermanRoot + "n";

        checkStem(newGermanRoot);

    }


    private void checkStem(String newGermanRoot) {
        int cutoffGnFnSs = newGermanRoot.length() - 2;
        int cutoffSXZ = newGermanRoot.length() - 1;
        if (newGermanRoot.substring(cutoffGnFnSs).equals("gn") || newGermanRoot.substring(cutoffGnFnSs).equals("fn")) {
             this.du = newGermanRoot + "est";
             this.er = newGermanRoot + "et";
        } else if (newGermanRoot.substring(cutoffGnFnSs).equals("ss")) {
            this.du = newGermanRoot + "t";
            this.er = newGermanRoot + "t";
        }
        else if (newGermanRoot.substring(cutoffSXZ).equals("s") || newGermanRoot.substring(cutoffSXZ).equals("x") || newGermanRoot.substring(cutoffSXZ).equals("z")) {
            this.du = newGermanRoot + "t";
            this.er = newGermanRoot + "t";
        } else {
            this.du = newGermanRoot + "st";
            this.er = newGermanRoot + "t";
        }
    }

    private void conjugateTEN() {
        String oldGermanRoot = super.getGermanRoot();
        int cutoff = oldGermanRoot.length() - 2;
        String newGermanRoot = oldGermanRoot.substring(0, cutoff);
        this.ich = newGermanRoot + "e";
        this.du = newGermanRoot + "est";
        this.er = newGermanRoot + "et";
        this.wir = newGermanRoot + "en";
        this.ihr = newGermanRoot + "et";
        this.sie = newGermanRoot + "en";

    }



    public boolean isRegular() {
        return isRegular;
    }

    public String getIch() {
        return ich;
    }

    public String getDu() {
        return du;
    }

    public String getEr() {
        return er;
    }

    public String getWir() {
        return wir;
    }

    public String getIhr() {
        return ihr;
    }

    public String getSie() {
        return sie;
    }




    public void setRegular(boolean regular) {
        isRegular = regular;
    }

    public void setIch(String ich) {
        this.ich = ich;
    }

    public void setDu(String du) {
        this.du = du;
    }

    public void setEr(String er) {
        this.er = er;
    }

    public void setWir(String wir) {
        this.wir = wir;
    }

    public void setIhr(String ihr) {
        this.ihr = ihr;
    }

    public void setSie(String sie) {
        this.sie = sie;
    }





}