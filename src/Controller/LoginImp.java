/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Interface.LoginInterface;
import Model.RoleType;
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
public class LoginImp implements LoginInterface {

    static Connection con = null;

    @Override
    public int login(int roleID, String username, String password) {
        int n = 0;
        try {
            con = new DatabaseConnection().getConnection();
            String query = "select * from employee where name=? and password=? and role_id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setInt(3, roleID);
            // Execute the query
            ResultSet rs = ps.executeQuery();  // Use executeQuery for SELECT statements

            while (rs.next()) {
                n = 1;
                SharedData sharedData = SharedData.getInstance();
                sharedData.setCinema_id(rs.getInt("cinema_id"));
                RoleType roleType = new RoleTypeImp().getRoleType(roleID);
                sharedData.setControl(roleType.getControl());

                break;
            }

            // Close the ResultSet and PreparedStatement
            rs.close();
            ps.close();

            con.close();

        } catch (SQLException ex) {
            logMessage(ex.getMessage());
        }
        return n;
    }

    @Override
    public void logMessage(String log) {
        JOptionPane.showMessageDialog(null, log, "", JOptionPane.INFORMATION_MESSAGE);
    }

}
