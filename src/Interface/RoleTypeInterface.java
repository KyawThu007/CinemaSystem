/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Model.RoleType;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface RoleTypeInterface {

    public int addRoleType(RoleType role_type);

    public void updateRoleType(RoleType role_type);

    public void deleteRoleType(int id);

    public List<RoleType> getAllRoleType();
    
    public RoleType getRoleType(int id);
    
    public void logMessage(String log);

}
