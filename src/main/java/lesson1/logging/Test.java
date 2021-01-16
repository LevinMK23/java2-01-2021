package lesson1.logging;

import java.io.IOException;

public class Test {

    public static void calculate(int value, Logger log) throws IOException {
        value++;
        log.log("value after calculation = " + value);
    }

    public static void main(String[] args) throws IOException {
        calculate(1, new ConsoleLogger());
    }
}
