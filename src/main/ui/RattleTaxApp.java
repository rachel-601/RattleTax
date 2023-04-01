package ui;

import javax.swing.*;

public class RattleTaxApp {


    private JPanel mainPanel;
    private JFrame mainFrame;
    private JTextField mainInput;


    public RattleTaxApp() {

        mainPanel = new JPanel();
        mainFrame = new JFrame("RattleTax");
        mainFrame.setSize(500,250);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(mainPanel);

        mainPanel.setLayout(null);
        mainInput = new JTextField();
        mainInput.setBounds(150,150,200,25);
        mainPanel.add(mainInput);

        mainFrame.setVisible(true);



    }

}
