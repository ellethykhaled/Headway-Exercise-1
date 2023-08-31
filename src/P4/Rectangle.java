package P4;

public class Rectangle implements Comparable<Rectangle> {
    // A static char to hold the rectangle name
    static char rectangleLetter = 'A';

    private final int width;
    private final int height;
    private final String name;

    Rectangle(int width, int height) {
        // A single dimension cannot be less than 1
        if (width == 0)
            this.width = 1;
        else
            this.width = Math.abs(width);
        if (height == 0)
            this.height = 1;
        else
            this.height = Math.abs(height);

        name = "Rectangle " + rectangleLetter;
        rectangleLetter++;
    }

    public String getName() {
        return name;
    }

    public int calculateArea() {
        return width * height;
    }

    @Override
    public int compareTo(Rectangle rect) {
        Integer currentArea = calculateArea();
        Integer otherArea = rect.calculateArea();

        return currentArea.compareTo(otherArea);
    }
}
