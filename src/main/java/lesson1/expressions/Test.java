package lesson1.expressions;

public class Test {

    public static void main(String[] args) {
        new Mul(new Sum(new Sum(new Argument(1), new Argument(5)), new Argument(2)),
                new Sum(new Argument(3), new Argument(4))).eval();
    }
}
