package ui;

import model.Profile;
import model.T4;
import model.T4Info;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

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

    // T4 form
    private JLabel boxEmployer;
    private JLabel boxName;
    private JLabel boxYear;
    private JLabel boxAddress;
    private JLabel box54;
    private JLabel box12;
    private JLabel box14;
    private JLabel box22;
    private JLabel box16;
    private JLabel box24;
    private JLabel box17;
    private JLabel box26;
    private JLabel box18;
    private JLabel box44;
    private JLabel box20;
    private JLabel box46;
    private JLabel box52;
    private JLabel box50;
    private JLabel box55;
    private JLabel box56;

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
        HashMap<Integer, Double> t4Filled = t4.getT4();
        boxEmployer = new JLabel(t4.getEmployer());
        boxEmployer.setBounds(10,10,80,25);
        finalPanel.add(boxEmployer);
        boxName = new JLabel(profile.getLastName() + profile.getFirstName() +
                profile.getFirstName().substring(0,1) + profile.getLastName().substring(0,1));
        boxName.setBounds(10,10,80,25);
        finalPanel.add(boxName);
        boxYear = new JLabel(Integer.toString(t4.getYear()));
        boxYear.setBounds(10,10,80,25);
        finalPanel.add(boxYear);
        boxAddress = new JLabel(profile.getAddress());
        boxAddress.setBounds(10,10,80,25);
        finalPanel.add(boxAddress);
        // Numbered boxes
        box12 = new JLabel(Double.toString(t4Filled.get(12)));
        box12.setBounds(10,10,80,25);
        finalPanel.add(box12);
        box14 = new JLabel(Double.toString(t4Filled.get(14)));
        box14.setBounds(10,10,80,25);
        finalPanel.add(box14);
        box16 = new JLabel(Double.toString(t4Filled.get(16)));
        box16.setBounds(10,10,80,25);
        finalPanel.add(box16);
        box17 = new JLabel(Double.toString(t4Filled.get(17)));
        box17.setBounds(10,10,80,25);
        finalPanel.add(box17);
        box18 = new JLabel(Double.toString(t4Filled.get(18)));
        box18.setBounds(10,10,80,25);
        finalPanel.add(box18);
        box20 = new JLabel(Double.toString(t4Filled.get(20)));
        box20.setBounds(10,10,80,25);
        finalPanel.add(box20);
        box22 = new JLabel(Double.toString(t4Filled.get(22)));
        box22.setBounds(10,10,80,25);
        finalPanel.add(box22);
        box24 = new JLabel(Double.toString(t4Filled.get(24)));
        box24.setBounds(10,10,80,25);
        finalPanel.add(box24);
        box26 = new JLabel(Double.toString(t4Filled.get(26)));
        box26.setBounds(10,10,80,25);
        finalPanel.add(box26);
        box44 = new JLabel(Double.toString(t4Filled.get(44)));
        box44.setBounds(10,10,80,25);
        finalPanel.add(box44);
        box46 = new JLabel(Double.toString(t4Filled.get(46)));
        box46.setBounds(10,10,80,25);
        finalPanel.add(box46);
        box50 = new JLabel(Double.toString(t4Filled.get(50)));
        box50.setBounds(10,10,80,25);
        finalPanel.add(box50);
        box52 = new JLabel(Double.toString(t4Filled.get(52)));
        box52.setBounds(10,10,80,25);
        finalPanel.add(box52);
        box54 = new JLabel(Double.toString(t4Filled.get(54)));
        box54.setBounds(10,10,80,25);
        finalPanel.add(box54);
        box55 = new JLabel(Double.toString(t4Filled.get(55)));
        box55.setBounds(10,10,80,25);
        finalPanel.add(box55);
        box56 = new JLabel(Double.toString(t4Filled.get(56)));
        box56.setBounds(10,10,80,25);
        finalPanel.add(box56);



        finalPanel.setVisible(true);
        frame.add(finalPanel);

        frame.setVisible(true);
    }


}
