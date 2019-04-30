package testInhertiance;

import javaFundaments.inhertiance.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class testBusiness {

    @Test
    public void testNewRestaurant() {
        Restaurant restaurant = new Restaurant("Restaurant", "Here", 5, "Food");
        List<Review> actual = restaurant.getReviews();
        List<Review> expected = new ArrayList<>();

        assertEquals("New Restaurant name was not expected", "Restaurant", restaurant.name);
        assertEquals("New Restaurant location was not expected", "Here", restaurant.location);
        assertEquals("New Restaurant rating was not expected", 0, restaurant.rating, .0001);
        assertEquals("New Restaurant averagePrice was not expected", 5, restaurant.averagePrice);
        assertEquals("New Restaurant did not have an empty review list", expected, actual);
    }

    @Test
    public void testNewShop() {
        Shop shop = new Shop("Shop", "Here", 5, "Stuff");
        List<Review> actual = shop.getReviews();
        List<Review> expected = new ArrayList<>();

        assertEquals("New Shop name was not expected", "Shop", shop.name);
        assertEquals("New Shop location was not expected", "Here", shop.location);
        assertEquals("New Shop rating was not expected", 0, shop.rating, .0001);
        assertEquals("New Shop averagePrice was not expected", 5, shop.averagePrice);
        assertEquals("New Shop did not have an empty review list", expected, actual);
    }

    @Test
    public void testNewTheater() {
        Theater theater = new Theater("Theater", "Here", 5);

        List<Review> actual = theater.getReviews();
        List<Review> expected = new ArrayList<>();

        assertEquals("New Theater name was not expected", "Theater", theater.name);
        assertEquals("New Theater location was not expected", "Here", theater.location);
        assertEquals("New Theater rating was not expected", 0, theater.rating, .0001);
        assertEquals("New Theater averagePrice was not expected", 5, theater.averagePrice);
        assertEquals("New Theater did not have an empty review list", expected, actual);
    }

    @Test
    public void testBusinessToString() {
        Restaurant restaurant = new Restaurant("Restaurant", "Here", 5, "Food");
        Shop shop = new Shop("Shop", "Here", 5, "Stuff");
        Theater theater = new Theater("Theater", "Here", 5);

        String restaurantExpected = "Restaurant, Here: 0.00 stars $$$$$ Serves Food";
        String shopExpected = "Shop, Here: 0.00 stars $$$$$ Sells Stuff";
        String theaterExpected = "Theater, Here: 0.00 stars $$$$$\n" +
                " Now Showing: ";

        //Asserts that a newly created business has the correct toString() output
        assertEquals(restaurantExpected, restaurant.toString());
        assertEquals(shopExpected, shop.toString());
        assertEquals(theaterExpected, theater.toString());
    }

    @Test
    public void testGetPrice() {
        Restaurant cheaper = new Restaurant("cheap", "Here", 1, "cheapFood");
        String expectedCheaper = "$";
        assertEquals(expectedCheaper, cheaper.getPrice());

        Restaurant midRange = new Restaurant("midRange", "Here", 3, "middleFood");
        String expectedMidRange = "$$$";
        assertEquals(expectedMidRange, midRange.getPrice());

        Restaurant expensive = new Restaurant("expensive", "Here", 5, "expensiveFood");
        String expectedExpensive = "$$$$$";
        assertEquals(expectedExpensive, expensive.getPrice());
    }

    @Test
    public void testReviewBusinessSizes() {
        User reviewer = new User("Reviewer");
        Restaurant tester = new Restaurant("tester", "Here", 1, "tests");

        tester.reviewBusiness(reviewer, "Test", 5);

        int expectedReviews = 1;
        int actualBusinessReviews = tester.reviews.size();
        int actualUserReviews = reviewer.history.size();

        assertEquals("Business reviews <> expected size", expectedReviews, actualBusinessReviews);
        assertEquals("User reviews <> expected size", expectedReviews, actualUserReviews);

        assertFalse(expectedReviews != actualBusinessReviews);
        assertFalse(expectedReviews != actualUserReviews);
    }

    @Test
    public void testGetReviews() {
        User reviewer = new User("Reviewer");
        List expected = new ArrayList() {
        };

        Restaurant tester = new Restaurant("tester", "Here", 1, "tests");
        tester.reviewBusiness(reviewer, "Test", 5);
        expected.add("Reviewer tester review: Test 5stars");
        List actualBusinessReviews1 = tester.getReviews();
        assertEquals("Review was not saved in the expected format", expected.toString(), actualBusinessReviews1.toString());

        Restaurant tester2 = new Restaurant("tester2", "Here2", 1, "tests2");
        tester2.reviewBusiness(reviewer, "Test2", 5);
        List actualBusinessReviews2 = tester2.getReviews();
        assertEquals("Review was not saved in the expected format", "[Reviewer tester2 review: Test2 5stars]", actualBusinessReviews2.toString());

        Restaurant tester3 = new Restaurant("tester3", "Here3", 1, "tests3");
        tester3.reviewBusiness(reviewer, "Test3", 5);
        List actualBusinessReviews3 = tester3.getReviews();
        assertEquals("Review was not saved in the expected format", "[Reviewer tester3 review: Test3 5stars]", actualBusinessReviews3.toString());

    }

    @Test
    public void testUpdateRating() {
        User reviewerGood = new User("Reviewer");
        User reviewerBad = new User("Reviewer");
        Restaurant restaurant = new Restaurant("Restaurant", "Here", 3, "Food");

        double actualBefore = restaurant.rating;
        double expectedBefore = 0;
        //To Compare doubles a fourth parameter, delta, is required. This is essentially the Margin of Error
        assertEquals("Average Reviews were not initalized correctly", expectedBefore, actualBefore, 0.001);

        restaurant.reviewBusiness(reviewerGood, "Good", 5);
        double actualMiddle = restaurant.rating;
        double expectedMiddle = 5;
        assertEquals("Reviews were not averaged as expected", expectedMiddle, actualMiddle, 0.001);

        restaurant.reviewBusiness(reviewerBad, "Bad", 1);
        double actualAfter = restaurant.rating;
        double expectedAfter = 3.0;
        assertEquals("Reviews were not averaged as expected", expectedAfter, actualAfter, 0.001);
    }
}
