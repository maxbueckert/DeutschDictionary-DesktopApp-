package ui.subs;

import model.Noun;
import model.dictionaries.TotalDictionary;

public class SingleNoun extends AbstractUI {

    private Noun noun;


    public SingleNoun(Noun noun) {
        this.noun = noun;
        runIntro();
    }


    @Override
    public void displayMenu() {
        System.out.println("\n" + noun.getArticle() + " " + noun.getGermanRoot() + " -> " + noun.getEnglishRoot());
        System.out.println("die " + noun.getPlural());
        System.out.println("Chapter: " + noun.getChapter());
        super.displayMenu();
        System.out.println("\t c -> set chapter");
        System.out.println("\t d -> delete noun");
        System.out.println("\t b -> back to all nouns");
        super.displayMainOrQuit();
    }

    @Override
    public void processCommand() {
        super.processCommand();
        if (command.equals("b")) {
            new AllNouns();
        } else if (command.equals("d")) {
            TotalDictionary.nounDict.removeWord(noun);
            new AllNouns();
        } else if (command.equals("c")) {
            System.out.println("Enter Chapter:");
            editChapter();
        } else {
            super.invalidInput();
        }

    }

    private void editChapter() {
        try {
            initCommand();
            int chapter = Integer.parseInt(command);
            noun.setChapter(chapter);
            runIntro();
        } catch (Exception e) {
            System.out.println("Please select a valid input");
            editChapter();
        }
    }
}
