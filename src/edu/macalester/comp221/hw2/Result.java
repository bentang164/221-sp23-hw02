package edu.macalester.comp221.hw2;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public static String balancedSums(List<Integer> input) {
        if (input.size() == 1) return "YES";

        int sumLeft = 0;

        for (int i = 0; i < input.size(); i++) {
            int sumRight = 0;

            if (i != 0) sumLeft += input.get(i - 1);

            for (int j = i + 1; j < input.size(); j++) {
                sumRight += input.get(j);
            }

            if (sumLeft == sumRight) {
                return "YES";
            }
        }

        return "NO";
    }

    public static void main(String[] args) {
        List<Integer> testOne = new ArrayList<>();
        List<Integer> testTwo = new ArrayList<>();
        List<Integer> testThree = new ArrayList<>();
        List<Integer> testFour = new ArrayList<>();
        List<Integer> testFive = new ArrayList<>();

        // [1, 1, 4, 1, 1]
        testOne.add(1);
        testOne.add(1);
        testOne.add(4);
        testOne.add(1);
        testOne.add(1);

        // [2, 0, 0, 0]
        testTwo.add(2);
        testTwo.add(0);
        testTwo.add(0);
        testTwo.add(0);

        // [0, 0, 2, 0]
        testThree.add(0);
        testThree.add(0);
        testThree.add(2);
        testThree.add(0);

        // [1, 2, 3]
        testFour.add(1);
        testFour.add(2);
        testFour.add(3);

        // [1, 2, 3, 3]
        testFive.add(1);
        testFive.add(2);
        testFive.add(3);
        testFive.add(3);
        
        if (balancedSums(testOne) != "YES") {
            System.out.println("FAIL"); 
        } else {
            System.out.println("PASS");
        }
        if (balancedSums(testTwo) != "YES") {
            System.out.println("FAIL");
        } else {
            System.out.println("PASS");
        }
        if (balancedSums(testThree) != "YES") {
            System.out.println("FAIL");
        } else {
            System.out.println("PASS");
        }
        if (balancedSums(testFour) != "NO") {
            System.out.println("FAIL");
        } else {
            System.out.println("PASS");
        }
        if (balancedSums(testFive) != "YES") {
            System.out.println("FAIL");
        } else {
            System.out.println("PASS");
        }
    }
}