package by.training.task03.interpreter;

public class Runner {
    public static void main(String[] args) {
        ReversePolishNotation rpn = new ReversePolishNotation();
        String string = "(111^5|1&2<<(2|5>>2&71))|1200";
        String expression = rpn.create(string);
        System.out.println(expression);
        Client interpreter = new Client(expression);
        System.out.println("[ " + expression + " ] = " + interpreter
                .calculate());
    }
}
