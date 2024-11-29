/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.Expense;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface ExpenseInterface {

    public int addExpense(Expense expense);

    public void updateExpense(Expense expense);

    public void deleteExpense(int id);

    public List<Expense> getAllExpense(int cinema_id);
    
    public void logMessage(String log);

}
