import java.util.Scanner;

public class Problem2 {
    static public void main(String[] args) {

        // Reading input from the user
        System.out.print("Enter number to operate on: ");
        Scanner myScanner = new Scanner(System.in);

        int number;

        try {
            // Setting the number to operate on
            number = myScanner.nextInt();
        } catch (Exception e) {
            // Setting the default value for the number to operate on
            System.out.println("Running program with default number 10");
            number = 10;
        }

        // Function base call
        recursiveSequence(number, 1, true);
    }

    static void recursiveSequence(int n, int currentNumber, boolean incrementing) {
        // Printing the current sequence
        System.out.println(n * currentNumber);

        if (incrementing) {
            // The condition for changing from incrementing to decrementing
            if (currentNumber == 10)
                recursiveSequence(n, currentNumber, false);
            else
                recursiveSequence(n, currentNumber + 1, true);
        }
        else {
            if (currentNumber != 1)
                recursiveSequence(n, currentNumber -1, false);
        }
    }
}
