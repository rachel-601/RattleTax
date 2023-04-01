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

        this.initializeProfile();

    }

    private void initializeProfile() {
        boolean runInit = true;
        String userInput = null;

        String firstName;
        String lastName;
        int sin;
        String dob;
        String address;
        Boolean marital;

        while (runInit) {


        }

        this.profile = new Profile(firstName, lastName, sin, dob, address, marital);


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
                processInput(userInput);
            }
        }

        System.out.println("\nThanks for using the app!");

    }

    private void processInput(String userInput) {


    }

    private void displayMenu() {
        System.out.println("\nPlease choose one of the following actions:");
        System.out.println("\n1 to Fill out T1");
        System.out.println("\n2 to Fill out T4");



    }

}
