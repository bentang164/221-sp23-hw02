package edu.macalester.comp221.hw2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PerformanceAnalyzer {
    private static void executeAdd(int location) {
        Map<Integer, Long> avgTime = new HashMap<>();
        System.out.println("\nAssessing performance of selected add operation.\n");

        for (int n = 1; n <= 1000000; n *= 10) {
            System.out.println("Testing n = " + n);

            long start = 0;
            long end = 0;

            List<Long> initialTime = new ArrayList<>();

            for (int j = 0; j < 10; j++) {
                start = getCurrentTime();

                for (int k = 0; k < n; k++) {
                    List<Integer> test = new ArrayList<>();

                    if (location == 1) test.add(0, k);
                    if (location == 2) executeManipulateMiddle(n, k, true);
                    if (location == 3) test.add(k);
                }

                end = getCurrentTime();

                initialTime.add(end - start);
            }

            avgTime.put(n, getAverage(initialTime));

            System.out.println("Selected operation complete for n = " + n + ".\n");
        }

        System.out.println("Selected add operation complete. Time taken for various values of n:" +
        "\nn = 1: " + avgTime.get(1) + "ms. " + "\nn = 10: " + avgTime.get(10) + "ms. " + "\nn = 100: " + avgTime.get(100) + "ms. " + 
        "\nn = 1,000: " + avgTime.get(1000) + "ms. " + "\nn = 10,000: " + avgTime.get(10000) + "ms. " + 
        "\nn = 100,000: " + avgTime.get(100000) + "ms. " + "\nn = 1,000,000: " + avgTime.get(1000000) + "ms. " + 
        "\nn = 10,000,000: " + avgTime.get(10000000) + "ms. " + "\nn = 100,000,000: " + avgTime.get(100000000) + "ms.");
    }

    private static void executeManipulateMiddle(int n, int k, boolean add) {
        List<Integer> testMiddle = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            testMiddle.add(i);
        }

        if (add) testMiddle.add(testMiddle.size() / 2, n);
        if (!add) testMiddle.remove(testMiddle.size() / 2);
    }

    private static long getAverage(List<Long> input) {
        long average = 0;
        
        for (long timestamp : input) {
            average += timestamp;
        }

        return average / input.size();
    }

    private static void executeDel(int location) {
        Map<Integer, Long> avgTime = new HashMap<>();
        System.out.println("\nAssessing performance of selected removal operation.\n");

        for (int n = 1; n <= 100000; n *= 10) {
            System.out.println("Testing n = " + n);
            
            long start = 0;
            long end = 0;
            List<Long> initialTime = new ArrayList<>();

            for (int j = 0; j < 10; j++) {
                List<Integer> test = new ArrayList<>();

                for (int k = 0; k < n; k++) {
                    test.add(k);
                }

                start = getCurrentTime();

                for (int a = 0; a < n; a++) {

                    if (location == 1) test.remove(0);
                    if (location == 2) executeManipulateMiddle(n, a, false);
                    if (location == 3) test.remove(test.size() - 1);
                }

                end = getCurrentTime();

                initialTime.add(end - start);
            }

            avgTime.put(n, getAverage(initialTime));

            System.out.println("Selected operation complete for n = " + n + ".\n");
        }

        System.out.println("Selected add operation complete. Time taken for various values of n:" +
        "\nn = 1: " + avgTime.get(1) + "ms. " + "\nn = 10: " + avgTime.get(10) + "ms. " + "\nn = 100: " + avgTime.get(100) + "ms. " + 
        "\nn = 1,000: " + avgTime.get(1000) + "ms. " + "\nn = 10,000: " + avgTime.get(10000) + "ms. " + 
        "\nn = 100,000: " + avgTime.get(100000) + "ms. " + "\nn = 1,000,000: " + avgTime.get(1000000) + "ms. " + 
        "\nn = 10,000,000: " + avgTime.get(10000000) + "ms. " + "\nn = 100,000,000: " + avgTime.get(100000000) + "ms.");
    }

    private static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.print("Would you like to assess the performance of add operations or remove operations? Enter '1' for add, or '2' for remove: ");
        int addOrRemove = keyboard.nextInt();

        if (addOrRemove == 1) {
            System.out.print("Which operation do you want to execute? Enter '1' to add to the front, '2' to add to the middle, or '3' to add to the rear: ");
            int locationAdd = keyboard.nextInt();

            executeAdd(locationAdd);
        } else if (addOrRemove == 2) {
            System.out.print("Which operation do you want to execute? Enter '1' to remove from the front, '2' to remove from the middle, or '3' to remove from the rear: ");
            int locationRem = keyboard.nextInt();

            executeDel(locationRem);
        }

        keyboard.close();
    }
}
