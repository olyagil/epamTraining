package by.training.task03.composite;

public interface Component {

    default void add(Component component) {
    }

    default void add(Component... components) {
    }

    default Component getChild(int index) {
        throw new UnsupportedOperationException();
    }

    default void remove(Component component) {
    }

    default int getSize() {
        throw new UnsupportedOperationException();
    }

    default ComponentType getType() {
        throw new UnsupportedOperationException();
    }

}
