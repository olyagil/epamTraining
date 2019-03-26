package by.training.task03.interpreter;

@FunctionalInterface
interface Expression {

    void interpret(Context context);
}
