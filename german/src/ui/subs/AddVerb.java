package ui.subs;

import model.Verb;
import model.dictionaries.TotalDictionary;

public class AddVerb extends AbstractUI {

    public AddVerb() {
        runIntro();
    }

    @Override
    public void displayMenu() {
        System.out.println("\nRegular verb? Type 'yes' or 'no', or 'b' to cancel");
    }

    @Override
    public void processCommand() {
        if (command.equals("yes")) {
            addRegularVerb();
        } else if (command.equals("no")) {
            // addIrregularVerb();
        } else if (command.equals("b")) {
            new AllVerbs();
        } else {
            super.invalidInput();
        }
    }

    private void addRegularVerb() {
        System.out.println("\nEnter: German root, English meaning, or press 'b' to cancel");
        System.out.println("For Example: lernen, learn");
        initCommand();
        processRegularVerbCommand();
    }

    private void processRegularVerbCommand() {
        if (command.equals("b")) {
            new AllVerbs();
        }
        try {
            String[] listInput = command.split(", ");
            Verb verb = new Verb(true, listInput[0], listInput[1]);
            TotalDictionary.verbDict.addWord(verb);
            new AllVerbs();
        } catch (Exception e) {
            System.out.println("Please select a valid input");
            initCommand();
            processRegularVerbCommand();
        }

    }



}
