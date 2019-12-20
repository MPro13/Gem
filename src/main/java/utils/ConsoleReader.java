package utils;

import menu.Main;

import java.util.Scanner;

public class ConsoleReader {
    private static Scanner scanner = new Scanner( System.in );

    public static int inputNaturalNumber() {
        while (true) {
            int n = scanner.nextInt();
            if (isNaturalNumber(n)) {
                return n;
            }
            System.out.println("Incorrect data! You entered not a natural number!");
            scanner.nextLine();
        }
    }

    public int[] inputArrayOfNaturalNumbers() {
        System.out.println("Input size of array:");
        int n = inputNaturalNumber();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Input arr[" + i + "]:");
            arr[i] = inputNaturalNumber();
        }
        return arr;
    }

    public int inputIntegerNumber() {
        while (true) {
            System.out.println("Input integer number:");
            if (scanner.hasNextInt()) {
                int n = scanner.nextInt();
                return n;
            }
            System.out.println("Incorrect data! You entered not a integer number!");
            scanner.nextLine();
        }
    }

    public double inputDoubleNumber() {
        while (true) {
            System.out.println("Input double number(use ','):");
            if (scanner.hasNextDouble()) {
                double d = scanner.nextDouble();
                return d;
            }
            System.out.println("Incorrect data! You entered not a double number!");
            scanner.nextLine();
        }
    }

    public static String inputLine() {
        String result = scanner.next();
        return result;
    }

    private static boolean isNaturalNumber(int n) {
        return n > 0;
    }

    public static int checkTransparency(int transparency) {
        int correctTransparency;
        if (transparency < 0 || transparency > 100) {
            Main.logger.warn( "Incorrect inputted transparency" );
            System.out.println( "Transparency should be from 0 to 100\nInput correct:" );
            correctTransparency = inputNaturalNumber();
            checkTransparency( correctTransparency );
        } else {
            correctTransparency = transparency;
        }
        return correctTransparency;
    }
}

