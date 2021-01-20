package lesson2.exceptions;

import org.junit.Assert;
import org.junit.Test;

public class CalcTest {

    @Test(expected = ArraySizeException.class)
    public void testTrowArraySizeException() {
        Calc calc = new Calc();
        calc.sum(new String[][]{});
    }

    @Test(expected = ArraySizeException.class)
    public void testTrowArraySizeException1() {
        Calc calc = new Calc();
        calc.sum(new String[][]{{"1", "2", "3", "4"}, {"1"}, {"1"}, {"1"}});
    }

    @Test(expected = ArrayDataException.class)
    public void testTrowArrayDataException1() {
        Calc calc = new Calc();
        long sum = calc.sum(new String[][]{{"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2asfas", "3", "4"},
                {"1", "2", "3", "4"}});
    }

    @Test
    public void testCalcSum() {
        Calc calc = new Calc();
        long sum = calc.sum(new String[][]{{"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}});
        Assert.assertEquals(40, sum);
    }
}