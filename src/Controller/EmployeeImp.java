/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Interface.EmployeeInterface;
import Model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class EmployeeImp implements EmployeeInterface {

    static Connection con = null;

    @Override
    public int addEmployee(Employee employee) {
        int n = 0;
        try {
            con = new DatabaseConnection().getConnection();
            String query = "insert into employee(cinema_id,name,password,role_id,nrc,address,phone,salary,note) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, employee.getCinema_id());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getPassword());
            ps.setInt(4, employee.getRole_id());
            ps.setString(5, employee.getNrc());
            ps.setString(6, employee.getAddress());
            ps.setString(7, employee.getPhone());
            ps.setDouble(8, employee.getSalary());
            ps.setString(9, employee.getNote());
            n = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public void updateEmployee(Employee employee) {
        try {
            con = new DatabaseConnection().getConnection();
            String query = "update employee set name=?,password=?,role_id=?,nrc=?,address=?,phone=?,salary=?,note=? where cinema_id=? and id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, employee.getName());
            ps.setString(2, employee.getPassword());
            ps.setInt(3, employee.getRole_id());
            ps.setString(4, employee.getNrc());
            ps.setString(5, employee.getAddress());
            ps.setString(6, employee.getPhone());
            ps.setDouble(7, employee.getSalary());
            ps.setString(8, employee.getNote());
            ps.setInt(9, employee.getCinema_id());;
            ps.setInt(10, employee.getId());
            ps.executeUpdate();
            con.close();
            logMessage("Updated Successful!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try {
            con = new DatabaseConnection().getConnection();
            String query = "delete from employee where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            con.close();
            logMessage("Deleted Successful!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllEmployee(int cinema_id) {
        List<Employee> list = new ArrayList<>();
        try {
            con = new DatabaseConnection().getConnection();
            String query = "select * from employee where cinema_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, cinema_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setCinema_id(rs.getInt("cinema_id"));
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setPassword(rs.getString("password"));
                employee.setRole_id(Integer.parseInt(rs.getString("role_id")));
                employee.setNrc(rs.getString("nrc"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getString("phone"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setNote(rs.getString("note"));
                list.add(employee);
            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = null;
        try {
            con = new DatabaseConnection().getConnection();
            String query = "select * from employee where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                employee = new Employee();
                employee.setCinema_id(rs.getInt("cinema_id"));
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setPassword(rs.getString("password"));
                employee.setRole_id(Integer.parseInt(rs.getString("role_id")));
                employee.setNrc(rs.getString("nrc"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getString("phone"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setNote(rs.getString("note"));
            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void logMessage(String log) {
        JOptionPane.showMessageDialog(null, log, "", JOptionPane.INFORMATION_MESSAGE);
    }

}
