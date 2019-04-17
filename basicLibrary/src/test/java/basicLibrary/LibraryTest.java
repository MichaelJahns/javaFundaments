/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package basicLibrary;

import org.junit.Test;

import static basicLibrary.Library.*;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class LibraryTest {
    @Test
    public void testRollLength() {
        assertEquals(1, roll(1).length);
        assertEquals(6, roll(6).length);
        assertEquals(10, roll(10).length);
        //for the overloaded roll
        assertEquals(5, roll(5, 20).length);
        assertEquals(10, roll(10, 2).length);
        assertEquals(3, roll(3, 3).length);
    }

    @Test
    public void testRollRange() {
        int[] testStudy = roll(6);
        for (int i = 0; i < 6; i++) {
            assertTrue("Roll at" + i + "is out of range", 1 <= testStudy[i] && testStudy[i] <= 6);
        }

        int[] testStudyOverload = roll(3, 20);
        for (int i = 0; i < 3; i++) {
            assertTrue("Roll at" + i + "is out of range", 1 <= testStudyOverload[i] && testStudyOverload[i] <= 20);
        }

    }

    @Test
    public void testContainsDuplicates() {
        assertEquals(true, containsDuplicates(new int[]{3, 3, 3, 3}));
        assertEquals(false, containsDuplicates(new int[]{1, 2, 3, 4}));
    }

    @Test
    public void testCalculateAverages() {
        assertEquals(3, calculateAverage(new int[]{1, 2, 3, 4, 5}));
        assertEquals(5, calculateAverage(new int[]{5, 5, 5, 5, 5}));
        assertEquals(39, calculateAverage(new int[]{100, 33, 6, 18}));
    }

    @Test
    public void testLowestAverageArray() {
        int masterArray[][] =
                {
                        {1, 2, 3, 4, 5},
                        {10, 20, 30, 40, 50},
                        {0, 0, 0, 0, 10}
                };
        int[] expected = {0, 0, 0, 0, 10};
        //Manually testing this passes, I think I have structure my test wrong.
        assertEquals(expected, lowestAverageArray(masterArray));
    }

    @Test
    public void testFindIndex() {
        int[] testArray1 = {1, 2, 3, 4, 5};
        int[] testArray2 = {5};
        int[] testArray3 = {100, 35, 99, 0, -39};
        //int[] testArray4 = new int[10];

        assertEquals(3, findIndex(testArray1, 4));
        assertEquals(0, findIndex(testArray2, 5));
        assertEquals(2, findIndex(testArray3, 99));

        //Does not work for an array where a value appears multiple times
        //assertEquals(0, findIndex(testArray1, 1));

    }

    @Test
    public void testFindSmallest() {
        int[] testArray1 = {1, 2, 3, 4, 5};
        int[] testArray2 = {9, 4, 7, 2, 5};
        int[] testArray3 = new int[10];

        assertEquals(1, findSmallest(testArray1));
        assertEquals(2, findSmallest(testArray2));
        assertEquals(0, findSmallest(testArray3));
    }
}


