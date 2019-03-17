package by.training.task03.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeText implements Component {

    private ComponentType type;
    private List<Component> children;

    public CompositeText(final ComponentType type) {
        this.type = type;
        children = new ArrayList<>();
    }

    public void add(Component component) {
        children.add(component);
    }

    public void add(final Component... components) {
        children.addAll(Arrays.asList(components));
    }

    public void remove(final Component component) {
        children.remove(component);
    }

    public Component getChildren(final int index) {
        return children.get(index);
    }


    @Override
    public void gather(final String path) {
        for (Component component : children) {
            component.gather(path);
        }
    }

    @Override
    public String toString() {
        return "CompositeText{" + "children=" + children.size()
                + ", type=" + type + '}';
    }
}
