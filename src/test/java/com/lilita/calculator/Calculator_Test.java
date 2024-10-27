package com.lilita.calculator;

import com.lilita.calculator.Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Calculator_Test {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        calculator.display.setText("10");
        calculator.addButton.doClick();
        calculator.display.setText("5");
        calculator.equButton.doClick();
        assertEquals("15.0", calculator.display.getText(), "10 + 5 should equal 15");
    }

    @Test
    public void testSubtraction() {
        calculator.display.setText("20");
        calculator.subButton.doClick();
        calculator.display.setText("8");
        calculator.equButton.doClick();
        assertEquals("12.0", calculator.display.getText(), "20 - 8 should equal 12");
    }

    @Test
    public void testMultiplication() {
        calculator.display.setText("7");
        calculator.mulButton.doClick();
        calculator.display.setText("3");
        calculator.equButton.doClick();
        assertEquals("21.0", calculator.display.getText(), "7 * 3 should equal 21");
    }

    @Test
    public void testDivision() {
        calculator.display.setText("16");
        calculator.divButton.doClick();
        calculator.display.setText("4");
        calculator.equButton.doClick();
        assertEquals("4.0", calculator.display.getText(), "16 / 4 should equal 4");
    }

    @Test
    public void testClearButton() {
        calculator.display.setText("123");
        calculator.clrButton.doClick();
        assertEquals("", calculator.display.getText(), "Clear button should clear the display");
    }

    @Test
    public void testDeleteButton() {
        calculator.display.setText("12345");
        calculator.delButton.doClick();
        assertEquals("1234", calculator.display.getText(), "Delete button should remove the last character");
    }

    @Test
    public void testDecimalPoint() {
        calculator.display.setText("3");
        calculator.decButton.doClick();
        calculator.display.setText(calculator.display.getText() + "14");
        assertEquals("3.14", calculator.display.getText(), "Display should show 3.14 after adding decimal point");
    }
}
