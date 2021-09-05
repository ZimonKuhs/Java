package codility.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codility.Problem1;
import codility.Problem2;
import codility.Problem3;

public class TestCodility {

    @Test
    public void testProblem1() {
        assertEquals(-1, new Problem1().solve());
    }

    @Test
    public void testProblem2() {
        assertEquals(-2, new Problem2().solve());
    }

    @Test
    public void testProblem3() {
        assertEquals(-3, new Problem3().solve());
    }
}
