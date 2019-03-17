package by.training.task03.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeText implements Component {

    ComponentType type;
    List<Component> children;

    public CompositeText() {
        children = new ArrayList<>();
    }

    public CompositeText(ComponentType type) {
        this.type = type;
        children = new ArrayList<>();
    }

    public void add(Component component) {
        children.add(component);
    }

    public void add(Component... components) {
        children.addAll(Arrays.asList(components));
    }

    public void remove(Component component) {
        children.remove(component);
    }

    public Component getChildren(int index) {
        return children.get(index);
    }


    @Override
    public void gather() {
        System.out.println(children);
        for (Component component : children) {
            System.out.println(component);
            component.gather();
        }

    }

    @Override
    public String toString() {
        return "CompositeText{" +
                "children=" + children.size() +
                ", type=" + type +
                '}';
    }
}