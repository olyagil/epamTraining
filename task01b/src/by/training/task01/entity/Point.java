package by.training.task01.entity;

/**
 * The Point class describes a point with two coordinates.
 */
public class Point {

    /**
     * The bit representative of the int for hashCode method.
     */
    public static final int BIG_INT_32 = 32;
    /**
     * Point X.
     */
    private double x;

    /**
     * Point Y.
     */
    private double y;

    /**
     * Contractor of the Point class.
     */
    public Point() {
    }

    /**
     * Constractor with parameters.
     *
     * @param xOfPoint of the point
     * @param yOfPoint of the point
     */
    public Point(final double xOfPoint, final double yOfPoint) {
        this.x = xOfPoint;
        this.y = yOfPoint;
    }

    /**
     * Method to get an X.
     *
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * Method to set an X.
     *
     * @param xOfPoint of the point
     */
    public void setX(final double xOfPoint) {
        this.x = xOfPoint;
    }

    /**
     * Method to get an Y.
     *
     * @return y
     */
    public double getY() {
        return y;
    }

    /**
     * Method to get an Y.
     *
     * @param yOfPoint of the point
     */
    public void setY(final double yOfPoint) {
        this.y = yOfPoint;
    }

    /**
     * Overriding method hashCode.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> BIG_INT_32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> BIG_INT_32));
        return result;
    }

    /**
     * Overriding method equals.
     *
     * @param obj
     * @return true, if equals
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Point other = (Point) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }

    /**
     * Method to get a point in the String type.
     *
     * @return string of points
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Point { ");
        string.append("x = " + x);
        string.append(", y = " + y + "}");
        return string.toString();
    }
}

