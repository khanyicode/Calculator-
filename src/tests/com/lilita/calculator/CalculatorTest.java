package com.lilita.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAddition() {
        calculator.display.setText("10");
        calculator.actionPerformed(new ActionEvent(calculator.addButton, ActionEvent.ACTION_PERFORMED, null));
        calculator.display.setText("5");
        calculator.actionPerformed(new ActionEvent(calculator.equButton, ActionEvent.ACTION_PERFORMED, null));
        assertEquals("15.0", calculator.display.getText(), "10 + 5 should equal 15");
    }

    @Test
    public void testSubtraction() {
        calculator.display.setText("20");
        calculator.actionPerformed(new ActionEvent(calculator.subButton, ActionEvent.ACTION_PERFORMED, null));
        calculator.display.setText("8");
        calculator.actionPerformed(new ActionEvent(calculator.equButton, ActionEvent.ACTION_PERFORMED, null));
        assertEquals("12.0", calculator.display.getText(), "20 - 8 should equal 12");
    }

    @Test
    public void testMultiplication() {
        calculator.display.setText("7");
        calculator.actionPerformed(new ActionEvent(calculator.mulButton, ActionEvent.ACTION_PERFORMED, null));
        calculator.display.setText("3");
        calculator.actionPerformed(new ActionEvent(calculator.equButton, ActionEvent.ACTION_PERFORMED, null));
        assertEquals("21.0", calculator.display.getText(), "7 * 3 should equal 21");
    }

    @Test
    public void testDivision() {
        calculator.display.setText("16");
        calculator.actionPerformed(new ActionEvent(calculator.divButton, ActionEvent.ACTION_PERFORMED, null));
        calculator.display.setText("4");
        calculator.actionPerformed(new ActionEvent(calculator.equButton, ActionEvent.ACTION_PERFORMED, null));
        assertEquals("4.0", calculator.display.getText(), "16 / 4 should equal 4");
    }

    @Test
    public void testClearButton() {
        calculator.display.setText("123");
        calculator.actionPerformed(new ActionEvent(calculator.clrButton, ActionEvent.ACTION_PERFORMED, null));
        assertEquals("", calculator.display.getText(), "Clear button should clear the display");
    }

    @Test
    public void testDeleteButton() {
        calculator.display.setText("12345");
        calculator.actionPerformed(new ActionEvent(calculator.delButton, ActionEvent.ACTION_PERFORMED, null));
        assertEquals("1234", calculator.display.getText(), "Delete button should remove the last character");
    }

    @Test
    public void testDecimalPoint() {
        calculator.display.setText("3");
        calculator.actionPerformed(new ActionEvent(calculator.decButton, ActionEvent.ACTION_PERFORMED, null));
        calculator.display.setText(calculator.display.getText() + "14");
        assertEquals("3.14", calculator.display.getText(), "Display should show 3.14 after adding decimal point");
    }
}
