/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Interface.ExpenseInterface;
import Model.Expense;
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
public class ExpenseImp implements ExpenseInterface {

    static Connection con = null;

    @Override
    public int addExpense(Expense expense) {
        int n = 0;
        try {
            con = new DatabaseConnection().getConnection();
            String query = "insert into expense(cinema_id,amount,note,date) values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, expense.getCinema_id());;
            ps.setDouble(2, expense.getAmount());
            ps.setString(3, expense.getNote());
            ps.setString(4, expense.getDate());
            n = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public void updateExpense(Expense expense) {
        try {
            con = new DatabaseConnection().getConnection();
            String query = "update expense set amount=?,note=?,date=? where cinema_id=? and id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, expense.getAmount());
            ps.setString(2, expense.getNote());
            ps.setString(3, expense.getDate());
            ps.setInt(4, expense.getCinema_id());;
            ps.setInt(5, expense.getId());

            ps.executeUpdate();
            con.close();
            logMessage("Updated Successful!");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void deleteExpense(int id) {
        try {
            con = new DatabaseConnection().getConnection();
            String query = "delete from expense where id=?";
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
    public List<Expense> getAllExpense(int cinema_id) {
        List<Expense> list = new ArrayList<>();
        try {
            con = new DatabaseConnection().getConnection();
            String query = "select * from expense where cinema_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, cinema_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Expense expense = new Expense();
                expense.setCinema_id(rs.getInt("cinema_id"));
                expense.setId(rs.getInt("id"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setNote(rs.getString("note"));
                expense.setDate(rs.getString("date"));
                list.add(expense);
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
    public void logMessage(String log) {
        JOptionPane.showMessageDialog(null, log, "", JOptionPane.INFORMATION_MESSAGE);
    }

}
