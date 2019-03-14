package by.training.task03.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    //    Component component;
    List<Component> children;

    public Composite() {
        children = new ArrayList<>();
    }

    @Override
    public void execute() {

    }

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

//    Component getChildren() {
//        return;
//    }


}
