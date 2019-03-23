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

    @Override
    public CompositeText get(int index) {
        return (CompositeText) componentList.get(index);
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

    public List<Component> getChildren() {
        return componentList;
    }

    public int getSize() {
        return componentList.size();
    }

    //TODO change to better method
    //TODO change sentence to lexeme
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        if (type == ComponentType.EXPRESSION) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < componentList.size(); i++) {
                str.append(componentList.get(i));
            }
            ReversePolishNotation rpn = new ReversePolishNotation();
            String expression = rpn.create(str.toString());
            Client interpreter = new Client(expression);
            result.append(interpreter.calculate());
        } else {
            for (Component component : componentList) {
                switch (type) {
                    case TEXT:
                        result.append("\n\t");
                        break;
                    case SENTENCE:
                        result.append(" ");
                        break;
                }
                result.append(component.toString());
            }
        }
        return result.toString();
    }
}
