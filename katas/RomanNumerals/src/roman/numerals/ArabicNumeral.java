package roman.numerals;

public class ArabicNumeral {

    public String convert(int number) {
        if (number == 1) {
            return "I";
        }
        if (number == 5) {
            return "V";
        }
        if (number == 10) {
            return "X";
        }
        if (number == 50) {
            return "L";
        }

        if (number == 100) {
            return "C";
        }
        if (number == 500) {
            return "D";
        }

        if (number == 1000) {
            return "M";
        }
        return "";
    }

}
