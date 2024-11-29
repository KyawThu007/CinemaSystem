/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.Employee;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface EmployeeInterface {

    public int addEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void deleteEmployee(int id);

    public List<Employee> getAllEmployee(int cinema_id);

    public Employee getEmployee(int id);

    public void logMessage(String log);
}
