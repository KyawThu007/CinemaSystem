/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import Model.BuySeat;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface BuySeatInterface {

    public int addBuySeat(BuySeat buySeat);
    public List<BuySeat> getShowBuySeat(int show_id);
    public List<BuySeat> getAllShowBuySeat(int cinema_id);
    public BuySeat getBuySeat(int id);
}
