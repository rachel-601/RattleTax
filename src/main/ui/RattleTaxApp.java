package ui;

import model.*;
import java.util.Scanner;

public class RattleTaxApp {
    private Profile profile;
    private T4 t4;
    private Scanner input;

    public RattleTaxApp() {
        input = new Scanner(System.in);
        input.useDelimiter("\n");
        initializeProfile();
        initializeT4();
        runApp();
    }

    private void initializeProfile() {
        boolean runInit = true;
        String firstName = null;
        String lastName = null;
        int sin = 0;
        String dob = null;
        String address = null;
        Boolean marital = null;

        while (runInit) {
            System.out.println("\nWe first need to set up your profile!");
            System.out.println("\nEnter your first name:");
            firstName = input.next();
            System.out.println("\nEnter your last name:");
            lastName = input.next();
            System.out.println("\nEnter your SIN:");
            sin = Integer.parseInt(input.next());
            System.out.println("\nEnter your date of birth (MM/DD/YYYY):");
            dob = input.next();
            System.out.println("\nEnter your address:");
            address = input.next();
            System.out.println("\nAre you married? (y/n):");
            if (input.next() == "y") {
                marital = true;
            } else {
                marital = false;
            }
            runInit = false;
        }

        this.profile = new Profile(firstName, lastName, sin, dob, address, marital);
        System.out.println("\nProfile created!");
    }

    private void initializeT4() {
        boolean runInit = true;
        String userInput = null;

        while (runInit) {
            displayMenu();
            userInput = input.next();

            if (userInput.equals("1")) {
                System.out.println("Feature not available yet, please choose again!");
            } else {
                processInput();
                runInit = false;
            }
        }

        System.out.println("\nYou're ready to start filing your T4 form!");
    }

    private void processInput() {
        int year = 0;
        String employer = null;
        System.out.println("\nYear you are filing for:");
        year = Integer.parseInt(input.next());
        System.out.println("\nEmployer name:");
        employer = input.next();
        this.t4 = new T4(profile,year,employer);
    }

    private void displayMenu() {
        System.out.println("\nPlease choose one of the following actions:");
        System.out.println("\n1 to Fill out T1");
        System.out.println("\n2 to Fill out T4");
    }

    public void runApp() {
        boolean runApp = true;
        String userInput = null;

        while (runApp) {
            displayMenu();
            userInput = input.next();
            userInput = userInput.toLowerCase();

            if (userInput.equals("q")) {
                runApp = false;
            } else {
                processInput();
            }
        }

        System.out.println("\nThanks for using the app!");

    }

}
