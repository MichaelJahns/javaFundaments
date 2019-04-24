package testInhertiance;

import javaFundaments.inhertiance.Restaurant;
import javaFundaments.inhertiance.Review;
import javaFundaments.inhertiance.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testReview {

    @Test
    public void testToStringOverride() {
        User patty = new User("Patty Murphy");
        Restaurant testerToString = new Restaurant("Tester", "The corner", 5, "tests");

        Review actual = testerToString.reviewBusiness(patty, "Very Testy Service", 1);
        String expected = "Patty Murphy Tester review: Very Testy Service 1stars";
        assertEquals("toString output unexpected", expected, actual.toString());

    }

    @Test
    public void testGetRating() {
        User kim = new User("Mr. Kim Rich Man");
        Restaurant highClass = new Restaurant("Palace", "Mountaintop", 5, "tests");

        Review actual1 = highClass.reviewBusiness(kim, "Very Expensive", 5);
        int expected1 = 5;

        assertEquals("getRating() return unexpected", expected1, actual1.getRating());

        Restaurant dive = new Restaurant("Dumpster", "Back Alley", 1, "tests");

        Review actual2 = dive.reviewBusiness(kim, "Not fresh.", 1);
        int expected2 = 1;

        assertEquals("getRating() return unexpected", expected2, actual2.getRating());
    }
}
