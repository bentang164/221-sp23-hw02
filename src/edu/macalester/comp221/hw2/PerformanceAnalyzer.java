package edu.macalester.comp221.hw2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PerformanceAnalyzer {
    private static void executeAdd(int location) {

    }

    private static void executeDel(int location) {
        
    }

    private static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Available physical and virtual processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Memory available to the JVM: " + Runtime.getRuntime().freeMemory() + " bytes");

        
    }
}
