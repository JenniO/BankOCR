package roman.numerals;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArabicNumeralTest {

    ArabicNumeral arabicNumber = new ArabicNumeral();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void oneConvertsToI() {
        assertEquals("I", arabicNumber.convert(1));
    }

    @Test
    public void fiveConvertsToV() {
        assertEquals("V", arabicNumber.convert(5));
    }

    @Test
    public void tenConvertsToX() {
        assertEquals("X", arabicNumber.convert(10));
    }

    @Test
    public void fiftyConvertsToL() {
        assertEquals("L", arabicNumber.convert(50));
    }

    @Test
    public void hundredConvertsToC() {
        assertEquals("C", arabicNumber.convert(100));
    }

    @Test
    public void fivehundredConvertsToD() {
        assertEquals("D", arabicNumber.convert(500));
    }

    @Test
    public void thousandConvertsToM() {
        assertEquals("M", arabicNumber.convert(1000));
    }
}
