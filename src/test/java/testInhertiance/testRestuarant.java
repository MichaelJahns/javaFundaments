package testInhertiance;

import javaFundaments.inhertiance.Restaurant;
import javaFundaments.inhertiance.Review;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class testRestuarant {
    @Test
    public void defaultRestaurantConstructor() {
        Restaurant actual = new Restaurant();
        String expected = "Unnamed at Undisclosed Location \n ";

        assertEquals(expected, actual.toString());
    }

    @Test
    public void testUpdateStars() {
        Restaurant halfGood = new Restaurant("The Cut Corner", "Circle Rounadbout", 3);
        halfGood.addReview("MBoy", "Not Good.", 2);
        halfGood.addReview("JDawg", "Very GOod.", 5);

        double expected = 3.5;
        //To compare doubles a third variable delta is needed, this is effectively my accepted Margin of Error.
        assertEquals(expected, halfGood.rating, 0.01);
    }

    @Test
    public void testToString() {
        Restaurant actual = new Restaurant("Anns!", "Near You!", 1);

        String expected = "Anns! at Near You! $\n ";
        assertEquals(expected, actual.toString());
    }

    @Test
    public void testGetPrice() {
        Restaurant cheaper = new Restaurant("cheap", "cheap land", 1);
        String expectedCheaper = "$";
        Restaurant expensive = new Restaurant("expensive", "You can't afford the transit", 5);
        String expectedExpensive = "$$$$$";

        assertEquals(expectedCheaper, cheaper.getPrice());
        assertEquals(expectedExpensive, expensive.getPrice());
    }

    @Test
    public void testAddReview() {
        Restaurant tester = new Restaurant();

        String expected = "Unnamed at Undisclosed Location \n" +
                "  Rating: 5 stars By: Mikel Jay Review: Okay, i guess";
        Review actual = tester.addReview("Mikel Jay", "Okay, i guess", 5);

        assertEquals(expected, actual.toString());
    }

    //This test does not pass. For whatever reason expected has extra lagging whitespace after the ArrayList?
    @Test
    public void testGetReviews() {
        Restaurant subway = new Restaurant("Subway", "3rd and Bell", 2);

        subway.addReview("James Matterson", "Irregular shaped ham", 2);
        subway.addReview("Mable Pouer", "Very good ventiliation", 5);
        subway.addReview("Keel of a boat", "Barely Nautical at all", 4);

        List expected = new ArrayList();
        expected.add("Subway at 3rd and Bell $$\n" +
                "  Rating: 2 stars By: James Matterson Review: Irregular shaped ham");
        expected.add("Subway at 3rd and Bell $$\n" +
                "  Rating: 5 stars By: Mable Pouer Review: Very good ventiliation");
        expected.add("Subway at 3rd and Bell $$\n" +
                "  Rating: 4 stars By: Keel of a boat Review: Barely Nautical at all");
        List actual = subway.getReviews();

        assertEquals(expected, actual);
    }
}
