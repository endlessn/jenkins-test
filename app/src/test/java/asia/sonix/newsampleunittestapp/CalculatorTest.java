package asia.sonix.newsampleunittestapp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by steshima on 2016/11/04.
 */
public class CalculatorTest {

    private Calculator calculator;
    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void testSum() throws Exception {
        //期待結果：１＋５で６が返ってくる
        assertEquals(6, calculator.sum(1,5), 0);
    }

    @Test
    public void testSubstract() throws Exception {
        assertEquals(2, calculator.substract(5, 3), 0);
    }
}