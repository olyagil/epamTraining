package by.training.task03.composite;

/**
 * The {@code Component} interface is used when needed to arrange a composite
 * pattern for ths use of {@code CompositeText} and {@code Leaf} class.
 */
public interface Component {
    /**
     * Default method for adding the component.
     *
     * @param component which need to be added
     */
    default void add(Component component) {
    }

    /**
     * Default method for adding many components at once.
     *
     * @param components which needed to be added
     */
    default void add(Component... components) {
    }

    /**
     * Default method for getting the child by id.
     * Throws the exception when called from the Leaf.
     *
     * @param index on which to get a child
     * @return the needed child
     */
    default Component getChild(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * Default method for removing the component.
     *
     * @param component which need to be deleted
     */
    default void remove(Component component) {
    }

    /**
     * Default method for getting the size of components list.
     * Throws the exception when called from the Leaf.
     *
     * @return size
     */
    default int getSize() {
        throw new UnsupportedOperationException();
    }

    /**
     * Default method for getting the type of the component.
     * Throws the exception when called from the Leaf.
     *
     * @return type
     */
    default ComponentType getType() {
        throw new UnsupportedOperationException();
    }

}
