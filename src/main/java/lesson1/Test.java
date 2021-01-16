package lesson1;

import lesson1.pack.A;

public class Test {
    public static void main(String[] args) {
        A a = new A(12);
        a.foo(2);
        a.foo(1,2);
        a.foo(2, 3, 4);
        A a1 = new A(12);
        B b = new B(145);
        b.setX(123);
        System.out.println(A.getCounter());
        new Cat().say();
        new Dog().say();
        Object oA = new A(12);
        Object oB = new B(12);
        A a5 = new B(123);
        // lesson1.B b2 = new A(123);
        Object oC = new Cat();
        if (oA instanceof Cat) {
            Cat cat = (Cat) oA;
        }
        A a2 = (A) oB;
        if (oA instanceof B) {
            B b1 = (B) oA;
        }
    }
}
