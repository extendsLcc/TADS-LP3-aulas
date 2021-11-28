package math;

import Tests.Math.MyMath;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyMathTest {

    MyMath math = new MyMath();

    @Test
    void testSumValid() {
        assert math.sum(1, 1) == 2;
        assert math.sum(11, 22) == 33;
    }

    @Test
    void testSumInvalid() {
        assert math.sum(1, 1) != 3;
        assert math.sum(11, 22) != 34;
    }

    @Test
    void testSumException() {
        assertThrows(ArithmeticException.class, () -> math.sum(Integer.MAX_VALUE, 1));
    }

    @Test
    void testSubValid() {
        assert math.sub(1, 1) == 0;
        assert math.sub(11, 22) == -11;
    }

    @Test
    void testSubInvalid() {
        assert math.sub(1, 1) != 2;
        assert math.sub(11, 22) != 33;
    }

    @Test
    void testSubException() {
        assertThrows(ArithmeticException.class, () -> math.sub(Integer.MIN_VALUE, 1));
    }

    @Test
    void testMultValid() {
        assert math.mult(0, 999) == 0;
        assert math.mult(1, 1) == 1;
        assert math.mult(2, 2) == 4;
        assert math.mult(-2, 5) == -10;
        assert math.mult(-2, -5) == 10;
    }

    @Test
    void testMultInvalid() {
        assert math.mult(0, 999) != 999;
        assert math.mult(1, 1) != 2;
        assert math.mult(2, 2) != 2;
        assert math.mult(-2, 5) != 10;
        assert math.mult(-2, -5) != -10;
    }

    void testMultException() {
        assertThrows(ArithmeticException.class, () -> math.mult(Integer.MAX_VALUE, 2));
    }

}