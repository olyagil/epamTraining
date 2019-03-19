package by.training.task03.interpreter;

import java.util.ArrayDeque;

class Context {

    private ArrayDeque<Integer> contextValues = new ArrayDeque<>();

    Integer popValue() {
        return contextValues.pop();
    }

    void pushValue(Integer value) {
        this.contextValues.push(value);
    }
}
