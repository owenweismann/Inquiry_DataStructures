package Inquiry.ArithmaticExpressionEvaluator;

import org.junit.jupiter.api.Test;

import java.beans.Expression;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionEvaluatorTest {

    @Test
    void evaluate_complex() {
        int result = ExpressionEvaluator.evaluate("3+4-2*8/2^2");
        assertEquals(3,result);
    }
    @Test
    void evaluate_singDigit() {
        int result = ExpressionEvaluator.evaluate("3");
        assertEquals(3,result);
    }
    @Test
    void evaluate_addition() {
        int result = ExpressionEvaluator.evaluate("3+4");
        assertEquals(7,result);
    }
    @Test
    void evaluate_subtraction() {
        int result = ExpressionEvaluator.evaluate("4-2");
        assertEquals(2,result);
    }
    @Test
    void evaluate_exponents() {
        int result = ExpressionEvaluator.evaluate("3^2");
        assertEquals(9,result);
    }
    @Test
    void evaluate_multiplication() {
        int result = ExpressionEvaluator.evaluate("2*4");
        assertEquals(8,result);
    }
    @Test
    void evaluate_division() {
        int result = ExpressionEvaluator.evaluate("8/2");
        assertEquals(4,result);
    }
    @Test
    void evaluate_biggerNums() {
        int result = ExpressionEvaluator.evaluate("8/2*8+3");
        assertEquals(35,result);
    }
}