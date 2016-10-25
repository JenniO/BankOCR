package main;

public class FizzBuzz {

    public Object[] filter(int[] input) {
        Object[] result = new Object[input.length];

        for (int i = 0; i < input.length; i++) {
            result[i] = convert(input[i]);
        }

        return result;
    }

    public Object convert(Object input) {
        Object result = input;
        if ((int) input % 3 == 0) {
            result = "Fizz";
        }
        if ((int) input % 5 == 0) {
            result = "Buzz";
        }
        if ((int) input % 15 == 0) {
            result = "FizzBuzz";
        }

        return result;
    }
}
