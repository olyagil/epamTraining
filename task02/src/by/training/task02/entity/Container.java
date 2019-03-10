package by.training.task02.entity;

/**
 * The {@code Container} class is used for initialization the container.
 *
 * @author Gil Olga
 */
public class Container {

    /**
     * Identification number for container.
     */
    private int containerId;

    /**
     * The constructor for initialization the container.
     *
     * @param id identification number for container
     */
    Container(final int id) {
        this.containerId = id;
    }

    /**
     * Overriding method equals for comparison.
     *
     * @param o object
     * @return true if equals
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Container container = (Container) o;

        return containerId == container.containerId;
    }

    /**
     * Overriding method to count hashCode.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return containerId;
    }

    /**
     * Overriding method toString.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "containerId=" + containerId;
    }
}
