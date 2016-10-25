package de.ozolins.bankocr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OCR {

    Digit[] digits;

    public String[] splitStrings(String input) {
        return input.split("\n");
    }

    public Digit[] splitNumbers(String[] input) {
        Digit[] digits = new Digit[9];
        int begin = 0;
        int end = 3;
        String row1, row2, row3;
        for (int i = 0; i < 9; i++) {
            row1 = input[0].substring(begin, end);
            row2 = input[1].substring(begin, end);
            row3 = input[2].substring(begin, end);
            digits[i] = new Digit(row1, row2, row3);
            begin += 3;
            end += 3;
        }
        return digits;
    }

    public String parse(String input) {
        String[] lines = splitStrings(input);
        digits = splitNumbers(lines);
        String output = "";
        for (Digit digit : digits) {
            output += digit.getDigit();
        }

        return output;
    }

    public String parse(String[] input) {
        // String[] lines = splitStrings(input);
        digits = splitNumbers(input);
        String output = "";
        for (Digit digit : digits) {
            output += digit.getDigit();
        }

        return output;
    }

    public boolean isValidAccount(String input) {

        int checksum = calculateChecksum(input);
        return checksum == 0;
    }

    public int calculateChecksum(String input) {
        int sum = 0;
        for (int i = 0, j = 9; i < input.length(); i++, j--) {
            sum += Character.getNumericValue(input.charAt(i)) * j;
        }
        return sum % 11;
    }

    public boolean readFile(String inputfile, String outputfile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputfile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile))) {
            String line;
            int lineNumber = 0;
            String[] account = new String[3];
            while ((line = reader.readLine()) != null) {
                if (lineNumber != 3) {
                    account[lineNumber++] = line;
                    System.out.println(line + " - " + lineNumber);
                } else {
                    System.out.print("Ergebnis: ");
                    String output = parse(account);
                    // if (isValidAccount(output)) {
                    // writer.write(output + "\n");
                    // } else {
                    //
                    // }
                    writer.write(filterOutput(output) + "\n");
                    System.out.println(filterOutput(output));
                    lineNumber = 0;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
            return false;
        } catch (IOException e1) {
            System.out.println("IOException");
            return false;
        }
        return true;
    }

    public String filterOutput(String input) {
        if (input.contains("?")) {
            return input + " ILL";
        } else if (isValidAccount(input)) {
            return input;
        } else {
            return input + " ERR";
        }
    }

}
