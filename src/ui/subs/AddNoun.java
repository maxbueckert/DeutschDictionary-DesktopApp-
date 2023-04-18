package ui.subs;

import model.Noun;
import model.dictionaries.TotalDictionary;

public class AddNoun extends AbstractUI {

    public AddNoun() {
        runIntro();
    }

    @Override
    public void displayMenu() {
        System.out.println("\nType 'm', 'n', or 'f' for noun gender");
    }

    @Override
    public void processCommand() {
        if (command.equals("m")) {
            addNoun();
        } else if (command.equals("n")) {
            addNoun();
        } else if (command.equals("f")) {
            addNoun();
        } else {
            super.invalidInput();
        }
    }

    private void addNoun() {
        System.out.println("\nEnter: German root, plural, and English root, or press 'b' to cancel");
        System.out.println("For Example: Man, Manner, Man");
        String gender = command;
        initCommand();
        processAddNounCommand(gender);
    }

    private void processAddNounCommand(String gender) {
        if (command.equals("b")) {
            new AllNouns();
        }
        try {
            String[] listInput = command.split(", ");
            Noun noun = new Noun(gender, listInput[1], listInput[0], listInput[2]);
            TotalDictionary.nounDict.addWord(noun);
            new AllNouns();
        } catch (Exception e) {
            System.out.println("Please select a valid input");
            initCommand();
            processAddNounCommand(gender);
        }

    }



}
