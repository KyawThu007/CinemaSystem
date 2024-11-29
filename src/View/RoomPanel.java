/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.ObjectCheck;
import Controller.RoomImp;
import Model.Room;
import Model.Seat;
import Controller.SharedData;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class RoomPanel extends javax.swing.JPanel {

    /**
     * Creates new form CinemaPanel
     */
    DefaultTableModel model;
    int room_id;

    int cinema_id;

    public RoomPanel() {
        initComponents();

        // Get the singleton instance
        SharedData sharedData = SharedData.getInstance();

        // Retrieve and print the data
        cinema_id = sharedData.getCinema_id();

        // Create a custom cell renderer to left align text
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.LEFT);

        for (int i = 0; i < roomTable.getColumnCount(); i++) {
            roomTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        for (int i = 0; i < seatTable.getColumnCount(); i++) {
            seatTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        try {
            getAllRoomAction();
            roomSelected();
            getAllSeatAction();
        } catch (Exception e) {
            e.printStackTrace();
        }
        roomBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                roomSelected();
                getAllSeatAction();
            }

        });
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
        jScrollPane1 = new javax.swing.JScrollPane();
        roomTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        refreshSeatBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        updateBtn2 = new javax.swing.JButton();
        deleteBtn2 = new javax.swing.JButton();
        roomBox = new javax.swing.JComboBox<>();
        refreshRoomBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        seatTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        typeBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        insertBtn2 = new javax.swing.JButton();
        cancelBtn2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rowBox = new javax.swing.JComboBox<>();
        columnBox = new javax.swing.JComboBox<>();
        seatField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        branchField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        insertBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        roomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Room"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(roomTable);
        if (roomTable.getColumnModel().getColumnCount() > 0) {
            roomTable.getColumnModel().getColumn(0).setMinWidth(60);
            roomTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            roomTable.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Room");

        refreshSeatBtn.setText("Refresh");
        refreshSeatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshSeatBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        updateBtn2.setText("Update");
        updateBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtn2ActionPerformed(evt);
            }
        });

        deleteBtn2.setText("Delete");
        deleteBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtn2ActionPerformed(evt);
            }
        });

        refreshRoomBtn.setText("Refresh");
        refreshRoomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshRoomBtnActionPerformed(evt);
            }
        });

        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Room :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(60, 60, 60)
                .addComponent(deleteBtn)
                .addGap(18, 18, 18)
                .addComponent(updateBtn)
                .addGap(18, 18, 18)
                .addComponent(refreshRoomBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roomBox, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteBtn2)
                .addGap(18, 18, 18)
                .addComponent(updateBtn2)
                .addGap(18, 18, 18)
                .addComponent(refreshSeatBtn)
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(refreshSeatBtn)
                    .addComponent(updateBtn)
                    .addComponent(deleteBtn)
                    .addComponent(updateBtn2)
                    .addComponent(deleteBtn2)
                    .addComponent(roomBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshRoomBtn)
                    .addComponent(jButton1)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25))
        );

        seatTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Seat", "Row", "Column", "Type", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(seatTable);
        if (seatTable.getColumnModel().getColumnCount() > 0) {
            seatTable.getColumnModel().getColumn(0).setMinWidth(60);
            seatTable.getColumnModel().getColumn(0).setPreferredWidth(60);
            seatTable.getColumnModel().getColumn(0).setMaxWidth(60);
            seatTable.getColumnModel().getColumn(1).setMinWidth(60);
            seatTable.getColumnModel().getColumn(1).setPreferredWidth(60);
            seatTable.getColumnModel().getColumn(1).setMaxWidth(60);
            seatTable.getColumnModel().getColumn(2).setMinWidth(60);
            seatTable.getColumnModel().getColumn(2).setPreferredWidth(60);
            seatTable.getColumnModel().getColumn(2).setMaxWidth(60);
            seatTable.getColumnModel().getColumn(3).setMinWidth(60);
            seatTable.getColumnModel().getColumn(3).setPreferredWidth(60);
            seatTable.getColumnModel().getColumn(3).setMaxWidth(60);
            seatTable.getColumnModel().getColumn(5).setMinWidth(80);
            seatTable.getColumnModel().getColumn(5).setPreferredWidth(80);
            seatTable.getColumnModel().getColumn(5).setMaxWidth(80);
        }

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setText("Type");

        typeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Standard", "Recliner", "VIP", "Couple", "Reserved", "Luxury or Premium", "Traditional" }));

        jLabel6.setText("Price");

        insertBtn2.setText("Insert");
        insertBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtn2ActionPerformed(evt);
            }
        });

        cancelBtn2.setText("Cancel");
        cancelBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtn2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Row");

        jLabel8.setText("Column");

        rowBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" }));

        columnBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16" }));

        jLabel1.setText("Seat");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(typeBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(seatField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(priceField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(insertBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cancelBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rowBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel8)
                                        .addComponent(columnBox, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(seatField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rowBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(columnBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertBtn2)
                    .addComponent(cancelBtn2))
                .addGap(46, 46, 46))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        branchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                branchFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Room");

        insertBtn.setText("Insert");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(branchField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(insertBtn)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(branchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertBtn)
                    .addComponent(cancelBtn))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void branchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_branchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_branchFieldActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed

        // TODO add your handling code here:
        updateRoomAction();
    }//GEN-LAST:event_updateBtnActionPerformed

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        // TODO add your handling code here:
        addRoomAction();
    }//GEN-LAST:event_insertBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        deleteRoomAction();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void refreshSeatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshSeatBtnActionPerformed
        // TODO add your handling code here:
        getAllSeatAction();
    }//GEN-LAST:event_refreshSeatBtnActionPerformed

    private void insertBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtn2ActionPerformed
        // TODO add your handling code here:
        addSeatAction();
    }//GEN-LAST:event_insertBtn2ActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        cancel();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void refreshRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshRoomBtnActionPerformed
        // TODO add your handling code here:
        getAllRoomAction();
    }//GEN-LAST:event_refreshRoomBtnActionPerformed

    private void cancelBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtn2ActionPerformed
        // TODO add your handling code here:
        cancelSeat();
    }//GEN-LAST:event_cancelBtn2ActionPerformed

    private void updateBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtn2ActionPerformed
        // TODO add your handling code here:
        updateSeatAction();
    }//GEN-LAST:event_updateBtn2ActionPerformed

    private void deleteBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtn2ActionPerformed
        // TODO add your handling code here:
        deleteSeatAction();
    }//GEN-LAST:event_deleteBtn2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        seatViewAction();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void seatViewAction() {
        // Create and configure the JDialog
        JDialog dialog = new JDialog((JFrame) null, "", true);
        dialog.setSize(1100, 700);
        dialog.setLocationRelativeTo(null); // Center the dialog

        dialog.getContentPane().add(new ViewPanel(dialog, cinema_id, room_id));

        // Set up custom close behavior
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        // Show the JDialog
        dialog.setVisible(true);

    }

    public void addSeatAction() {

        try {
            double price = 0;
            if (!priceField.getText().isEmpty()) {
                price = Double.parseDouble(priceField.getText());
            }
            Seat seat = new Seat();
            seat.setCinema_id(cinema_id);
            seat.setRoom_id(room_id);
            seat.setSeat(seatField.getText());
            seat.setSeat_row(rowBox.getSelectedItem().toString());
            seat.setSeat_column(Integer.parseInt(columnBox.getSelectedItem().toString()));
            seat.setType(typeBox.getSelectedItem().toString());
            seat.setPrice(price);

            if (new ObjectCheck().isNullObject(seat)) {
                logMessage("Fill Data!");
            } else {
                int n = new RoomImp().addSeat(seat);
                if (n == 1) {
                    logMessage("Added Successful!");
                    autoIncreaseSeat();
                    getAllSeatAction();
                } else {
                    logMessage("Error!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void autoIncreaseSeat() {
        if (Integer.parseInt(seatField.getText()) < 16) {
            columnBox.setSelectedIndex(Integer.parseInt(seatField.getText()));
            seatField.setText(String.valueOf(Integer.parseInt(seatField.getText()) + 1));

        } else {
            seatField.setText("1");
            columnBox.setSelectedIndex(0);
        }

    }

    public void updateSeatAction() {
        int selectedRow = seatTable.getSelectedRow();
        if (selectedRow != -1) {
            // Get data from the selected row
            Seat seat = new Seat();
            seat.setId((int) seatTable.getValueAt(selectedRow, 0));
            seat.setSeat(seatTable.getValueAt(selectedRow, 1).toString());
            seat.setSeat_row(seatTable.getValueAt(selectedRow, 2).toString());
            seat.setSeat_column(Integer.parseInt(seatTable.getValueAt(selectedRow, 3).toString()));
            seat.setType(seatTable.getValueAt(selectedRow, 4).toString());
            seat.setPrice((double) seatTable.getValueAt(selectedRow, 5));
            new RoomImp().updateSeat(seat);
            getAllSeatAction();
        } else {
            // No row selected
            logMessage("Selected!");
        }
    }

    public void deleteSeatAction() {
        int selectedRow = seatTable.getSelectedRow();
        if (selectedRow != -1) {
            // Get data from the selected row
            new RoomImp().deleteSeat((int) seatTable.getValueAt(selectedRow, 0));
            getAllSeatAction();

        } else {
            // No row selected
            logMessage("Selected!");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField branchField;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton cancelBtn2;
    private javax.swing.JComboBox<String> columnBox;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton deleteBtn2;
    private javax.swing.JButton insertBtn;
    private javax.swing.JButton insertBtn2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField priceField;
    private javax.swing.JButton refreshRoomBtn;
    private javax.swing.JButton refreshSeatBtn;
    private javax.swing.JComboBox<String> roomBox;
    private javax.swing.JTable roomTable;
    private javax.swing.JComboBox<String> rowBox;
    private javax.swing.JTextField seatField;
    private javax.swing.JTable seatTable;
    private javax.swing.JComboBox<String> typeBox;
    private javax.swing.JButton updateBtn;
    private javax.swing.JButton updateBtn2;
    // End of variables declaration//GEN-END:variables

    public void addRoomAction() {

        try {
            if (branchField.getText().isEmpty()) {
                logMessage("Fill Data!");
            } else {
                Room room = new Room();
                room.setCinema_id(cinema_id);
                room.setRoom(branchField.getText());
                int n = new RoomImp().addRoom(room);
                if (n == 1) {
                    logMessage("Added Successful!");
                    cancel();
                    getAllRoomAction();
                } else {
                    logMessage("Error!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void cancel() {
        branchField.setText("");
    }

    public void cancelSeat() {
        seatField.setText("");
        priceField.setText("");
    }

    public void updateRoomAction() {
        int selectedRow = roomTable.getSelectedRow();
        System.out.println("Selected Row => " + selectedRow);
        if (selectedRow != -1) {
            // Get data from the selected row
            Room room = new Room();
            room.setId((int) roomTable.getValueAt(selectedRow, 0));
            room.setRoom(roomTable.getValueAt(selectedRow, 1).toString());
            new RoomImp().updateRoom(room);
            getAllRoomAction();
        } else {
            // No row selected
            logMessage("Selected!");
        }
    }

    public void deleteRoomAction() {
        int selectedRow = roomTable.getSelectedRow();
        if (selectedRow != -1) {
            // Get data from the selected row
            new RoomImp().deleteRoom((int) roomTable.getValueAt(selectedRow, 0));
            getAllRoomAction();

        } else {
            // No row selected
            logMessage("Selected!");
        }
    }

    public void getAllRoomAction() {
        model = (DefaultTableModel) roomTable.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (Room room : new RoomImp().getAllRoom(cinema_id)) {
            model.addRow(new Object[]{room.getId(), room.getRoom()});
        }
        roomBox.removeAllItems();
        for (Room room : new RoomImp().getAllRoom(cinema_id)) {
            roomBox.addItem(room.getRoom());
        }
    }

    public void getAllSeatAction() {
        model = (DefaultTableModel) seatTable.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        for (Seat seat : new RoomImp().getAllSeat(cinema_id, room_id)) {
            model.addRow(new Object[]{seat.getId(), seat.getSeat(), seat.getSeat_row(), seat.getSeat_column(), seat.getType(), seat.getPrice()});
        }

    }

    public void logMessage(String log) {
        JOptionPane.showMessageDialog(null, log, "", JOptionPane.INFORMATION_MESSAGE);
    }

    public void roomSelected() {
        List<Room> list = new RoomImp().getAllRoom(cinema_id);
        for(Room room: list){
            if(room.getRoom().equals(roomBox.getSelectedItem())){
                room_id = room.getId();
                break;
            }
                
        }
    }
}
