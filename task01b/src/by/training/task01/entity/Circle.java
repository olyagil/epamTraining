/**
 * The entity package describes a entities of the objects
 */
package by.training.task01.entity;

/**
 * The {@code Circle} class describes a circle which is set by the center and
 * the radius
 *
 * @author Gil Olga
 */
public class Circle {

    private Point center;
    private double radius;


    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((center == null) ? 0 : center.hashCode());
        long temp;
        temp = Double.doubleToLongBits(radius);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
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

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("Circle { ");
        string.append("center " + center);
        string.append(" radius " + radius + " }");
        return string.toString();
    }
}
