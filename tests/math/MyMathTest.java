package math;

import Tests.Math.MyMath;
import org.junit.jupiter.api.Test;

public class MyMathTest {
    MyMath math = new MyMath();

    @Test
    void test_sum() {
        assert math.sum(1, 1) == 2;
        assert math.sum(11, 22) == 33;
    }

}