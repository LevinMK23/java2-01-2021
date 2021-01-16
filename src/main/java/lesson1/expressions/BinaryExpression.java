package lesson1.expressions;

public abstract class BinaryExpression implements Expression {

    private final Expression left, right;

    public BinaryExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public void eval() {
        System.out.println(toStr() + " = " + apply());
    }

}
