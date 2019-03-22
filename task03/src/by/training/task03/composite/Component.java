package by.training.task03.composite;

public interface Component {

    //todo: think about the getChildren default method

    default void add(Component component) {
    }

    default int getSize() {
        return -1;
    }

    default void add(Component... components) {
    }

    default void remove(Component component) {
    }
}
