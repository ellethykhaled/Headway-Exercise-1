package P4;

import java.util.Scanner;

public class Problem4 {
    static public void main(String[] args) {
        Rectangle rectA = readRectangleDimensions();
        Rectangle rectB = readRectangleDimensions();

        compareRectangles(rectA, rectB);
    }

    private static void compareRectangles(Rectangle rectA, Rectangle rectB) {
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

    static public Rectangle readRectangleDimensions() {
        // Reading input from the user
        System.out.print("Enter rectangle " + Rectangle.rectangleLetter + " dimensions to operate on: ");
        Scanner myScanner = new Scanner(System.in);

        int firstDimension, secondDimension;

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

        return new Rectangle(firstDimension, secondDimension);
    }
}
