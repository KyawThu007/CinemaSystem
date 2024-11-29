/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Interface.RoleTypeInterface;
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
public class RoleTypeImp implements RoleTypeInterface {

    static Connection con=null;
    @Override
    public int addRoleType(RoleType role_type) {
        int n = 0;
        try {
            con = new DatabaseConnection().getConnection();
            String query = "insert into role(role_type,salary,control) values (?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, role_type.getRole_type());
            ps.setDouble(2, role_type.getSalary());
            ps.setString(3, role_type.getControl());
            n = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public void updateRoleType(RoleType role_type) {
        try {
            con = new DatabaseConnection().getConnection();
            String query = "update expene set role=?,salary=?,control=? where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, role_type.getRole_type());
            ps.setDouble(2, role_type.getSalary());
            ps.setString(3, role_type.getControl());
            ps.setInt(4, role_type.getId());
            ps.executeUpdate();
            con.close();
            logMessage("Updated Successful!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRoleType(int id) {
        try {
            con = new DatabaseConnection().getConnection();
            String query = "delete from role where id=?";
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
    public List<RoleType> getAllRoleType() {
        List<RoleType> list = new ArrayList<>();
        try {
            con = new DatabaseConnection().getConnection();
            String query = "select * from role";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                RoleType roleType = new RoleType();
                roleType.setId(rs.getInt("id"));
                roleType.setRole_type(rs.getString("role_type"));
                roleType.setSalary(rs.getDouble("salary"));
                roleType.setControl(rs.getString("control"));
                list.add(roleType);
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
    public RoleType getRoleType(int id) {
        RoleType roleType=null;
        try {
            con = new DatabaseConnection().getConnection();
            String query = "select * from role where id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                roleType = new RoleType();
                roleType.setId(rs.getInt("id"));
                roleType.setRole_type(rs.getString("role_type"));
                roleType.setSalary(rs.getDouble("salary"));
                roleType.setControl(rs.getString("control"));
                break;
            }
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleType;
    }

    @Override
    public void logMessage(String log) {
        JOptionPane.showMessageDialog(null, log, "", JOptionPane.INFORMATION_MESSAGE);
    }

}
