package by.training.task03.composite;

import by.training.task03.interpreter.Interpreter;
import by.training.task03.interpreter.ReversePolishNotation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The {@code CompositeText} class is used for gathering and storing the
 * components of the text.
 */
public class CompositeText implements Component {
    /**
     * The constant for calculating the hashCode.
     */
    private static final int PRIME_NUMBER = 31;
    /**
     * The constant for logging.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * The type of the object.
     */
    private ComponentType type;
    /**
     * The list of components.
     */
    private List<Component> componentList;

    /**
     * The constructor of the class.
     *
     * @param typeOfComponent given type of the object
     */
    public CompositeText(final ComponentType typeOfComponent) {
        this.type = typeOfComponent;
        componentList = new ArrayList<>();
    }

    /**
     * Overriding the method add for adding the component to the list of
     * components.
     *
     * @param component which need to be added
     */
    @Override
    public void add(final Component component) {
        componentList.add(component);
    }

    /**
     * Overriding the method add for adding many components to the list of
     * components.
     *
     * @param components which needed to be added
     */
    @Override
    public void add(final Component... components) {
        componentList.addAll(Arrays.asList(components));
    }

    /**
     * Overriding the method remove for removing the component from the list of
     * components.
     *
     * @param component which need to be deleted
     */
    @Override
    public void remove(final Component component) {
        componentList.remove(component);
    }

    /**
     * Overriding the method getChild for getting the child of the components
     * by the id.
     *
     * @param index on which to get a child
     * @return needed component
     */
    @Override
    public Component getChild(final int index) {
        return componentList.get(index);
    }

    /**
     * Overriding the method getType for getting the type of the component.
     *
     * @return the type of the object
     */
    @Override
    public ComponentType getType() {
        return type;
    }

    /**
     * Overriding the method getSize for getting the size of the list of
     * components.
     *
     * @return size
     */
    @Override
    public int getSize() {
        return componentList.size();
    }

    /**
     * Overriding the method equals for comparison the components.
     *
     * @param o object
     * @return true if equals
     */
    @Override
    public boolean equals(final Object o) {
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

    /**
     * Overriding the method hashCode for getting the hashcode.
     *
     * @return hashCode
     */
    @Override
    public int hashCode() {
        int result = getType().hashCode();
        result = PRIME_NUMBER * result + componentList.hashCode();
        return result;
    }

    /**
     * Overriding the method toString for gathering the data back.
     *
     * @return initial text
     */
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
            Interpreter interpreter = new Interpreter(expression);
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
                    case LEXEME:
                    case PARAGRAPH:
                    case WORD:
                    case SYMBOL:
                    case PUNCTUATION_MARK:
                        break;
                    default:
                        LOGGER.warn("The wrong type of object.");
                }
                result.append(component.toString());
            }
        }
        return result.toString();
    }
}
