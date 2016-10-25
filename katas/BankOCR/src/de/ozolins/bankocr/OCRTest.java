package de.ozolins.bankocr;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OCRTest {

    String zeroes =
            " _  _  _  _  _  _  _  _  _ \n" +
                    "| || || || || || || || || |\n" +
                    "|_||_||_||_||_||_||_||_||_|\n" +
                    "                           ";
    String ones =
            "                           \n" +
                    "  |  |  |  |  |  |  |  |  |\n" +
                    "  |  |  |  |  |  |  |  |  |\n" +
                    "                           ";
    String twos =
            " _  _  _  _  _  _  _  _  _ \n" +
                    " _| _| _| _| _| _| _| _| _|\n" +
                    "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
                    "                           ";
    String threes =
            " _  _  _  _  _  _  _  _  _ \n" +
                    " _| _| _| _| _| _| _| _| _|\n" +
                    " _| _| _| _| _| _| _| _| _|\n" +
                    "                           ";
    String fours =
            "                           \n" +
                    "|_||_||_||_||_||_||_||_||_|\n" +
                    "  |  |  |  |  |  |  |  |  |\n" +
                    "                           ";
    String fives =
            " _  _  _  _  _  _  _  _  _ \n" +
                    "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
                    " _| _| _| _| _| _| _| _| _|\n" +
                    "                           ";
    String sixes =
            " _  _  _  _  _  _  _  _  _ \n" +
                    "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
                    "|_||_||_||_||_||_||_||_||_|\n" +
                    "                           ";
    String sevens =
            " _  _  _  _  _  _  _  _  _ \n" +
                    "  |  |  |  |  |  |  |  |  |\n" +
                    "  |  |  |  |  |  |  |  |  |\n" +
                    "                           ";
    String eigths =
            " _  _  _  _  _  _  _  _  _ \n" +
                    "|_||_||_||_||_||_||_||_||_|\n" +
                    "|_||_||_||_||_||_||_||_||_|\n" +
                    "                           ";
    String nines =
            " _  _  _  _  _  _  _  _  _ \n" +
                    "|_||_||_||_||_||_||_||_||_|\n" +
                    " _| _| _| _| _| _| _| _| _|\n" +
                    "                           ";
    String oneToNine =
            "    _  _     _  _  _  _  _ \n" +
                    "  | _| _||_||_ |_   ||_||_|\n" +
                    "  ||_  _|  | _||_|  ||_| _|\n" +
                    "                           ";

    OCR ocr = new OCR();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void splitStringsCorretly() {
        String[] expected = { " _  _  _  _  _  _  _  _  _ ", "| || || || || || || || || |", "|_||_||_||_||_||_||_||_||_|", "                           " };
        assertArrayEquals(expected, ocr.splitStrings(zeroes));
    }

    @Test
    public void splitNumbersCorrectly() {
        String[] input = ocr.splitStrings(zeroes);
        Digit[] expected = { new Digit(" _ ", "| |", "|_|"), new Digit(" _ ", "| |", "|_|"), new Digit(" _ ", "| |", "|_|"),
            new Digit(" _ ", "| |", "|_|"), new Digit(" _ ", "| |", "|_|"), new Digit(" _ ", "| |", "|_|"),
            new Digit(" _ ", "| |", "|_|"), new Digit(" _ ", "| |", "|_|"), new Digit(" _ ", "| |", "|_|") };
        assertArrayEquals(expected, ocr.splitNumbers(input));
    }

    @Test
    public void recognizeOnes() {
        assertEquals("111111111", ocr.parse(ones));
    }

    @Test
    public void recognizeTwos() {
        assertEquals("222222222", ocr.parse(twos));
    }

    @Test
    public void recognizeThrees() {
        assertEquals("333333333", ocr.parse(threes));
    }

    @Test
    public void recognizeFours() {
        assertEquals("444444444", ocr.parse(fours));
    }

    @Test
    public void recognizeFives() {
        assertEquals("555555555", ocr.parse(fives));
    }

    @Test
    public void recognizeSixes() {
        assertEquals("666666666", ocr.parse(sixes));
    }

    @Test
    public void recognizeSevens() {
        assertEquals("777777777", ocr.parse(sevens));
    }

    @Test
    public void recognizeEights() {
        assertEquals("888888888", ocr.parse(eigths));
    }

    @Test
    public void recognizeNines() {
        assertEquals("999999999", ocr.parse(nines));
    }

    @Test
    public void recognizeZeroes() {
        assertEquals("000000000", ocr.parse(zeroes));
    }

    @Test
    public void recognizeOneToNine() {
        assertEquals("123456789", ocr.parse(oneToNine));
    }

    @Test
    public void accountNumberIsValid() {
        assertTrue(ocr.isValidAccount("345882865"));
    }

    @Test
    public void checksumIs0() {
        assertEquals(0, ocr.calculateChecksum("345882865"));
    }

    @Test
    public void testReadfile() {
        boolean test = ocr.readFile("usecase1.txt", "outputuc1.txt");
        assertTrue(test);
    }

    @Test
    public void recognizesErrorInChecksum() {
        String input = ocr.parse(ones);
        assertEquals("111111111 ERR", ocr.filterOutput(input));
    }

    @Test
    public void recognizesErrorsInInputFile() {
        boolean test = ocr.readFile("usecase3.txt", "outputuc3.txt");
        assertTrue(test);
    }
}
