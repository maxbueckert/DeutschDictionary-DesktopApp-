package ui.subs;

import model.Verb;
import model.dictionaries.TotalDictionary;

public class AllVerbs extends AbstractUI {

    public AllVerbs() {
        runIntro();
    }

    @Override
    public void displayMenu() {
        System.out.println("\nEnter the name of the verb you would like to enter");
        System.out.println("Verb Dictionary:");
        for (Verb verb : TotalDictionary.verbDict.getVerbs()) {
            System.out.println("\t" + verb.getGermanRoot() + " -> " + verb.getEnglishRoot());
        }
        super.displayMenu();
        System.out.println("\t a -> add verb");
        super.displayMainOrQuit();
    }


    @Override
    public void processCommand() {
        super.processCommand();
        if (command.equals("a")) {
            new AddVerb();
        } else if (TotalDictionary.verbDict.validVerbRoot(command)) {
            new SingleVerb(TotalDictionary.verbDict.findVerb(command));
        } else {
            super.invalidInput();
        }
    }








}
