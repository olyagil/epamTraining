package by.training.task01.entity;

/**
 * The {@code CircleParameters} class is the recorder class.
 */
public class CircleParameters {
    /**
     * The area of the circle.
     */
    private double area;

    /**
     * The perimeter of the circle.
     */
    private double perimeter;

    /**
     * The constructor with parameters.
     *
     * @param areaOfCircle      of the circle
     * @param perimeterOfCircle of the circle
     */
    public CircleParameters(final double areaOfCircle,
                            final double perimeterOfCircle) {
        this.area = areaOfCircle;
        this.perimeter = perimeterOfCircle;
    }

    /**
     * Getter for area.
     *
     * @return area of the circle
     */
    public double getArea() {
        return area;
    }

    /**
     * Getter for perimeter.
     *
     * @return perimeter of the circle
     */
    public double getPerimeter() {
        return perimeter;
    }

    /**
     * String representation.
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("\nParameters { ");
        string.append("area: " + area);
        string.append(" perimeter = " + perimeter + " }");
        return string.toString();
    }
}
