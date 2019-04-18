/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package basicLibrary;

import java.util.HashSet;

public class Library {
    public static void main(String args[]) {
        int[][] weatherData = {
                {66, 64, 58, 65, 71, 57, 60},
                {57, 65, 65, 70, 72, 65, 51},
                {55, 54, 60, 53, 59, 57, 61},
                {65, 56, 55, 52, 55, 62, 57}
        };
        hashSet(weatherData);
    }

    public static HashSet<Integer> hashSet(int[][] weatherData) {
        HashSet<Integer> hash = new HashSet<>();

        for (int i = 0; i < weatherData.length; i++) {
            for (int j = 0; j < weatherData[i].length; j++) {
                hash.add(weatherData[i][j]);
            }
        }
        return hash;
    }

    public static int[] roll(int attempts) {
        int[] output = new int[attempts];
        for (int i = 0; i < attempts; i++) {
            int roll = (int) Math.round(Math.random() * 5 + 1);
            output[i] = roll;
        }
        return output;
    }

    public static int[] roll(int attempts, int possibilities) {
        int[] output = new int[attempts];
        for (int i = 0; i < attempts; i++) {
            int roll = (int) Math.round(Math.random() * (possibilities - 1) + 1);
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

    public static int[] lowestAverageArray(int[][] masterArray) {
        int[] arrayAverages = new int[masterArray.length];
        for (int i = 0; i < masterArray.length; i++) {
            arrayAverages[i] = calculateAverage(masterArray[i]);
        }
        int index = findIndex(arrayAverages, findSmallest(arrayAverages));
        return masterArray[index];
    }

    public static int findIndex(int[] array, int target) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == target) {
                return i;
            }
        return -1;
    }

    public static int findSmallest(int[] array) {
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
}
