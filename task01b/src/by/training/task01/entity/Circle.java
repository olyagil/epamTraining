package by.training.task01.generator.training.task01.entity;

/**
 * The {@code Circle} class describes a circle which is set by the center and
 * the radius.
 *
 * @author Gil Olga
 */
public class Circle {

    /**
     * The bit representative of the int for hashCode method.
     */
    public static final int BIT_INT_32 = 32;
    /**
     * Center of the circle.
     */
    private Point center;
    /**
     * Radius of the circle.
     */
    private double radius;

    /**
     * Identification number of the circle.
     */
    private long circleId;

    /**
     * Constructor of the class Circle.
     *
     * @param centerOfCircle of the Circle
     * @param radiusOfCircle of the Circle
     */
    public Circle(final Point centerOfCircle, final double radiusOfCircle) {
        this.center = centerOfCircle;
        this.radius = radiusOfCircle;
    }

    /**
     * Get the center of the radius.
     *
     * @return center of the radius
     */
    public Point getCenter() {
        return center;
    }

    /**
     * The method to set a center of the circle.
     *
     * @param centerOfCircle of the circle
     */
    public void setCenter(final Point centerOfCircle) {
        if (centerOfCircle != null) {
            this.center = centerOfCircle;
        }
    }

    /**
     * The method to get the radius of the circle.
     *
     * @return of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * The method to set a radius of the circle.
     *
     * @param radiusOfCircle of the circle
     */
    public void setRadius(final double radiusOfCircle) {
        this.radius = radiusOfCircle;
    }

    /**
     * Get the circle identification number.
     *
     * @return circleId
     */
    public long getCircleId() {
        return circleId;
    }

    /**
     * Set an identification number.
     *
     * @param circleIdOfCircle of the circle
     */
    public void setCircleId(final long circleIdOfCircle) {
        this.circleId = circleIdOfCircle;
    }

    /**
     * Overriding a hashCode method.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((center == null) ? 0 : center.hashCode());
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = prime * result + (int) (temp ^ (temp >>> BIT_INT_32));
        return result;
    }

    /**
     * Overriding the equals method.
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
        Circle other = (Circle) obj;
        if (center == null) {
            if (other.center != null) {
                return false;
            }
        } else if (!center.equals(other.center)) {
            return false;
        }
        if (radius != other.radius) {
            return false;
        }
        return true;
    }

    /**
     * To get a circle in the string type.
     *
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("\nCircle { ");
        string.append("center: " + center);
        string.append(" radius = " + radius + " }");
        return string.toString();
    }
}
