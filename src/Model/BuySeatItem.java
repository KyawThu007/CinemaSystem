/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.SharedData;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author DELL
 */
public class BuySeatItem extends JPanel {

    private int cinema_id;
    private Show show = null;
    private Seat seat = null;
    private List<BuySeat> buySeatsList = new ArrayList<>();
    boolean flag = true;
    private String control;

    public BuySeatItem(int cinema_id, Show show, Seat seat, List<BuySeat> buySeatsList) {
        this.cinema_id = cinema_id;
        this.show = show;
        this.seat = seat;
        this.buySeatsList = buySeatsList;
        SharedData sharedData = SharedData.getInstance();
        control = sharedData.getControl();
        setPreferredSize(new Dimension(60, 60));
        addSeatCard();
    }

    private void addSeatCard() {

        javax.swing.JPanel jPanel1;
        javax.swing.JLabel seatLabel;

        jPanel1 = new javax.swing.JPanel();
        seatLabel = new javax.swing.JLabel();

        jPanel1.setBackground(Color.GRAY);

        seatLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        seatLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        seatLabel.setText(seat.getSeat());
        seatLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        seatLabel.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(seatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(seatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        // Add a mouse listener to the panel
        seatLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (SwingUtilities.isRightMouseButton(e)) {
                    JOptionPane.showMessageDialog(null, "Seat Type : " + seat.getType() + "\n Seat Price : " + seat.getPrice());

                } else {
                    if (flag) {
                        if (!control.equals("Manage")) {
                            checkSeat();
                        }
                    }
                }
            }

            private void checkSeat() {
                // Get the singleton instance
                SharedData sharedData = SharedData.getInstance();

                // Retrieve and print the data
                List<BuySeat> list = sharedData.getBuySeatlist();
                boolean flag = false;
                for (int i = 0; i < list.size(); i++) {
                    BuySeat buySeat = list.get(i);
                    if (buySeat.getSeat_id() == seat.getId() && buySeat.getShow_id() == show.getId()) {
                        list.remove(i);
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }
                }

                if (flag) {
                    jPanel1.setBackground(Color.GRAY);

                } else {
                    try {
                        // Get the current instant in UTC
                        Instant now = Instant.now();

                        // Convert Instant to LocalDateTime in system default time zone
                        LocalDateTime local_date = now.atZone(ZoneId.systemDefault()).toLocalDateTime();
                        //LocalDate local_date = LocalDate.now();
                        String date = local_date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                        String time = local_date.format(DateTimeFormatter.ofPattern("hh:mm:ss a"));
                        jPanel1.setBackground(Color.GREEN);
                        BuySeat buySeat = new BuySeat();
                        buySeat.setCinema_id(cinema_id);
                        buySeat.setShow_id(show.getId());
                        buySeat.setSeat_id(seat.getId());
                        buySeat.setDate(date);
                        buySeat.setPrice(seat.getPrice());
                        buySeat.setTime(time);
                        list.add(buySeat);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                jPanel1.revalidate(); // Refresh the layout
                jPanel1.repaint();
                sharedData.setBuySeatlist(list);
            }
        });

        for (int i = 0; i < buySeatsList.size(); i++) {
            BuySeat buySeat = buySeatsList.get(i);
            if (buySeat.getSeat_id() == seat.getId() && buySeat.getShow_id() == show.getId()) {
                flag = false;
                break;

            } else {
                flag = true;
            }

        }
        if (flag) {
            jPanel1.setBackground(Color.GRAY);
        } else {
            jPanel1.setBackground(Color.RED);
        }
        jPanel1.revalidate(); // Refresh the layout
        jPanel1.repaint();
    }

}
