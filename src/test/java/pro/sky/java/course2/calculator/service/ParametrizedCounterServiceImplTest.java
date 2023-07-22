package pro.sky.java.course2.calculator.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizedCounterServiceImplTest {
    CalculatorService counterService = new CounterServiceImpl();

    static Stream<Arguments> AdditionTestData() {
        return Stream.of(
                Arguments.of(3, 3, 6),
                Arguments.of(3, -3, 0),
                Arguments.of(-3, 3, 0),
                Arguments.of(-3, -3, -6)
        );
    }

    @ParameterizedTest
    @MethodSource("AdditionTestData")
    void paramAdditionTest(int n1, int n2, int expected) {
        assertEquals(expected, counterService.plus(n1, n2));
    }

    static Stream<Arguments> SubstractionTestData() {
        return Stream.of(
                Arguments.of(3, 3, 0),
                Arguments.of(3, -3, 6),
                Arguments.of(-3, 3, -6),
                Arguments.of(-3, -3, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("SubstractionTestData")
    void paramSubstractionTest(int n1, int n2, int expected) {
        assertEquals(expected, counterService.minus(n1, n2));
    }

    static Stream<Arguments> MultiplicationTestData() {
        return Stream.of(
                Arguments.of(3, 3, 9),
                Arguments.of(3, -3, -9),
                Arguments.of(3, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("MultiplicationTestData")
    void paramMultiplicationTest(int n1, int n2, int expected) {
        assertEquals(expected, counterService.multiply(n1, n2));
    }

    static Stream<Arguments> DivisionTestData() {
        return Stream.of(
                Arguments.of(9, 3, 3),
                Arguments.of(9, -3, -3)
        );
    }

    @ParameterizedTest
    @MethodSource("DivisionTestData")
    void paramDivisionTest(int n1, int n2, int expected) {
        assertEquals(expected, counterService.divide(n1, n2));
    }
}
