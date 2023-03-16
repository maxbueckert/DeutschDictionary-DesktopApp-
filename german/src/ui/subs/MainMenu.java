package ui.subs;

public class MainMenu extends AbstractUI {

    public MainMenu() {
        super();
        runIntro();
    }


    @Override
    public void displayMenu() {
        System.out.println("\n");
        super.displayMenu();
        System.out.println("\t v -> view verbs");
        System.out.println("\t n -> view nouns");
        System.out.println("\t d -> view dictionary");
        System.out.println("\t q -> quit");
    }

    @Override
    public void processCommand() {
        super.processCommand();
        if (super.command.equals("v")) {
            new AllVerbs();
        } else if (super.command.equals("n")) {
            new AllNouns();
        } else {
            super.invalidInput();
        }
    }






}
