/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.BuySeatImp;
import Controller.MovieImp;
import Controller.RoomImp;
import Controller.SharedData;
import Controller.TicketImp;
import Model.BuySeat;
import Model.BuySeatItem;
import Model.Movie;
import Model.Room;
import Model.Seat;
import Model.Show;
import Model.Ticket;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author DELL
 */
public class SeatsDialog extends javax.swing.JPanel {

    /**
     * Creates new form SeatsPanel
     */
    JDialog dialog;
    Show show = null;
    List<BuySeat> buySeatsList = new ArrayList<>();
    int cinema_id;

    public SeatsDialog(JDialog dialog, Show show) {
        initComponents();
        this.dialog = dialog;
        this.show = show;

        SharedData sharedData = SharedData.getInstance();
        cinema_id = sharedData.getCinema_id();
        sharedData.setBuySeatlist(new ArrayList<>());

        setup();

        getAllSeatAction();
    }

    public void setup() {
        fromtoLabel.setText("Date " + show.getStart_date() + " To " + show.getEnd_date());
        timeLabel.setText("Show Time : " + show.getTime());

        Room room = new RoomImp().getRoom(show.getRoom_id());
        roomLabel.setText("Room : " + room.getRoom());
        Movie movie = new MovieImp().getMovie(show.getMovie_id());
        titleLabel.setText(movie.getTitle());

        List<BuySeat> list = new BuySeatImp().getShowBuySeat(show.getId());

        String date = SharedData.getInstance().getDate();

        for (BuySeat buySeat : list) {
            if (buySeat.getDate().equals(date)) {
                buySeatsList.add(buySeat);
            }
        }

    }

    private void getAllSeatAction() {

        seatPanel.setLayout(new BorderLayout());

        // Define the row names
        String[] rowName = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        // Create the parent panel with GridLayout
        JPanel rowPanel = new JPanel();
        rowPanel.setLayout(new GridLayout(rowName.length + 1, 1, 5, 5)); // Added gaps for clarity

        // Loop through each row
        for (String row : rowName) {
            JPanel cardPanel = new JPanel();

            // Fetch the seat list for the current row
            List<Seat> list = new RoomImp().getAllSeatBySort(show.getCinema_id(), show.getRoom_id(), row);

            // Proceed only if the list is not empty
            if (!list.isEmpty()) {
                int numColumns = 16;
                int numRows = (int) Math.ceil((double) list.size() / numColumns);

                // Set up GridLayout for the cardPanel
                cardPanel.setLayout(new GridLayout(numRows, numColumns, 5, 5)); // Adjust gaps as needed

                // Add each seat to the cardPanel
                for (Seat seat : list) {
                    cardPanel.add(new BuySeatItem(cinema_id, show, seat, buySeatsList));
                }

                // Add empty labels to fill the remaining grid cells
                int emptyCells = (numRows * numColumns) - list.size();
                for (int j = 0; j < emptyCells; j++) {
                    cardPanel.add(new JLabel()); // Empty label to fill the grid
                }

            }
            // Add the cardPanel to the rowPanel
            rowPanel.add(cardPanel, BorderLayout.EAST);
            if (!list.isEmpty()) {
                JLabel label = new JLabel();
                label.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
                label.setForeground(new java.awt.Color(1, 1, 1));
                label.setText(row);
                rowPanel.add(label, BorderLayout.WEST);
            }
        }

        // Create and set up the scroll pane
        JScrollPane scrollPane = new JScrollPane(rowPanel);
        scrollPane.setPreferredSize(new Dimension(780, 600));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        // Update the seatPanel with the new content
        seatPanel.removeAll(); // Clear existing components
        seatPanel.add(scrollPane); // Add the new scroll pane
        seatPanel.revalidate(); // Refresh the layout
        seatPanel.repaint(); // Redraw the panel
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        roomLabel = new javax.swing.JLabel();
        fromtoLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        buyBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        reciptBtn = new javax.swing.JButton();
        seatPanel = new javax.swing.JPanel();

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        roomLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        roomLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        roomLabel.setText("Room : 2");

        fromtoLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fromtoLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fromtoLabel.setText("Date 2024-8-25 To 2024-8-28");

        timeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setText("Show Time  : 10:00 AM");

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleLabel.setText("Ghostbusters");

        buyBtn.setText("Buy");
        buyBtn.setPreferredSize(new java.awt.Dimension(80, 23));
        buyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyBtnActionPerformed(evt);
            }
        });

        closeBtn.setText("Close");
        closeBtn.setPreferredSize(new java.awt.Dimension(80, 23));
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        reciptBtn.setText("Ticket");
        reciptBtn.setPreferredSize(new java.awt.Dimension(80, 23));
        reciptBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reciptBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fromtoLabel)
                        .addGap(40, 40, 40)
                        .addComponent(timeLabel)))
                .addGap(180, 180, 180)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(reciptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(roomLabel))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fromtoLabel)
                            .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reciptBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout seatPanelLayout = new javax.swing.GroupLayout(seatPanel);
        seatPanel.setLayout(seatPanelLayout);
        seatPanelLayout.setHorizontalGroup(
            seatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        seatPanelLayout.setVerticalGroup(
            seatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(seatPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seatPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyBtnActionPerformed
        // TODO add your handling code here:

        addBuySeatAction();

    }//GEN-LAST:event_buyBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        // TODO add your handling code here:
        dialog.dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void reciptBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reciptBtnActionPerformed
        // TODO add your handling code here:
        showReciptAction();
    }//GEN-LAST:event_reciptBtnActionPerformed

    public void showReciptAction() {
        JDialog dialog = new JDialog((JFrame) null, "", true);
        dialog.setSize(1150, 700);
        dialog.setLocationRelativeTo(null); // Center the dialog

        dialog.getContentPane().add(new TicketDialog(dialog, show));

        // Set up custom close behavior
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        // Show the JDialog
        dialog.setVisible(true);
    }

    public void addBuySeatAction() {
        SharedData sharedData = SharedData.getInstance();
        int n = 0;
        String date = null;
        List<Integer> seat_id_list = new ArrayList<>();
        Random random = new Random();
        int randomNumber = random.nextInt(1000);

        for (BuySeat buySeat : sharedData.getBuySeatlist()) {
            String id = buySeat.getCinema_id() + "" + buySeat.getShow_id() + "" + buySeat.getSeat_id() + "" + randomNumber;
            buySeat.setId(Integer.parseInt(id));
            seat_id_list.add(Integer.parseInt(id));
            date = buySeat.getDate();
            n = new BuySeatImp().addBuySeat(buySeat);
        }

        if (n == 1) {
            Ticket ticket = new Ticket();
            ticket.setCinema_id(show.getCinema_id());
            ticket.setShow_id(show.getId());
            ticket.setSeat_id_list(seat_id_list);
            ticket.setDate(date);
            n = new TicketImp().addTicket(ticket);
        }
        if (n == 1) {
            logMessage("Added Successful!");
            setup();
            getAllSeatAction();
        } else {
            logMessage("Error!");
        }
    }

    public void logMessage(String log) {
        JOptionPane.showMessageDialog(null, log, "", JOptionPane.INFORMATION_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buyBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel fromtoLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton reciptBtn;
    private javax.swing.JLabel roomLabel;
    private javax.swing.JPanel seatPanel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
