package de.ozolins.bankocr;

public class Digit {

    String row1;
    String row2;
    String row3;

    public Digit(String row1, String row2, String row3) {
        setRow1(row1);
        setRow2(row2);
        setRow3(row3);
    }

    public boolean isValid() {
        String pattern = "[ |][ _][ |]";
        boolean valid = row1.matches(" [ _] ");
        valid &= row2.matches(pattern);
        valid &= row3.matches(pattern);
        return valid;
    }

    public String getRow1() {
        return row1;
    }

    public void setRow1(String row1) {
        this.row1 = row1;
    }

    public String getRow2() {
        return row2;
    }

    public void setRow2(String row2) {
        this.row2 = row2;
    }

    public String getRow3() {
        return row3;
    }

    public void setRow3(String row3) {
        this.row3 = row3;
    }

    public String getDigit() {

        if (row1.equals("   ")) {
            if (row2.equals("  |") && row3.equals("  |")) {
                return "1";
            } else if (row2.equals("|_|") && row3.equals("  |")) {
                return "4";
            } else {
                return "?";
            }
        } else if (row1.equals(" _ ")) {
            if (row2.equals("  |") && row3.equals("  |")) {
                return "7";
            } else if (row2.equals(" _|")) {
                if (row3.equals(" _|")) {
                    return "3";
                } else if (row3.equals("|_ ")) {
                    return "2";
                } else {
                    return "?";
                }
            } else if (row2.equals("|_ ")) {
                if (row3.equals(" _|")) {
                    return "5";
                } else if (row3.equals("|_|")) {
                    return "6";
                } else {
                    return "?";
                }
            } else if (row2.equals("|_|")) {
                if (row3.equals("|_|")) {
                    return "8";
                } else if (row3.equals(" _|")) {
                    return "9";
                } else {
                    return "?";
                }
            } else if (row2.equals("| |") && row3.equals("|_|")) {
                return "0";
            } else {
                return "?";
            }
        } else {
            return "?";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Digit)) {
            return false;
        }
        if (this.row1.equals(((Digit) obj).row1) && this.row2.equals(((Digit) obj).row2) && this.row3.equals(((Digit) obj).row3)) {
            return true;
        } else {
            return false;
        }
    }

}
