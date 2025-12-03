package put.io.testing.audiobooks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//pytanie 5.1 - to typ testowania white-box
//pytanie 5.2 - są 4 ścieżki
class AudiobookPriceCalculatorTest {
    private Customer customer;
    private AudiobookPriceCalculator calculator;
    private Audiobook audiobook;
    @Test
    public void testPriceSubscriber(){
        customer=new Customer("Adam Kowalski", null,true);
        calculator=new AudiobookPriceCalculator();
        audiobook=new Audiobook("Dziady", 45.00);
        double result=calculator.calculate(customer, audiobook);
        assertEquals(0.0, result);
    }

    @Test
    public void testPriceSilver(){
        customer=new Customer("Adam Kowalski", Customer.LoyaltyLevel.SILVER,false);
        calculator=new AudiobookPriceCalculator();
        audiobook=new Audiobook("Dziady", 45.00);
        double result=calculator.calculate(customer, audiobook);
        assertEquals(40.50, result);
    }

    @Test
    public void testPriceGolden(){
        customer=new Customer("Adam Kowalski", Customer.LoyaltyLevel.GOLD,false);
        calculator=new AudiobookPriceCalculator();
        audiobook=new Audiobook("Dziady", 45.00);
        double result=calculator.calculate(customer, audiobook);
        assertEquals(36.00, result);
    }

    @Test
    public void testPriceNormal(){
        customer=new Customer("Adam Kowalski", null,false);
        calculator=new AudiobookPriceCalculator();
        audiobook=new Audiobook("Dziady", 45.00);
        double result=calculator.calculate(customer, audiobook);
        assertEquals(45.00, result);
    }

}