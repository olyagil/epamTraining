package by.training.task03.interpreter;

import java.util.function.BinaryOperator;

@FunctionalInterface
//interface Expression extends BinaryOperator {
interface Expression {

    void interpret(Context context);
}
