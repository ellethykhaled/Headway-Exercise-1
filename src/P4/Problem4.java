package P4;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem4 {
    static public void main(String[] args) {
        ArrayList<Integer> dimensions = readRectanglesDimensions();

        Rectangle rectA = new Rectangle(dimensions.get(0), dimensions.get(1));
        Rectangle rectB = new Rectangle(dimensions.get(2), dimensions.get(3));

        switch (rectA.compareTo(rectB)) {
            case 1:
                System.out.println(rectA.getName() + " is greater than " + rectB.getName());
                break;
            case 0:
                System.out.println(rectA.getName() + " is as big as " + rectB.getName());
                break;
            case -1:
                System.out.println(rectB.getName() + " is greater than " + rectA.getName());
                break;
            default:
                break;
        }
    }
    static public ArrayList<Integer> readRectanglesDimensions() {
        ArrayList<Integer> dimensions = new ArrayList<>();

        // Reading input from the user
        for (char i = 'A'; i < 'C'; i++) {
            System.out.print("Enter rectangle " + i + " dimensions to operate on: ");
            Scanner myScanner = new Scanner(System.in);

            int firstDimension;
            int secondDimension;

            try {
                // Setting the first rectangle dimensions
                firstDimension = myScanner.nextInt();
                secondDimension = myScanner.nextInt();
            } catch (Exception e) {
                // Setting the default dimensions for the first rectangle
                firstDimension = 5;
                secondDimension = 6;
                System.out.println("Rectangle initialized with dimensions " + firstDimension + ", " + secondDimension);
            }

            dimensions.add(firstDimension);
            dimensions.add(secondDimension);
        }

        return dimensions;
    }
}
