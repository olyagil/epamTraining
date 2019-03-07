package by.training.task02.entity;

public class Container {

    private int containerId;

    public Container(int containerId) {
        this.containerId = containerId;
    }

    public int getContainerId() {
        return containerId;
    }

    @Override
    public String toString() {
        return "containerId=" + containerId;
    }
}
