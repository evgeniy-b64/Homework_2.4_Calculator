package pro.sky.java.course2.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CounterServiceImpl implements CalculatorService {

    @Override
    public int plus(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public int divide(int a, int b) {
        if (b != 0) return a / b;
        else throw new IllegalArgumentException("Нельзя просто так взять и поделить на ноль <br> <a href=\"http://localhost:8080/calculator\">Назад</a>");

    }
}
