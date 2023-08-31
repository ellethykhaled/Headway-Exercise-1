package P3;

import java.util.Scanner;

public class Problem3 {
    static public void main(String[] args) {

        // Reading input from the user
        System.out.print("Enter number to operate on: ");
        Scanner myScanner = new Scanner(System.in);

        int startingUnits;

        try {
            // Setting the number to operate on
            startingUnits = myScanner.nextInt();
            if (startingUnits < 0) {
                System.out.println("Cannot enter a number less than 0");
                startingUnits = 0;
            }
        } catch (Exception e) {
            // Setting the default value for the number to operate on
            System.out.println("Running program with default number 250");
            startingUnits = 250;
        }

        recursiveProcessing(startingUnits);
    }

    static int recursiveProcessing(int units) {
        if (units >= 100) {
            if (units % 5 == 0) {
                System.out.println(units + " is divisible by 5, returning 42 units");
                return recursiveProcessing(units - 42);
            } else if (units % 2 == 0) {
                System.out.println(units + " is even, returning half the units");
                return recursiveProcessing(units / 2);
            }
            else {
                System.out.println(units + " units remaining");
                return 0;
            }
        }
        else if (units % 4 == 0) {
            // Calculating the digits of the remaining number
            int firstDigit = units / 10;
            int secondDigit = units % 10;

            int unitsToReturn = firstDigit * secondDigit;
            if (unitsToReturn == 0) {
                System.out.println(units + " units remaining");
                return 0;
            }

            System.out.println(units + " is divisible by 4, returning " + unitsToReturn);
            return recursiveProcessing(units - unitsToReturn);
        }
        else {
            System.out.println(units + " units remaining");
            return 0;
        }
    }
}
