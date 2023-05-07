package pro.sky.java.course2.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.calculator.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalcController {

    private final CalculatorService calculatorService;

    public CalcController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/about")
    public String Home() {
        return "Первый проект на Spring + Maven. <a href=\"http://localhost:8080/calculator\">Калькулятор 1.0</a>";
    }

    @GetMapping
    public String sayHello() {
        return "Добро пожаловать в калькулятор! " +
                "<br>У нас есть: " +
                "<br> <a href=\"http://localhost:8080/calculator/plus?num1=5&num2=5\">Сложение</a>" +
                "<br> <a href=\"http://localhost:8080/calculator/minus?num1=5&num2=5\">Вычитание</a>" +
                "<br> <a href=\"http://localhost:8080/calculator/multiply?num1=5&num2=5\">Умножение</a>" +
                "<br> <a href=\"http://localhost:8080/calculator/divide?num1=5&num2=5\">Деление</a>" +
                "<br> <br> <a href=\"http://localhost:8080/calculator/about\">О проекте</a>";

    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        int result = calculatorService.plus(a, b);
        return String.format("%s + %s = %s <br> <a href=\"http://localhost:8080/calculator\">Назад</a>", a, b, result);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        int result = calculatorService.minus(a, b);
        return String.format("%s - %s = %s <br> <a href=\"http://localhost:8080/calculator\">Назад</a>", a, b, result);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        int result = calculatorService.multiply(a, b);
        return String.format("%s * %s = %s <br> <a href=\"http://localhost:8080/calculator\">Назад</a>", a, b, result);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") int a, @RequestParam("num2") int b) {
        if (b == 0)
            return "<img src=\"https://www.meme-arsenal.com/memes/37ad910746046a525647e382204b0e7b.jpg\" alt=\"Нельзя просто так взять и поделить на ноль\">" +
                    "<br> <a href=\"http://localhost:8080/calculator\">Назад</a>";
        int result = calculatorService.divide(a, b);
        return String.format("%s / %s = %s <br> <a href=\"http://localhost:8080/calculator\">Назад</a>", a, b, result);
    }

    @GetMapping(path = "/404")
    public String pageNotFound() {
        return "Еггог ЧОЧ <br> Как вы здесь оказались? <br> <a href=\"http://localhost:8080/calculator\">Добро пожаловать</a> отсюда!";
    }
}
