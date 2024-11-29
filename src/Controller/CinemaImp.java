/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Interface.CinemaInterface;
import Model.Cinema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class CinemaImp implements CinemaInterface {

    static Connection con = null;

    @Override
    public int addCinema(Cinema cinema) {
        int n = 0;
        try {
            con = new DatabaseConnection().getConnection();
            String query = "insert into cinema(branch,city,location) values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cinema.getBranch());
            ps.setString(2, cinema.getCity());
            ps.setString(3, cinema.getLocation());
            n = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public void updateCinema(Cinema cinema) {
        try {
            con = new DatabaseConnection().getConnection();
            String query = "update cinema set branch=?,city=?,location=? where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cinema.getBranch());
            ps.setString(2, cinema.getCity());
            ps.setString(3, cinema.getLocation());
            ps.setInt(4, cinema.getId());
            ps.executeUpdate();
            con.close();
            logMessage("Updated Successful!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCinema(int id) {
        try {
            con = new DatabaseConnection().getConnection();
            String query = "delete from cinema where id=?";
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
    public List<Cinema> getAllCinema() {
        List<Cinema> list = new ArrayList<>();
        try {
            con = new DatabaseConnection().getConnection();
            String query = "select * from cinema";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Cinema cinema = new Cinema();
                cinema.setId(rs.getInt("id"));
                cinema.setBranch(rs.getString("branch"));
                cinema.setCity(rs.getString("city"));
                cinema.setLocation(rs.getString("location"));
                list.add(cinema);
            }
            rs.close();
            statement.close();
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

    @Override
    public Cinema getCinema(int id) {
        Cinema cinema = null;
        try {
            con = new DatabaseConnection().getConnection();
            String query = "select * from cinema where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            // Execute the query
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cinema = new Cinema();
                cinema.setId(rs.getInt("id"));
                cinema.setBranch(rs.getString("branch"));
                cinema.setCity(rs.getString("city"));
                cinema.setLocation(rs.getString("location"));
            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cinema;
    }

}
