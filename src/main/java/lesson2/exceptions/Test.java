package lesson2.exceptions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class Test {

    static void foo1() {
        // foo1();
    }

    static void foo2() {
        try {
            int x = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void foo3() {
        try (OutputStream os = new FileOutputStream("calc.log")) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        foo1();
//        System.out.println("1");
//        // NPE (1!!! NullPointerException),
//        // IOOB IndexOutOfBounds
//        // AE
//        try {
//            throw new Exception();
//        } catch (Exception e) {
//            System.err.println("Was exception");
//        }
        // IOException
        // OOM OutOfMemory
        // SOF StackOverFlow
        TwoArgsSummer summer = new TwoArgsSummer();
        System.out.println(summer.processString("111111111 2"));

        try {
            MyReader reader = new MyReader();
            System.out.println(reader.readInt());
            reader.close();
            MyWriter writer = new MyWriter();
            writer.writeInt(66);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
