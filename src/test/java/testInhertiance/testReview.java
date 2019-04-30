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
        Restaurant business1 = new Restaurant("Tester", "The corner", 5, "tests");
        Restaurant business2 = new Restaurant("Does", "Here nor there", 1, "tests");
        Restaurant business3 = new Restaurant("Tests", "Fart City", 3, "tests");

        Review business1Review = business1.reviewBusiness(patty, "Very Testy Service", 1);
        String expected1 = "Patty Murphy Tester review: Very Testy Service 1stars";
        assertEquals("toString output unexpected", expected1, business1Review.toString());


        Review business2Review = business2.reviewBusiness(patty, "Couldn't find it", 2);
        String expected2 = "Patty Murphy Does review: Couldn't find it 2stars";
        assertEquals("toString output unexpected", expected2, business2Review.toString());


        Review business3Review = business3.reviewBusiness(patty, "HA! very funny", 5);
        String expected3 = "Patty Murphy Tests review: HA! very funny 5stars";
        assertEquals("toString output unexpected", expected3, business3Review.toString());
    }

    @Test
    public void testGetRating() {
        User kim = new User("Mr. Kim Rich Man");

        Restaurant highClass = new Restaurant("Palace", "Mountaintop", 5, "tests");
        Review expensive = highClass.reviewBusiness(kim, "Very Expensive", 5);
        assertEquals("getRating() return unexpected", 5, expensive.getRating());

        Restaurant dive = new Restaurant("Dumpster", "Back Alley", 1, "tests");
        Review cheap = dive.reviewBusiness(kim, "Not fresh.", 1);
        assertEquals("getRating() return unexpected", 1, cheap.getRating());

        Restaurant midRange = new Restaurant("Mom N Pop", "Country Roads", 3, "tests");
        Review average = midRange.reviewBusiness(kim, "Alright", 3);
        assertEquals("getRating() return unexpected", 3, average.getRating());

    }
}
