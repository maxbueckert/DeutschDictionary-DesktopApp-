package ui.subs;

import model.dictionaries.TotalDictionary;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class AbstractUI {

    

    private static final String JSON_STORE = "./data/dict.json";

    public static Scanner input = new Scanner(System.in);
   // public static VerbDict verbList = new VerbDict();
   // public static NounDict nounList = new NounDict();
    public static TotalDictionary dict = new TotalDictionary();

    private static JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    private static JsonReader jsonReader = new JsonReader(JSON_STORE);

    public static String command;




    public void initCommand() {
        command = input.nextLine();
        command = command.toLowerCase();
    }


    // EFFECTS: prints goodbye statement then exits program
    private void exitProgram() {
        saveVerbDict();
        System.out.println("Goodbye!");
        System.exit(0);
    }

    private void saveVerbDict() {
        try {
            jsonWriter.open();
            jsonWriter.write(dict);
            jsonWriter.close();
            System.out.println("Saved semester to " + JSON_STORE);

        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }



    public void runIntro() {
        displayMenu();
        initCommand();
        processCommand();
    }


    public void displayMenu() {
        System.out.println("\nPlease select from the following options:");

    }

    public void displayMainOrQuit() {
        System.out.println("\t m -> main menu");
        System.out.println("\t q -> quit");
    }

    public void processCommand() {
        if (command.equals("m")) {
            new MainMenu();
        } else if (command.equals("q")) {
            exitProgram();
        }
    }

    public void invalidInput() {
        System.out.println("Please select a valid input");
        initCommand();
        processCommand();
    }





}
