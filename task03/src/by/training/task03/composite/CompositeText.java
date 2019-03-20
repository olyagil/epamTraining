package by.training.task03.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeText implements Component {

    private ComponentType type;
    private List<Component> componentList;

    public CompositeText(final ComponentType type) {
        this.type = type;
        componentList = new ArrayList<>();
    }

    @Override
    public void add(Component component) {
        componentList.add(component);
    }

    @Override
    public void add(final Component... components) {
        componentList.addAll(Arrays.asList(components));
    }

    @Override
    public void remove(final Component component) {
        componentList.remove(component);
    }

    public Component getChildren(final int index) {
        return componentList.get(index);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Component component : componentList) {
            result.append(type.getDelimiter());
            result.append(component.toString());
        }
        return result.toString();
    }
}
