package ui;

import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RattleTaxGUI {
    // data elements
    private Profile profile;
    private T4 t4;
    private T4Info t4Info;

    // data field elements
    private String firstName;
    private String lastName;
    private int sin;
    private String dob;
    private String address;
    private Boolean marital;

    private int year;
    private String employer;

    // graphical elements
    private JFrame frame;
    private JPanel startPanel;
    private JPanel questionPanel;
    private JPanel finalPanel;
    private JButton startButton;
    private JButton questionButton;
    private JTextField questionTextField;
    private JTextArea questionTextArea;
    private JTextArea finalForm;
    private JButton backToStartButton;


    public RattleTaxGUI() {
        frame = new JFrame();
        frame.setSize(1440,691);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeStartPanel();
        frame.setVisible(true);
    }

    // Initializes GUI to start window
    private void initializeStartPanel() {
        // returning things to null (in case of restart)
        // TODO -> make this method not break the code
        //nullifyChanges();

        // actual initialization
        t4Info = new T4Info();

        startPanel = new JPanel();
        startPanel.setLayout(null);

        startButton = new JButton(new StartAction());
        startButton.setBounds(100,450,150,45);

        startPanel.add(startButton);
        startPanel.setVisible(true);

        frame.add(startPanel);
    }

    private class StartAction extends AbstractAction {

        public StartAction() {
            super("Get Started");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switchToQuestionnaire();
        }
    }

    private void switchToQuestionnaire() {
        startPanel.setVisible(false);
        frame.remove(startPanel);

        questionPanel = new JPanel();
        questionPanel.setLayout(null);

        questionButton = new JButton(new QuestionAction());
        questionButton.setBounds(100,450,150,45);
        questionPanel.add(questionButton);

        questionTextField = new JTextField();
        questionTextField.setBounds(275,450,300,45);
        questionPanel.add(questionTextField);

        questionTextArea = new JTextArea("Let get started with some basic info to make your profile!"
                + "\nWhat is your first name?");
        questionTextArea.setBounds(100,50,300,200);
        questionPanel.add(questionTextArea);

        questionPanel.setVisible(true);
        frame.add(questionPanel);

        frame.setVisible(true);

    }


    private class QuestionAction extends AbstractAction {
        int questionCount = 1;

        public QuestionAction() {
            super("Confirm");
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (questionCount == 1) {
                firstName = questionTextField.getText();
                questionTextField.setText("");
                questionTextArea.setText("What is your last name?");
                questionCount += 1;
                return;
            }

            if (questionCount == 2) {
                lastName = questionTextField.getText();
                questionTextField.setText("");
                questionTextArea.setText("What is SIN (social insurance number");
                questionCount +=1;
                return;
            }

            if (questionCount == 3) {
                sin = Integer.parseInt(questionTextField.getText());
                questionTextField.setText("");
                questionTextArea.setText("What is your date of birth (MM/DD/YYYY)");
                questionCount +=1;
                return;
            }

            if (questionCount == 4) {
                dob = questionTextField.getText();
                questionTextField.setText("");
                questionTextArea.setText("What is your address?");
                questionCount +=1;
                return;
            }

            if (questionCount == 5) {
                address = questionTextField.getText();
                questionTextField.setText("");
                questionTextArea.setText("What is your marital status? Enter 'married'"
                        + "or 'single' (without quotations)");
                questionCount +=1;
                return;
            }

            if (questionCount == 6) {
                String status = questionTextField.getText();
                if (status == "married") {
                    marital = true;
                } else {
                    marital = false;
                }

                profile = new Profile(firstName, lastName, sin, dob, address, marital);

                questionTextField.setText("");
                questionTextArea.setText("Please enter the year you are filing for.");
                questionCount +=1;
                return;
            }

            if (questionCount == 7) {
                year = Integer.parseInt(questionTextField.getText());
                questionTextField.setText("");
                questionTextArea.setText("Please enter the employer you are filing for.");
                questionCount +=1;
                return;
            }

            if (questionCount == 8) {
                employer = questionTextField.getText();

                t4 = new T4(profile, year, employer);

                questionTextField.setText("");
                questionTextArea.setText(t4Info.getQuestion(54));
                questionCount +=1;
                return;
            }





        }
    }

    private void switchToEndScreen() {
        questionPanel.setVisible(false);
        frame.remove(questionPanel);

        finalPanel = new JPanel();
        finalPanel.setLayout(null);

        finalForm = new JTextArea(t4.generateForm());
        finalForm.setBounds(50,50,600,200);
        finalPanel.add(finalForm);

        backToStartButton = new JButton(new BackToStartAction());
        backToStartButton.setBounds(50,450,50,25);
        finalPanel.add(backToStartButton);

        finalPanel.setVisible(true);
        frame.add(finalPanel);

        frame.setVisible(true);
    }

    private class BackToStartAction extends AbstractAction {
        public BackToStartAction() {
            super("Return To Homepage");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            initializeStartPanel();
        }
    }

    // TODO -> make this method not break the code
    private void nullifyChanges() {
        profile = null;
        t4 = null;
        t4Info = null;
        frame.remove(startPanel);
        frame.remove(questionPanel);
        frame.remove(finalPanel);

        startPanel.setVisible(false);
        questionPanel.setVisible(false);
        finalPanel.setVisible(false);

        startPanel = null;
        questionPanel = null;
        finalPanel = null;
    }
}
