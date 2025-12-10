package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import put.io.students.fancylibrary.database.IFancyDatabase;
import put.io.students.fancylibrary.service.FancyService;

public class ExpenseManagerTest {

    @Test
    void calculateTotal() {
        List<Expense> expenses = List.of(
                new Expense("1","wydatek",5),
                new Expense( "2","wydatek",9),
                new Expense( "3","wydatek",2)
        );
        ExpenseRepository repo = mock(ExpenseRepository.class);
        repo.loadExpenses();
        when(repo.getExpenses()).thenReturn(expenses);

        FancyService service = mock(FancyService.class);
        ExpenseManager manager = new ExpenseManager(repo, service);
        double total = manager.calculateTotal();
        assertEquals(16, total);

    }

    @Test
    void calculateTotalForCategory(){
        ExpenseRepository repo = mock(ExpenseRepository.class);

        when(repo.getExpensesByCategory(anyString()))
                .thenReturn(List.of());
        when(repo.getExpensesByCategory("Home"))
                .thenReturn(List.of(
                        new Expense("1","Home",5),
                        new Expense("2","Home",9)
                ));

        when(repo.getExpensesByCategory("Car"))
                .thenReturn(List.of(
                        new Expense("3","Car",2),
                        new Expense("4","Car",8)
                ));

//        when(repo.getExpensesByCategory(anyString()))
//                .thenReturn(List.of());
//        5.1 Ma znaczenie, w tym wypadku dopasowanie do dowolnego ciągu naków nadpisało poprzednie

        FancyService service = mock(FancyService.class);

        ExpenseManager manager = new ExpenseManager(repo, service);

        long totalHome = manager.calculateTotalForCategory("Home");
        long totalCar = manager.calculateTotalForCategory("Car");
        long totalOther = manager.calculateTotalForCategory("Food");

        assertEquals(14, totalHome);
        assertEquals(10, totalCar);
        assertEquals(0, totalOther);
    }
    @Test
    void calculateTotalInDollars() throws ConnectException {
        List<Expense> expenses = List.of(
                new Expense("1","wydatek",5),
                new Expense( "2","wydatek",9),
                new Expense( "3","wydatek",2)
        );
        ExpenseRepository repo = mock(ExpenseRepository.class);
        when(repo.getExpenses()).thenReturn(expenses);
        FancyService service = mock(FancyService.class);
        when(service.convert(anyDouble(), eq("PLN"), eq("USD")))
                .thenAnswer(inv -> {
                    double amountPLN = inv.getArgument(0);
                    return amountPLN / 4.0;
                });
//        when(service.convert(anyDouble(), eq("PLN"), eq("USD")))
//                .thenThrow(new ConnectException());

        ExpenseManager manager = new ExpenseManager(repo, service);

        long totalDollars= manager.calculateTotalInDollars();

        assertEquals(4, totalDollars);
        //assertEquals(-1, totalDollars); dla wyjątku zwraca -1
    }


}
