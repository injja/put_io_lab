package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import org.mockito.Mockito;
import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;

public class ExpenseRepositoryTest {

    @Test
    void loadExpenses() {
        IFancyDatabase db = mock(IFancyDatabase.class);
        when(db.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository repo=new ExpenseRepository(db);

        repo.loadExpenses();
        InOrder inOrder = inOrder(db);

        inOrder.verify(db).connect();
        inOrder.verify(db).queryAll();
        inOrder.verify(db).close();
        assertNotNull(repo.getExpenses());
        assertTrue(repo.getExpenses().isEmpty());
    }

    @Test
    void saveExpenses() {

        IFancyDatabase db = mock(IFancyDatabase.class);

        ExpenseRepository repo = new ExpenseRepository(db);
        repo.loadExpenses();
        for (int i = 0; i < 5; i++) {
            repo.addExpense(new Expense("","",0));
        }
        repo.saveExpenses();
        //verify(db).persist(e);
        // verify(db).persist(new Expense()); -ten test zwraca błąd
        //verify(db).persist(any(Expense.class));
        verify(db, times(5)).persist(any(Expense.class));
    }

}
