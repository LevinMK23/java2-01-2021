package lesson1.expressions;

public class Sum extends BinaryExpression {

    public Sum(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int apply() {
        return getLeft().apply() + getRight().apply();
    }

    @Override
    public String toStr() {
        return String.format("(%s + %s)", getLeft().toStr(), getRight().toStr());
    }
}
