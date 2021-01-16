package lesson1.pack;

public class A {

    private static int counter = 0;
    private final int x;
    private int a, b, c;

    public A(int x) {
        this.x = x;
        counter++;
    }

    public void foo(int a, int b) {
        System.out.println(a + b);
    }

    public void foo(int a) {
        System.out.println(a * 2);
    }

    public void foo(int a, int b, int c) {
        System.out.println(a * b * c);
    }

    // fooiii
    // fooii
    // fooi

    public static int getCounter() {
        return counter;
    }

    protected void setX(int x) {
        // this.x = x;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
