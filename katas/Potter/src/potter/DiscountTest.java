package potter;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiscountTest {

    Discount discount = new Discount();

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void noBooksCostNothing() {
        assertEquals(0, discount.price(new int[0]), 0.00001);
    }

    @Test
    public void bookOneCosts8Euro() {
        int[] input = { 0 };
        assertEquals(8, discount.price(input), 0.00001);
    }

    @Test
    public void bookTwoCosts8Euro() {
        int[] input = { 1 };
        assertEquals(8, discount.price(input), 0.00001);
    }

    @Test
    public void bookThreeCosts8Euro() {
        int[] input = { 2 };
        assertEquals(8, discount.price(input), 0.00001);
    }

    @Test
    public void bookFourCosts8Euro() {
        int[] input = { 3 };
        assertEquals(8, discount.price(input), 0.00001);
    }

    @Test
    public void bookFiveCosts8Euro() {
        int[] input = { 4 };
        assertEquals(8, discount.price(input), 0.00001);
    }

    @Test
    public void twoBookOneCost16Euro() {
        int[] input = { 0, 0 };
        assertEquals(16, discount.price(input), 0.00001);
    }

    @Test
    public void threeBookTwoCost24Euro() {
        int[] input = { 1, 1, 1 };
        assertEquals(24, discount.price(input), 0.00001);
    }

    @Test
    public void bookOneAndTwoGet5PercentDiscount() {
        int[] input = { 0, 1 };
        assertEquals(8 * 2 * 0.95, discount.price(input), 0.00001);
    }

    @Test
    public void bookOneAndTwoAndThreeGet10PercentDiscount() {
        int[] input = { 0, 1, 2 };
        assertEquals(8 * 3 * 0.9, discount.price(input), 0.00001);
    }

    @Test
    public void bookOneAndTwoAndThreeAndFiveGet20PercentDiscount() {
        int[] input = { 0, 1, 2, 4 };
        assertEquals(8 * 4 * 0.8, discount.price(input), 0.00001);
    }

    @Test
    public void bookOneToFiveGet25PercentDiscount() {
        int[] input = { 0, 1, 2, 3, 4 };
        assertEquals(8 * 5 * 0.75, discount.price(input), 0.00001);
    }

    @Test
    public void twoBookOneAndOneBookTwo() {
        int[] input = { 0, 0, 1 };
        assertEquals(8 + (8 * 2 * 0.95), discount.price(input), 0.00001);
    }

    @Test
    public void twoBookOneAndTwoBookTwo() {
        int[] input = { 0, 0, 1, 1 };
        assertEquals(2 * (8 * 2 * 0.95), discount.price(input), 0.00001);
    }

    @Test
    public void twoBookOneAndOneBookTwoAndTwoBookThreeAndOneBookFour() {
        int[] input = { 0, 0, 1, 2, 2, 3 };
        assertEquals((8 * 4 * 0.8) + (8 * 2 * 0.95), discount.price(input), 0.00001);
    }

    @Test
    public void bookOneToFiveAndBookTwo() {
        int[] input = { 0, 1, 1, 2, 3, 4 };
        assertEquals((8 * 5 * 0.75) + 8, discount.price(input), 0.00001);
    }

}
