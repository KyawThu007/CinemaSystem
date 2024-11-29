/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.Salary;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface SalaryInterface {

    public int addSalary(Salary salary);

    public void updateSalary(Salary salary);

    public void deleteSalary(int id);

    public List<Salary> getAllSalary(int cinema_id);
    
    public void logMessage(String log);
}
