/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.BuySeatImp;
import Controller.Printer;
import Controller.RoomImp;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class TicketItem extends JPanel {

    private Show show = null;
    private Cinema cinema = null;
    private Room room = null;
    private Movie movie = null;
    private Ticket ticket = null;

    public TicketItem(Show show, Cinema cinema, Room room, Movie movie, Ticket ticket) {
        this.show = show;
        this.cinema = cinema;
        this.room = room;
        this.movie = movie;
        this.ticket = ticket;
        addTicketCard();
    }

    public void addTicketCard() {
        javax.swing.JLabel branchLabel;
        javax.swing.JLabel dateLabel;
        javax.swing.JLabel jLabel1;
        javax.swing.JLabel jLabel2;
        javax.swing.JPanel jPanel2;
        javax.swing.JScrollPane jScrollPane1;
        javax.swing.JButton printBtn;
        javax.swing.JPanel printPanel;
        javax.swing.JLabel roomLabel;
        javax.swing.JTable seatTable;
        javax.swing.JLabel showTimeLabel;
        javax.swing.JLabel timeLabel;
        javax.swing.JLabel titleLabel;
        javax.swing.JLabel totalPriceLabel;

        jPanel2 = new javax.swing.JPanel();
        printBtn = new javax.swing.JButton();
        printPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        branchLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        showTimeLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        roomLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        seatTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        totalPriceLabel = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        printBtn.setBackground(new java.awt.Color(0, 102, 204));
        printBtn.setForeground(new java.awt.Color(255, 255, 255));
        printBtn.setText("Print");

        printPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("MingalarCinema");

        branchLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        titleLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        showTimeLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        showTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        roomLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        seatTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Seat", "Type", "Price"
                }
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        seatTable.setGridColor(new java.awt.Color(255, 255, 255));
        seatTable.setShowHorizontalLines(true);
        int width = 316;
        int height = ticket.getSeat_id_list().size() * 20;
        seatTable.setRowHeight(20);
        seatTable.setPreferredScrollableViewportSize(new Dimension(width, height));
        jScrollPane1.setViewportView(seatTable);
        if (seatTable.getColumnModel().getColumnCount() > 0) {
            seatTable.getColumnModel().getColumn(0).setMinWidth(80);
            seatTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            seatTable.getColumnModel().getColumn(0).setMaxWidth(80);
            seatTable.getColumnModel().getColumn(2).setMinWidth(80);
            seatTable.getColumnModel().getColumn(2).setPreferredWidth(80);
            seatTable.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        jLabel2.setText("Total Price");

        totalPriceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout printPanelLayout = new javax.swing.GroupLayout(printPanel);
        printPanel.setLayout(printPanelLayout);
        printPanelLayout.setHorizontalGroup(
            printPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(printPanelLayout.createSequentialGroup()
                .addGroup(printPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(printPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, printPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2)
                            .addGap(57, 57, 57)
                            .addComponent(totalPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, printPanelLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, printPanelLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(branchLabel))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, printPanelLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(roomLabel))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, printPanelLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, printPanelLayout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, printPanelLayout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addComponent(showTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, printPanelLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(printPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(timeLabel)))
                .addGap(6, 6, 6))
        );
        printPanelLayout.setVerticalGroup(
            printPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(printPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(branchLabel)
                .addGap(6, 6, 6)
                .addComponent(roomLabel)
                .addGap(8, 8, 8)
                .addComponent(titleLabel)
                .addGap(6, 6, 6)
                .addComponent(dateLabel)
                .addGap(12, 12, 12)
                .addComponent(showTimeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(printPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totalPriceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeLabel)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(printPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(printBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(printPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printBtn)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        
        branchLabel.setText("Branch : " + cinema.getBranch() + ", " + cinema.getCity());
        titleLabel.setText(movie.getTitle());
        showTimeLabel.setText("Show Time : " + show.getTime());
        roomLabel.setText("Room : " + room.getRoom());
        DefaultTableModel model = (DefaultTableModel) seatTable.getModel();
        double total_price = 0;
        for (int seat_id : ticket.getSeat_id_list()) {
            BuySeat buySeat = new BuySeatImp().getBuySeat(seat_id);
            Seat seat = new RoomImp().getSeat(buySeat.getSeat_id());
            dateLabel.setText("Date : " + buySeat.getDate());
            timeLabel.setText("Time : " + buySeat.getTime());
            total_price += buySeat.getPrice();
            model.addRow(new Object[]{seat.getSeat_row() + seat.getSeat(), seat.getType(), buySeat.getPrice()});
        }
        totalPriceLabel.setText(total_price + "");
        printBtn.addActionListener((ActionEvent e) -> {
            new Printer().printPanel(printPanel);
        });
    }
}
