/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.Ticket;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface TicketInterface {
    public int addTicket(Ticket ticket);
    public List<Ticket> getAllShowTicket(int cinema_id,String startDate, String endDate);
     public List<Ticket> getShowTicket(int show_id);
}
