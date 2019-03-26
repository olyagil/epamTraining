package by.training.task03.composite;

import by.training.task03.interpreter.Client;
import by.training.task03.interpreter.ReversePolishNotation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeText implements Component {

    private ComponentType type;
    private List<Component> componentList;
    private static final Logger LOGGER = LogManager.getLogger();

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

    @Override
    public Component getChild(final int index) {
        return componentList.get(index);
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public int getSize() {
        return componentList.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CompositeText that = (CompositeText) o;
        if (getType() != that.getType()) {
            return false;
        }
        return componentList.equals(that.componentList);
    }

    @Override
    public int hashCode() {
        int result = getType().hashCode();
        result = 31 * result + componentList.hashCode();
        return result;
    }

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
        }
        for (Component component : componentList) {
            if (type != ComponentType.EXPRESSION) {
                switch (type) {
                    case TEXT:
                        result.append("\n\t");
                        break;
                    case SENTENCE:
                        result.append(" ");
                        break;
//                    default:
//                        LOGGER.warn("Doesn't have this type: " + type);
                }
                result.append(component.toString());
            }
        }
        return result.toString();
    }
}
