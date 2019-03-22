package by.training.task03.composite;

import by.training.task03.interpreter.Client;
import by.training.task03.interpreter.ReversePolishNotation;

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

    public ComponentType getType() {
        return type;
    }

    public List<Component> getComponentList() {
        return componentList;
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
//    public List<Component> getChildren() {
//        return componentList;
//    }

    public int getSize() {
        return componentList.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Component component : componentList) {
//            if (type == ComponentType.EXPRESSION) {
//                ReversePolishNotation rpn = new ReversePolishNotation();
//                String expression = rpn.create(());
//                Client interpreter = new Client(expression);
//                result.append(interpreter.calculate());
//            }
            //   System.out.println(type + " : " + component);
            result.append(type.getDelimiter());
            result.append(component.toString());
        }
        return result.toString();
    }
}
