package ui.subs;

import model.Noun;
import model.dictionaries.TotalDictionary;

public class AllNouns extends AbstractUI {

    public AllNouns() {
        runIntro();
    }

    @Override
    public void displayMenu() {
        System.out.println("\nEnter the name of the noun you would like to enter");
        System.out.println("Noun Dictionary:");
        for (Noun noun : TotalDictionary.nounDict.getNouns()) {
            System.out.println("\t" + noun.getGermanRoot() + " -> " + noun.getEnglishRoot());
        }
        super.displayMenu();
        System.out.println("\t a -> add noun");
        super.displayMainOrQuit();
    }


    @Override
    public void processCommand() {
        super.processCommand();
        if (command.equals("a")) {
            new AddNoun();
        } else if (TotalDictionary.nounDict.validNounRoot(command)) {
            new SingleNoun(TotalDictionary.nounDict.findNoun(command));
        } else {
            super.invalidInput();
        }
    }








}
