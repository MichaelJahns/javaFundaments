package javaFundaments.basicsLibrary;

import java.util.*;

public class basicsLibrary {
    public static void main(String args[]) {
        List<String> votes = new ArrayList<>();
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Bush");
        votes.add("Shrub");
        votes.add("Hedge");
        votes.add("Shrub");
        votes.add("Bush");
        votes.add("Hedge");
        votes.add("Bush");

        String winner = tally(votes);

        System.out.println(winner + " received the most votes!");

    }

    public static String tally(List<String> votes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < votes.size(); i++) {
            int votePortion = Collections.frequency(votes, votes.get(i));
            map.put(votes.get(i), votePortion);
        }

        String winner = "";
        int highestVoteCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > highestVoteCount) {
                highestVoteCount = entry.getValue();
                winner = entry.getKey();
            }

        }
        return winner;
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

    public static void analyzeHash(HashSet<Integer> hash) {
        List<Integer> list = new ArrayList<Integer>(hash);
        Collections.sort(list);

        System.out.println("Lowest temp: " + list.get(0));
        System.out.println("Highest temp " + list.get(list.size() - 1));

        for (int i = 0; i < list.get(list.size() - 1); i++) {
            if (i < list.get(0)) {
                continue;
            }
            if (!list.contains(i)) {
                System.out.println("Never seen " + i);
            }
        }
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
