/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package basicLibrary;

import java.util.Arrays;

public class Library {
    public static void main(String args[]) {
        calculateAverage(new int[]{100, 33, 6, 18});
    }

    public static int[] lowestAverageArray(int[][] masterArray) {
        int[] arrayAverages = new int[masterArray.length];
        for (int i = 0; i < masterArray.length; i++) {
            arrayAverages[i] = calculateAverage(masterArray[i]);
        }
        int index = findIndex(arrayAverages, findSmallestNumber(arrayAverages));
        System.out.println(Arrays.toString(masterArray[index]));
        return masterArray[index];
    }

    public static int findIndex(int[] array, int target) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == target) {
                return i;
            }
        return -1;
    }

    public static int findSmallestNumber(int[] array) {
        if (array.length == 0) {
            return -1;
        }
        int smallestNumber = array[0];
        for (int i = 0; i < array.length; i++) {
            if (smallestNumber > array[i]) {
                smallestNumber = array[i];
            }
        }
        return smallestNumber;
    }

    public static int[] roll(int attempts) {
        int[] output = new int[attempts];
        for (int i = 0; i < attempts; i++) {
            int roll = (int) (Math.random() * 5 + 1);
            output[i] = roll;
        }
        return output;
    }

    public static boolean containsDuplicates(int[] array) {
        boolean duplicates = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j && array[i] == array[j]) {
                    duplicates = true;
                }
            }
        }
        return duplicates;
    }

    public static int calculateAverage(int[] array) {
        int accumulator = 0;
        for (int i = 0; i < array.length; i++) {
            accumulator += array[i];
        }
        int average = accumulator / array.length;
        return average;
    }


}
