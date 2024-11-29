/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.Cinema;
import java.util.List;


/**
 *
 * @author DELL
 */
public interface CinemaInterface {
    
    public int addCinema(Cinema cinema);

    public void updateCinema(Cinema cinema);

    public void deleteCinema(int id);

    public List<Cinema> getAllCinema();
    
    public Cinema getCinema(int id);
    
    public void logMessage(String log);
    
    
}
