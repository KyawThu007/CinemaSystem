/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Model.Room;
import Model.Seat;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface RoomInterface {

    public int addRoom(Room room);

    public void updateRoom(Room room);

    public void deleteRoom(int id);

    public List<Room> getAllRoom(int cinema_id);

    public Room getRoom(int id);

    public void logMessage(String log);

    public int addSeat(Seat seat);

    public void updateSeat(Seat seat);

    public void deleteSeat(int id);

    public List<Seat> getAllSeat(int cinema_id, int room_id);
    
    public Seat getSeat(int id);

    public List<Seat> getAllSeatBySort(int cinema_id, int room_id, String seat_row);

}
