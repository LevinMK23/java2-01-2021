package lesson1.expressions;

public interface Expression {

    int apply();
    default void eval() {}
    String toStr();

}
