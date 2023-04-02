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
    private JPanel profilePanel;
    private JPanel questionPanel;
    private JPanel finalPanel;
    private JButton startButton;
    private JButton questionButton;
    private JTextField questionTextField;
    private JLabel questionLabel;
    private JTextArea finalForm;
    private JButton backToStartButton;
    private JButton profileButton;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField sinField;
    private JTextField dobField;
    private JTextField addressField;
    private JTextField maritalField;


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
            switchToProfileSetup();
        }
    }

    private void switchToProfileSetup() {
        startPanel.setVisible(false);
        frame.remove(startPanel);

        profilePanel = new JPanel();
        profilePanel.setLayout(null);

        profileButton = new JButton(new ProfileAction());
        profileButton.setBounds(100, 450,150,45);
        profilePanel.add(profileButton);

        firstNameField = new JTextField();
        firstNameField.setBounds(100,150,100,45);
        profilePanel.add(firstNameField);

        lastNameField = new JTextField();
        lastNameField.setBounds(200,150,100,45);
        profilePanel.add(lastNameField);

        sinField = new JTextField();
        sinField.setBounds(300,150,100,45);
        profilePanel.add(sinField);

        dobField = new JTextField();
        dobField.setBounds(400,150,100,45);
        profilePanel.add(dobField);

        addressField = new JTextField();
        addressField.setBounds(500,150,100,45);
        profilePanel.add(addressField);

        maritalField = new JTextField();
        maritalField.setBounds(600,150,100,45);
        profilePanel.add(maritalField);


        profilePanel.setVisible(true);
        frame.add(profilePanel);

        frame.setVisible(true);

    }

    private class ProfileAction extends AbstractAction {

        public ProfileAction() {
            super("Confirm");
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            firstName = firstNameField.getText();;
            lastName = lastNameField.getText();;
            sin = Integer.parseInt(sinField.getText());
            dob = dobField.getText();;
            address = addressField.getText();;
            if (maritalField.getText() == "married") {
                marital = true;
            } else {
                marital = false;
            }
            profile = new Profile(firstName,lastName,sin,dob,address,marital);
            switchToQuestionnaire();
        }
    }

    private void switchToQuestionnaire() {
        profilePanel.setVisible(false);
        frame.remove(profilePanel);

        questionPanel = new JPanel();
        questionPanel.setLayout(null);

        questionButton = new JButton(new QuestionAction());
        questionButton.setBounds(100,450,150,45);
        questionPanel.add(questionButton);

        questionTextField = new JTextField();
        questionTextField.setBounds(275,450,300,45);
        questionPanel.add(questionTextField);

        questionLabel = new JLabel("Please enter the year you are filing for.");
        questionLabel.setBounds(100,50,300,200);
        questionPanel.add(questionLabel);
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
                year = Integer.parseInt(questionTextField.getText());
                questionTextField.setText("");
                questionLabel.setText("Please enter the employer you are filing for.");
                questionLabel.setVisible(true);
                questionCount +=1;
                return;
            }

            if (questionCount == 2) {
                employer = questionTextField.getText();

                t4 = new T4(profile, year, employer);

                questionTextField.setText("");
                questionLabel.setText(t4Info.getQuestion(54));
                questionCount +=1;
                return;
            }

            if (questionCount == 3) {
                t4.fillBox(54, Double.parseDouble(questionTextField.getText()));
                questionTextField.setText("");
                questionLabel.setText(t4Info.getQuestion(12));
                questionCount +=1;
                return;
            }
            if (questionCount == 4) {
                t4.fillBox(12, Double.parseDouble(questionTextField.getText()));
                questionTextField.setText("");
                questionLabel.setText(t4Info.getQuestion(14));
                questionCount +=1;
                return;
            }
            if (questionCount == 5) {
                t4.fillBox(14, Double.parseDouble(questionTextField.getText()));
                questionTextField.setText("");
                questionLabel.setText(t4Info.getQuestion(22));
                questionCount +=1;
                return;
            }if (questionCount == 6) {
                t4.fillBox(22, Double.parseDouble(questionTextField.getText()));
                questionTextField.setText("");
                questionLabel.setText(t4Info.getQuestion(16));
                questionCount +=1;
                return;
            }if (questionCount == 7) {
                t4.fillBox(16, Double.parseDouble(questionTextField.getText()));
                questionTextField.setText("");
                questionLabel.setText(t4Info.getQuestion(24));
                questionCount +=1;
                return;
            }
            if (questionCount == 8) {
                t4.fillBox(24, Double.parseDouble(questionTextField.getText()));
                questionTextField.setText("");
                questionLabel.setText(t4Info.getQuestion(17));
                questionCount +=1;
                return;
            }
            if (questionCount == 9) {
                t4.fillBox(16, Double.parseDouble(questionTextField.getText()));
                questionTextField.setText("");
                questionLabel.setText(t4Info.getQuestion(26));
                questionCount +=1;
                return;
            }
            if (questionCount == 10) {
                t4.fillBox(26, Double.parseDouble(questionTextField.getText()));
                questionTextField.setText("");
                questionLabel.setText(t4Info.getQuestion(18));
                questionCount +=1;
                return;
            }
            if (questionCount == 11) {
                t4.fillBox(18, Double.parseDouble(questionTextField.getText()));
                questionTextField.setText("");
                questionLabel.setText(t4Info.getQuestion(44));
                questionCount +=1;
                return;
            }
            if (questionCount == 12) {
                t4.fillBox(44, Double.parseDouble(questionTextField.getText()));
                questionTextField.setText("");
                questionLabel.setText(t4Info.getQuestion(20));
                questionCount +=1;
                return;
            }
            if (questionCount == 13) {
                t4.fillBox(20, Double.parseDouble(questionTextField.getText()));
                questionTextField.setText("");
                questionLabel.setText(t4Info.getQuestion(46));
                questionCount +=1;
                return;
            }if (questionCount == 14) {
                t4.fillBox(46, Double.parseDouble(questionTextField.getText()));
                questionTextField.setText("");
                questionLabel.setText(t4Info.getQuestion(52));
                questionCount +=1;
                return;
            }
            if (questionCount == 15) {
                t4.fillBox(52, Double.parseDouble(questionTextField.getText()));
                questionTextField.setText("");
                questionLabel.setText(t4Info.getQuestion(50));
                questionCount +=1;
                return;
            }if (questionCount == 16) {
                t4.fillBox(50, Double.parseDouble(questionTextField.getText()));
                questionTextField.setText("");
                questionLabel.setText(t4Info.getQuestion(55));
                questionCount +=1;
                return;
            }
            if (questionCount == 17) {
                t4.fillBox(55, Double.parseDouble(questionTextField.getText()));
                questionTextField.setText("");
                questionLabel.setText(t4Info.getQuestion(56));
                questionCount +=1;
                return;
            }

            if (questionCount == 18) {
                t4.fillBox(56, Double.parseDouble(questionTextField.getText()));
                switchToEndScreen();
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
