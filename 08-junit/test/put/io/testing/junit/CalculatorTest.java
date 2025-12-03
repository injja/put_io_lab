package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//zad 1- testy wykryły błędy dla multiply- dzieje sie tak, dlatego że metoda multiply jest błędnie napisana- oddaje wynik x - y zamiast x * y
//zad 2- testy rzucuły błąd java.lang.IllegalArgumentException: The arguments must be positive
class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void testAdd1(){
        int result = calculator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testAdd2(){
        int result = calculator.add(-9, 1);
        assertEquals(-8, result);
    }

    @Test
    public void testMultiply1(){
        int result = calculator.multiply(9, 8);
        assertEquals(72, result);
    }

    @Test
    public void testMultiply2(){
        int result = calculator.multiply(-9, 3);
        assertEquals(-27, result);
    }

    @Test
    public void testAddPositiveNumbers1(){
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculator.addPositiveNumbers(-9, 0)
        );
        assertEquals("The arguments must be positive", exception.getMessage());
    }

    @Test
    public void testAddPositiveNumbers2(){
        int result=calculator.addPositiveNumbers(9, 1);
        assertEquals(10, result);
    }




}