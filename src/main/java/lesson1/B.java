package lesson1;

import lesson1.pack.A;

public class B extends A {

    public B(int x) {
        super(x);
        int b = 1;
    }

    @Override
    protected void setX(int x) {
        super.setX(x);
    }
}
