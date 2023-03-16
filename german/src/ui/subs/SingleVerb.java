package ui.subs;

import model.Verb;
import model.dictionaries.TotalDictionary;

public class SingleVerb extends AbstractUI {

    private Verb verb;

    public SingleVerb(Verb verb) {
        this.verb = verb;
        runIntro();
    }


    @Override
    public void displayMenu() {
        System.out.println("\n" + verb.getGermanRoot().toUpperCase() + " -> " + verb.getEnglishRoot().toUpperCase());
        System.out.println("Chapter: " + verb.getChapter());
        System.out.println("\nConjugation: ");
        System.out.println("ich " + verb.getIch());
        System.out.println("du " + verb.getDu());
        System.out.println("er " + verb.getEr());
        System.out.println("wir " + verb.getWir());
        System.out.println("ihr " + verb.getIhr());
        System.out.println("sie " + verb.getSie());
        super.displayMenu();
        System.out.println("\t c -> set chapter");
        System.out.println("\t d -> delete verb");
        System.out.println("\t b -> back to all verbs");
        super.displayMainOrQuit();
    }

    @Override
    public void processCommand() {
        super.processCommand();
        if (command.equals("b")) {
            new AllVerbs();
        } else if (command.equals("d")) {
            TotalDictionary.verbDict.removeWord(verb);
            new AllVerbs();
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
            verb.setChapter(chapter);
            runIntro();
        } catch (Exception e) {
            System.out.println("Please select a valid input");
            editChapter();
        }
    }
}
