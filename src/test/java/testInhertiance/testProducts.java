package testInhertiance;

import javaFundaments.inhertiance.Theater;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class testProducts {
    @Test
    public void testAddProduct() {
        Theater theater = new Theater("theather", "here", 5);

        List<String> expected = new ArrayList<>();
        List<String> actualBefore = theater.getShowing();
        assertEquals("Theater showing was not expected on initialization", expected, actualBefore);

        theater.addMovie("Movie 1");
        expected.add("Movie 1");
        List<String> actualMiddle = theater.getShowing();
        assertEquals("Theater showing was not expected after addition", expected, actualMiddle);

        theater.addMovie("Movie 2");
        expected.add("Movie 2");
        theater.addMovie("Movie 3");
        expected.add("Movie 3");
        theater.addMovie("Movie 4");
        expected.add("Movie 4");
        List<String> actualAfter = theater.getShowing();
        assertEquals("Theater showing was not expected after additions", expected, actualAfter);
    }

    @Test
    public void testRemoveProduct() {
        Theater theater = new Theater("theather", "here", 5);

        List<String> expected = new ArrayList<>();
        theater.addMovie("Movie 1");
        expected.add("Movie 1");
        theater.addMovie("Movie 2");
        expected.add("Movie 2");
        theater.addMovie("Movie 3");
        expected.add("Movie 3");
        theater.addMovie("Movie 4");
        expected.add("Movie 4");
        List<String> actualBefore = theater.getShowing();
        assertEquals("Theater showing was not expected after additions", expected, actualBefore);

        theater.removeMovie("Movie 2");
        expected.remove("Movie 2");
        List<String> actualMiddle = theater.getShowing();
        assertEquals("Theater showing was not expected after a removal", expected, actualMiddle);

        theater.removeMovie("Movie 1");
        expected.remove("Movie 1");
        theater.removeMovie("Movie 4");
        expected.remove("Movie 4");
        List<String> actualAfter = theater.getShowing();
        assertEquals("Theater showing not expected after several removals", expected, actualAfter);
    }

    @Test
    public void testReviewProduct() {

    }
}
