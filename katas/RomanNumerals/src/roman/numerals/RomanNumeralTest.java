package roman.numerals;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RomanNumeralTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void IConvertsTo1() {
        RomanNumeral numeral = new RomanNumeral("I");
        assertEquals(1, numeral.convert());
    }

    @Test
    public void VConvertsTo5() {
        RomanNumeral numeral = new RomanNumeral("V");
        assertEquals(5, numeral.convert());
    }

    @Test
    public void XConvertsTo10() {
        RomanNumeral numeral = new RomanNumeral("X");
        assertEquals(10, numeral.convert());
    }

    @Test
    public void LConvertsTo50() {
        RomanNumeral numeral = new RomanNumeral("L");
        assertEquals(50, numeral.convert());
    }

    @Test
    public void CConvertsTo100() {
        RomanNumeral numeral = new RomanNumeral("C");
        assertEquals(100, numeral.convert());
    }

    @Test
    public void DConvertsTo500() {
        RomanNumeral numeral = new RomanNumeral("D");
        assertEquals(500, numeral.convert());
    }

    @Test
    public void MConvertsTo1000() {
        RomanNumeral numeral = new RomanNumeral("M");
        assertEquals(1000, numeral.convert());
    }

    @Test
    public void IIConvertsTo2() {
        RomanNumeral numeral = new RomanNumeral("II");
        assertEquals(2, numeral.convert());
    }

    @Test
    public void IIIConvertsTo3() {
        RomanNumeral numeral = new RomanNumeral("III");
        assertEquals(3, numeral.convert());
    }

    @Test
    public void VIIConvertsTo7() {
        RomanNumeral numeral = new RomanNumeral("VII");
        assertEquals(7, numeral.convert());
    }

    @Test
    public void XVConvertsTo15() {
        RomanNumeral numeral = new RomanNumeral("XV");
        assertEquals(15, numeral.convert());
    }

    @Test
    public void LXConvertsTo60() {
        RomanNumeral numeral = new RomanNumeral("LX");
        assertEquals(60, numeral.convert());
    }

    @Test
    public void CLConvertsTo150() {
        RomanNumeral numeral = new RomanNumeral("CL");
        assertEquals(150, numeral.convert());
    }

    @Test
    public void DCConvertsTo600() {
        RomanNumeral numeral = new RomanNumeral("DC");
        assertEquals(600, numeral.convert());
    }

    @Test
    public void MCConvertsTo1100() {
        RomanNumeral numeral = new RomanNumeral("MC");
        assertEquals(1100, numeral.convert());
    }

    @Test
    public void IVConvertsTo4() {
        RomanNumeral numeral = new RomanNumeral("IV");
        assertEquals(4, numeral.convert());
    }

    @Test
    public void IXConvertsTo9() {
        RomanNumeral numeral = new RomanNumeral("IX");
        assertEquals(9, numeral.convert());
    }

    @Test
    public void XLConvertsTo40() {
        RomanNumeral numeral = new RomanNumeral("XL");
        assertEquals(40, numeral.convert());
    }

    @Test
    public void MCMXCIXConvertsTo1999() {
        RomanNumeral numeral = new RomanNumeral("MCMXCIX");
        assertEquals(1999, numeral.convert());
    }

    @Test
    public void CDXLVIIIConvertsTo448() {
        RomanNumeral numeral = new RomanNumeral("CDXLVIII");
        assertEquals(448, numeral.convert());
    }

}
