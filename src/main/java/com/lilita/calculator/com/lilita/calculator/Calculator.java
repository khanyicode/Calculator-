package com.lilita.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    public JTextField display;
    private JPanel panel;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    public JButton addButton;
    public JButton subButton;
    public JButton mulButton;
    public JButton divButton;
    public JButton decButton;
    public JButton equButton;
    public JButton delButton;
    public JButton clrButton;

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

/**
 * Constructor for the Calculator class that initializes and configures the calculator UI.
 * This constructor sets up a basic calculator with a display field and buttons for:
 * - Numeric inputs (0-9)
 * - Basic arithmetic operations (+, -, *, /)
 * - Decimal point, equals, delete, and clear functionality
 * 
 * The calculator uses a simple grid layout for the main button panel and absolute positioning
 * for other elements. The UI is designed with a fixed size and non-resizable components.
 * 
 * Note: This constructor only initializes the UI components. The actual calculation logic
 * should be implemented in the actionPerformed method (not shown here) since this class 
 * likely implements ActionListener.
 * 
 * The calculator UI includes:
 * - A non-editable display field at the top
 * - Number buttons (0-9) arranged in a grid
 * - Operation buttons (+, -, *, /)
 * - Utility buttons (., =, Del, C)
 * 
 * @throws HeadlessException if GraphicsEnvironment.isHeadless() returns true,
 *         which is inherited from the JFrame constructor
 * 
 * @see javax.swing.JFrame
 * @see java.awt.event.ActionListener
 * 
 * @example
 * // Create a new calculator instance
 * Calculator calc = new Calculator();
 * // The calculator window will appear with all buttons and display ready for use
 */
public Calculator() {
    setTitle("Calculator");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(420, 550);
    setLayout(null);

    // Initialize and configure the calculator display
    display = new JTextField();
    display.setBounds(50, 25, 300, 50);
    display.setFont(new Font("Arial", Font.PLAIN, 24));
    display.setEditable(false);
    add(display);

    // Initialize function buttons (+, -, *, /, etc.)
    functionButtons = new JButton[8];
    addButton = new JButton("+");
    subButton = new JButton("-");
    mulButton = new JButton("*");
    divButton = new JButton("/");
    decButton = new JButton(".");
    equButton = new JButton("=");
    delButton = new JButton("Del");
    clrButton = new JButton("C");

    // Store function buttons in array for easier batch configuration
    functionButtons[0] = addButton;
    functionButtons[1] = subButton;
    functionButtons[2] = mulButton;
    functionButtons[3] = divButton;
    functionButtons[4] = decButton;
    functionButtons[5] = equButton;
    functionButtons[6] = delButton;
    functionButtons[7] = clrButton;

    // Configure all function buttons with common properties
    for (int i = 0; i < 8; i++) {
        functionButtons[i].addActionListener(this);
        functionButtons[i].setFont(new Font("Arial", Font.PLAIN, 24));
        functionButtons[i].setFocusable(false);
    }

    // Initialize and configure number buttons (0-9)
    numberButtons = new JButton[10];
    for (int i = 0; i < 10; i++) {
        numberButtons[i] = new JButton(String.valueOf(i));
        numberButtons[i].addActionListener(this);
        numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 24));
        numberButtons[i].setFocusable(false);
    }

    // Create and configure the main button panel with grid layout
    panel = new JPanel();
    panel.setBounds(50, 100, 300, 300);
    panel.setLayout(new GridLayout(4, 4, 10, 10));

    // Add buttons to the panel in the desired arrangement
    // First row
    panel.add(numberButtons[1]);  // 1
    panel.add(numberButtons[2]);  // 2
    panel.add(numberButtons[3]);  // 3
    panel.add(addButton);         // +
    
    // Second row
    panel.add(numberButtons[4]);  // 4
    panel.add(numberButtons[5]);  // 5
    panel.add(numberButtons[6]);  // 6
    panel.add(subButton);         // -
    
    // Third row
    panel.add(numberButtons[7]);  // 7
    panel.add(numberButtons[8]);  // 8
    panel.add(numberButtons[9]);  // 9
    panel.add(mulButton);         // *
    
    // Fourth row
    panel.add(decButton);         // .
    panel.add(numberButtons[0]);  // 0
    panel.add(equButton);         // =
    panel.add(divButton);         // /

    // Add the button panel to the frame
    add(panel);

    // Position and add the Delete and Clear buttons below the main panel
    delButton.setBounds(150, 430, 100, 50);
    clrButton.setBounds(250, 430, 100, 50);
    add(delButton);
    add(clrButton);

    // Make the calculator window visible
    setVisible(true);
}

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            display.setText(display.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            display.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            display.setText("");
        }
        if (e.getSource() == delButton) {
            String string = display.getText();
            display.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                display.setText(display.getText() + string.charAt(i));
            }
        }
    }
}
