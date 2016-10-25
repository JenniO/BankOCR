package test;

import static org.junit.Assert.assertArrayEquals;

import main.FizzBuzz;
import org.junit.Test;

public class FizzBuzzTest {

    FizzBuzz fb = new FizzBuzz();

    Object[] ARRAY_OF_FIZZ = { "Fizz" };
    Object[] ARRAY_OF_BUZZ = { "Buzz" };
    Object[] ARRAY_OF_1_2 = { 1, 2 };
    Object[] ARRAY_OF_FIZZ_7_8_FIZZ = { "Fizz", 7, 8, "Fizz" };
    Object[] ARRAY_OF_FIZZBUZZ = { "FizzBuzz" };
    Object[] ARRAY_OF_FIZZBUZZ_TO_FIZZBUZZ = { "FizzBuzz", 16, 17, "Fizz", 19, "Buzz", "Fizz", 22, 23, "Fizz", "Buzz", 26, "Fizz", 28, 29, "FizzBuzz" };

    @Test
    public void shouldReturnFizz() {
        int[] eingabe = { 3 };
        assertArrayEquals(ARRAY_OF_FIZZ, fb.filter(eingabe));
    }

    @Test
    public void shouldReturnBuzz() {
        int[] eingabe = { 5 };
        assertArrayEquals(ARRAY_OF_BUZZ, fb.filter(eingabe));
    }

    @Test
    public void shouldReturn1And2() {
        int[] eingabe = { 1, 2 };
        assertArrayEquals(ARRAY_OF_1_2, fb.filter(eingabe));
    }

    @Test
    public void shouldReturnFizz78Fizz() {
        int[] eingabe = { 6, 7, 8, 9 };
        assertArrayEquals(ARRAY_OF_FIZZ_7_8_FIZZ, fb.filter(eingabe));
    }

    @Test
    public void shouldReturnFizzBuzz() {
        int[] eingabe = { 15 };
        assertArrayEquals(ARRAY_OF_FIZZBUZZ, fb.filter(eingabe));
    }

    @Test
    public void shouldReturnFizzBuzzToFizzBuzz() {
        int[] eingabe = { 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 };
        assertArrayEquals(ARRAY_OF_FIZZBUZZ_TO_FIZZBUZZ, fb.filter(eingabe));
    }

}
