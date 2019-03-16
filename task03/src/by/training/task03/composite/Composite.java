package by.training.task03.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Composite implements InterfaceComponent {

    List<InterfaceComponent> children;

    public Composite() {
        children = new ArrayList<>();
    }

    public void add(InterfaceComponent... components) {
        children.addAll(Arrays.asList(components));
    }

    public void remove(InterfaceComponent component) {
        children.remove(component);
    }

    InterfaceComponent getChildren(int index) {
        return children.get(index);
    }

    @Override
    public void gather() {
        for (InterfaceComponent component : children) {
            component.gather();
        }
    }
}