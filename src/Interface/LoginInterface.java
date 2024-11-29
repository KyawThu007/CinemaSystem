/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.RoleType;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface LoginInterface {

    public int login(int roleID, String username, String password);

    public void logMessage(String log);
}
