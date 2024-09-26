package main.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener{

    // Components for the calculator
    private JFrame frame;
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[9];
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;
    private JPanel panel;
    private Theme[] themes = new Theme[1];
    private int themeIndex = 0;
    private int windowWidth, windowHeight;

    // Variables for calculation
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator() {

        // Set the layout to null for absolute positioning
        setLayout(null);

        // Create a JPanel for the background
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // Ensure proper painting
            }
        };

        backgroundPanel.setBounds(0, 0, 500, 500); // Set bounds for the background panel
        add(backgroundPanel); // Add the background panel first

        windowHeight = 550;
        windowWidth = 420;

        // Create color themes
        Theme darkTheme = new Theme("Dark Theme",
                new Color(23, 23, 56),
                new Color(46, 23, 96),
                new Color(52, 35, 166),
                new Color(113, 128, 185),
                Color.WHITE);
        themes[0] = darkTheme;

        // Create frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(windowWidth, windowHeight);
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, windowWidth, windowHeight);
        panel.setBackground(themes[themeIndex].getBackgroundColor());
        frame.add(panel);

        // Create text field for displaying input/output
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(true);
        frame.add(textField);


        // Initialize function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("C");

        // Add function buttons to array for easy iteration
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        // Setup function buttons
        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
        }

        // Initialize number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        // Create panel for calculator buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add panel and other buttons to the frame
        frame.add(panel);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(50, 430, 100, 50);
        frame.add(delButton);
        frame.add(clrButton);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String str = textField.getText();
            textField.setText(str.length() > 0 ? str.substring(0, str.length() - 1) : "");
        }
    }
}
