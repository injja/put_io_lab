package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FailureOrErrorTest {
    //Pytanie 4.1 - ten test daje assertion failure
//    @Test
//    public void test2(){
//        Calculator calculator = new Calculator();
//        int result = calculator.add(-9, 1);
//        assertEquals(10, result);
//    }
//// a ten error
//    @Test
//    public void test1(){
//        int result = 10/0;
//    }
// Pytanie 4.2: org.opentest4j.AssertionFailedError
    @Test
    public void test3() {
    try {
        assertEquals(10, 34);
    } catch (Throwable e) {
        System.out.println("obiekt klasy: " + e.getClass().getName());
        Arrays.stream(e.getStackTrace()).forEach(System.out::println);
    }
}


}
