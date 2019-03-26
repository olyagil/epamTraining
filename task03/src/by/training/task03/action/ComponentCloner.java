package by.training.task03.action;

import by.training.task03.composite.Component;
import by.training.task03.composite.ComponentType;
import by.training.task03.composite.CompositeText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@code ComponentCloner} od used for cloning the component text.
 */
public class ComponentCloner {
    /**
     * The constant for logging.
     */
    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Method is used for cloning the given text.
     *
     * @param component given text
     * @return new cloned text
     */
    public Component clone(final Component component) {
        LOGGER.info("Cloning the component " + component);
        Component newComponent = new CompositeText(ComponentType.TEXT);

        List<Component> components = new ArrayList<>();
        for (int i = 0; i < component.getSize(); i++) {
            components.add(component.getChild(i));
        }

        for (Component composite : components) {
            newComponent.add(composite);
        }
        return newComponent;
    }
}
