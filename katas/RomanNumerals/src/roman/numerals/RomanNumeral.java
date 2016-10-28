package roman.numerals;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

    static Map<Character, Integer> translation = new HashMap<>();

    static {
        translation.put('I', 1);
        translation.put('V', 5);
        translation.put('X', 10);
        translation.put('L', 50);
        translation.put('C', 100);
        translation.put('D', 500);
        translation.put('M', 1000);
    }

    String romanNumber;
    // int arabicNumber;

    public RomanNumeral(String numeral) {
        romanNumber = numeral;
    }

    public int convert() {
        int arabicNumber = 0;
        int firstNumber;
        int secondNumber;

        if (romanNumber.length() == 0) {
            return 0;
        }
        if (romanNumber.length() == 1) {
            return translation.get(romanNumber.charAt(0));
        }
        for (int i = 1; i < romanNumber.length(); i++) {
            firstNumber = translation.get(romanNumber.charAt(i - 1));
            secondNumber = translation.get(romanNumber.charAt(i));
            if (firstNumber < secondNumber) {
                arabicNumber += secondNumber - firstNumber;
                i++;
            } else {
                arabicNumber += firstNumber;
                if (i == romanNumber.length() - 1) {
                    arabicNumber += secondNumber;
                }
            }
        }

        return arabicNumber;
    }

}
