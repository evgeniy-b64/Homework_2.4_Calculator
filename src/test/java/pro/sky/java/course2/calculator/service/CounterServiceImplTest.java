package pro.sky.java.course2.calculator.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CounterServiceImplTest {

    CalculatorService counterService = new CounterServiceImpl();

    @Test
    void plusPositiveNumber() {
        int actual = counterService.plus(3, 3);
        assertEquals(6, actual);
    }

    @Test
    void plusNegativeNumber() {
        int actual = counterService.plus(3, -3);
        assertEquals(0, actual);
    }

    @Test
    void minusPositiveNumber() {
        int actual = counterService.minus(6, 3);
        assertEquals(3, actual);
    }

    @Test
    void minusNegativeNumber() {
        int actual = counterService.minus(6, -3);
        assertEquals(9, actual);
    }

    @Test
    void multiplyByPositiveNumber() {
        int actual = counterService.multiply(3, 3);
        assertEquals(9, actual);
    }

    @Test
    void multiplyByNegativeNumber() {
        int actual = counterService.multiply(3, -3);
        assertEquals(-9, actual);
    }

    @Test
    void divideByPositiveNumber() {
        int actual = counterService.divide(9, 3);
        assertEquals(3, actual);
    }

    @Test
    void divideByNegativeNumber() {
        int actual = counterService.divide(9, -3);
        assertEquals(-3, actual);
    }

    @Test
    void divideByZero() {
        assertThrows(IllegalArgumentException.class, () -> counterService.divide(1, 0));
    }
}