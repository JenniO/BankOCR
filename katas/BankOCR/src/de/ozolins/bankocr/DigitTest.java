package de.ozolins.bankocr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DigitTest {

    Digit one = new Digit("   ", "  |", "  |");
    Digit two = new Digit(" _ ", " _|", "|_ ");
    Digit three = new Digit(" _ ", " _|", " _|");
    Digit four = new Digit("   ", "|_|", "  |");
    Digit five = new Digit(" _ ", "|_ ", " _|");
    Digit six = new Digit(" _ ", "|_ ", "|_|");
    Digit seven = new Digit(" _ ", "  |", "  |");
    Digit eight = new Digit(" _ ", "|_|", "|_|");
    Digit nine = new Digit(" _ ", "|_|", " _|");
    Digit zero = new Digit(" _ ", "| |", "|_|");

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void digitOnlyContainsLegalCharacters() {
        String row1 = " _ ";
        String row2 = "| |";
        String row3 = "|_|";
        Digit digit = new Digit(row1, row2, row3);
        assertTrue(digit.isValid());
    }

    @Test
    public void digitContainsIllegalCharacters() {
        String row1 = " _|";
        String row2 = "| |";
        String row3 = "|_|";
        Digit digit = new Digit(row1, row2, row3);
        assertFalse(digit.isValid());
    }

    @Test
    public void isZero() {
        assertEquals("0", zero.getDigit());
    }

    @Test
    public void isOne() {
        assertEquals("1", one.getDigit());
    }

    @Test
    public void isTwo() {
        assertEquals("2", two.getDigit());
    }

    @Test
    public void isThree() {
        assertEquals("3", three.getDigit());
    }

    @Test
    public void isFour() {
        assertEquals("4", four.getDigit());
    }

    @Test
    public void isFive() {
        assertEquals("5", five.getDigit());
    }

    @Test
    public void isSix() {
        assertEquals("6", six.getDigit());
    }

    @Test
    public void isSeven() {
        assertEquals("7", seven.getDigit());
    }

    @Test
    public void isEight() {
        assertEquals("8", eight.getDigit());
    }

    @Test
    public void isNine() {
        assertEquals("9", nine.getDigit());
    }

    @Test
    public void recognizeIllegibleCharacter() {
        Digit digit = new Digit(" _ ", " _ ", " _|");
        assertEquals("?", digit.getDigit());
    }

}
