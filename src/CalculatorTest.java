import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAddPositive() {
        Operation response = new Operation('+', 10, 20);
        assertEquals(30, response.getAnswer(), 0.0001);
    }

    @Test
    public void testAddNegative() {
        Operation response = new Operation('+', 10, -20);
        assertEquals(-10, response.getAnswer(), 0.0001);
    }

    @Test
    public void testFloatAddPositive() {
        Operation response = new Operation('+', 0.1, 0.2);
        assertEquals(0.3, response.getAnswer(), 0.0001);
    }

    @Test
    public void testSubPositive() {
        Operation response = new Operation('-', 10, 20);
        assertEquals(-10, response.getAnswer(), 0.0001);
    }

    @Test
    public void testSubNegative() {
        Operation response = new Operation('-', -10, -20);
        assertEquals(10, response.getAnswer(), 0.0001);
    }

    @Test
    public void testFloatSubNegative() {
        Operation response = new Operation('-', -0.1, 0.2);
        assertEquals(-0.3, response.getAnswer(), 0.0001);
    }

    @Test
    public void testMultiPositive() {
        Operation response = new Operation('*', 10, 20);
        assertEquals(200, response.getAnswer(), 0.0001);
    }

    @Test
    public void testMultiNegative() {
        Operation response = new Operation('*', -10, 20);
        assertEquals(-200, response.getAnswer(), 0.0001);
    }

    @Test
    public void testMultiZero() {
        Operation response = new Operation('*', 100, 0);
        assertEquals(0, response.getAnswer(), 0.0001);
    }

    @Test
    public void testFloatMultiNegative() {
        Operation response = new Operation('*', -0.1, 0.2);
        assertEquals(-0.02, response.getAnswer(), 0.0001);
    }

    @Test
    public void testDividePositive() {
        Operation response = new Operation('/', 10, 20);
        assertEquals(0.5, response.getAnswer(), 0.0001);
    }

    @Test
    public void testDivideNegative() {
        Operation response = new Operation('/', -100, 10);
        assertEquals(-10, response.getAnswer(), 0.0001);
    }

    @Test
    public void testFloatDividePositive() {
        Operation response = new Operation('/', 0.2, 0.1);
        assertEquals(2, response.getAnswer(), 0.0001);
    }

    @Test
    public void DivideByZero() {
        Operation response = new Operation('/', -100, 0);
        assertEquals("Failure", "Error: Divide by zero", response.getErrorMessage());
    }

    @Test
    public void ErrorOperator() {
        Operation response = new Operation('t', 100, 10);
        assertEquals("Failure", "Error: Invalid Operator", response.getErrorMessage());
    }
}
