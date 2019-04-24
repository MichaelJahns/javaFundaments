package testInhertiance;

import javaFundaments.inhertiance.Restaurant;
import javaFundaments.inhertiance.Review;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testReview {

    //We actually want to make sure that no review is ever default. That kind of information is unhelpful for the food industry.
//    @Test
//    public void defaultReviewConstructor() {
//    }

    @Test
    public void testToStringOverride() {
        Restaurant testerToString = new Restaurant("Tester", "The corner", 5);

        Review actual = testerToString.addReview("Patty Murphy", "Very Testy Service", 1);
        String expected = "Tester at The corner $$$$$\n" +
                "  Rating: 1 stars By: Patty Murphy Review: Very Testy Service";

        assertEquals(expected, actual.toString());

    }

    @Test
    public void testGetRating() {
        Restaurant highClass = new Restaurant("Palace", "Mountaintop", 5);

        Review actual1 = highClass.addReview("Rich Man Kim", "Very Expensive", 5);
        int expected1 = 5;

        assertEquals(expected1, actual1.getRating());

        Restaurant dive = new Restaurant("Dumpster", "Back Alley", 1);

        Review actual2 = dive.addReview("Slik", "Not fresh.", 1);
        int expected2 = 1;

        assertEquals(expected2, actual2.getRating());
    }
}
