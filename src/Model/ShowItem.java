/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.ImageUtils;
import Controller.SharedData;
import Controller.ShowImp;
import View.AvailableSeatsDialog;
import View.EditShowDialog;
import View.MoviePanel;
import View.SeatsDialog;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 *
 * @author DELL
 */
public class ShowItem extends JPanel {

    private Show show = null;
    private Room room = null;
    private Movie movie = null;
    private String control;

    public ShowItem(Show show, Room room, Movie movie) {
        this.show = show;
        this.room = room;
        this.movie = movie;
        SharedData sharedData = SharedData.getInstance();
        control = sharedData.getControl();
        setPreferredSize(new Dimension(537, 350));
        addShowCard();
    }

    private void addShowCard() {

        BufferedImage decodedImage = null;
        try {
            decodedImage = ImageUtils.decodeBase64ToImage(movie.getImage());

        } catch (IOException ex) {
            Logger.getLogger(MoviePanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Variables declaration - do not modify                     
        javax.swing.JLabel actionLabel;
        javax.swing.JPanel cardPanel;
        javax.swing.JLabel dateLabel;
        javax.swing.JTextArea detailArea;
        javax.swing.JLabel durationLabel;
        javax.swing.JLabel genreLabel;
        javax.swing.JLabel imageLabel;
        javax.swing.JLabel jLabel2;
        javax.swing.JPanel jPanel1;
        javax.swing.JScrollPane jScrollPane1;
        javax.swing.JButton seatBtn;
        javax.swing.JLabel showTimeLabel;
        javax.swing.JLabel titleLabel;
        javax.swing.JButton trailerBtn;
        javax.swing.JLabel yearLabel;
        javax.swing.JLabel roomLabel;

        jLabel2 = new javax.swing.JLabel();
        cardPanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        showTimeLabel = new javax.swing.JLabel();
        trailerBtn = new javax.swing.JButton();
        seatBtn = new javax.swing.JButton();
        yearLabel = new javax.swing.JLabel();
        durationLabel = new javax.swing.JLabel();
        genreLabel = new javax.swing.JLabel();
        actionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailArea = new javax.swing.JTextArea();
        roomLabel = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setLayout(new java.awt.BorderLayout());

        cardPanel.setBackground(new java.awt.Color(0, 0, 0));
        cardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Scale the image
        Image scaledImage = decodedImage.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        imageLabel.setIcon(scaledIcon); // NOI18N
        imageLabel.setText("");
        imageLabel.setMaximumSize(new java.awt.Dimension(250, 350));
        imageLabel.setMinimumSize(new java.awt.Dimension(250, 350));
        imageLabel.setOpaque(true);
        imageLabel.setPreferredSize(new java.awt.Dimension(250, 350));
        cardPanel.add(imageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(java.awt.Color.black);

        titleLabel.setBackground(new java.awt.Color(0, 0, 0));
        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleLabel.setText(movie.getTitle());
        titleLabel.setAutoscrolls(true);

        dateLabel.setBackground(new java.awt.Color(0, 0, 0));
        dateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dateLabel.setText("Date " + show.getStart_date() + " To " + show.getEnd_date());

        showTimeLabel.setBackground(new java.awt.Color(0, 0, 0));
        showTimeLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        showTimeLabel.setForeground(new java.awt.Color(255, 255, 255));
        showTimeLabel.setText("Show Time  : " + show.getTime());

        trailerBtn.setBackground(new java.awt.Color(0, 153, 51));
        trailerBtn.setForeground(new java.awt.Color(255, 255, 255));
        trailerBtn.setText("Trailer");
        trailerBtn.setPreferredSize(new java.awt.Dimension(72, 26));

        seatBtn.setBackground(new java.awt.Color(0, 102, 204));
        seatBtn.setForeground(new java.awt.Color(255, 255, 255));
        seatBtn.setText("Seats");
        seatBtn.setPreferredSize(new java.awt.Dimension(72, 26));

        yearLabel.setForeground(new java.awt.Color(255, 255, 255));
        yearLabel.setText(movie.getRelease_date());

        durationLabel.setForeground(new java.awt.Color(255, 255, 255));
        durationLabel.setText(movie.getDuration());

        genreLabel.setForeground(new java.awt.Color(255, 255, 255));
        genreLabel.setText(movie.getGenre());

        actionLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Downloads\\info.png")); // NOI18N
        actionLabel.setMaximumSize(new java.awt.Dimension(40, 40));
        actionLabel.setMinimumSize(new java.awt.Dimension(40, 40));
        actionLabel.setPreferredSize(new java.awt.Dimension(40, 40));

        detailArea.setColumns(20);
        detailArea.setLineWrap(true);
        detailArea.setRows(5);
        detailArea.setText(movie.getDetail());
        detailArea.setWrapStyleWord(true);
        detailArea.setPreferredSize(new java.awt.Dimension(245, 148));
        jScrollPane1.setViewportView(detailArea);

        roomLabel.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        roomLabel.setForeground(new java.awt.Color(255, 255, 0));
        roomLabel.setText("Room : " + room.getRoom());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(roomLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(actionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(trailerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(seatBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(yearLabel)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(durationLabel)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(genreLabel))
                                                                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(0, 1, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(showTimeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(dateLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(actionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(roomLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(titleLabel)
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(yearLabel)
                                        .addComponent(durationLabel)
                                        .addComponent(genreLabel))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addGap(12, 12, 12)
                                .addComponent(dateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(showTimeLabel)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(trailerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(seatBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25))
        );

        cardPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 270, 350));

        add(cardPanel, java.awt.BorderLayout.SOUTH);

        // Create a JPopupMenu
        JPopupMenu popupMenu = new JPopupMenu();

        // Add menu items to the popup menu
        JMenuItem editItem = new JMenuItem("Edit");
        JMenuItem deleteItem = new JMenuItem("Delete");

        editItem.addActionListener(e -> handleEditItemClick());
        deleteItem.addActionListener(e -> handleDeleteItemClick());

        if (control.equals("Manage")) {
            popupMenu.add(editItem);
            popupMenu.add(deleteItem);
        }

        // Add a mouse listener to the panel
        actionLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showPopupMenu(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopupMenu(e);
            }

            private void showPopupMenu(MouseEvent e) {
                if (e.isPopupTrigger() || SwingUtilities.isLeftMouseButton(e)) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }

            }
        });
        trailerBtn.addActionListener(e -> handleTrailerClick());
        seatBtn.addActionListener(e -> handleSeatClick());
    }

    private void handleEditItemClick() {
        editDetailAction();
    }

    private void handleDeleteItemClick() {
        int result = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to proceed?",
                "Confirm Action",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (result == JOptionPane.YES_OPTION) {
            new ShowImp().deleteShow(show.getId());
        } else if (result == JOptionPane.NO_OPTION) {

        }

    }

    private void handleTrailerClick() {
        openInBrowser(movie.getTrailer_url());
    }

    private void handleSeatClick() {
        seatAction();
    }

    private static void openInBrowser(String url) {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI(url));
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to open URL: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Desktop browsing is not supported on this platform.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editDetailAction() {
        JDialog dialog = new JDialog((JFrame) null, "", true);
        dialog.setSize(750, 500);
        dialog.setLocationRelativeTo(null); // Center the dialog

        dialog.getContentPane().add(new EditShowDialog(dialog, show.getId()));

        // Set up custom close behavior
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        // Show the JDialog
        dialog.setVisible(true);
    }

    private void seatAction() {
        JDialog dialog = new JDialog((JFrame) null, "", true);
        dialog.setSize(1100, 700);
        dialog.setLocationRelativeTo(null); // Center the dialog

        if(control.equals("Manage")){
            dialog.getContentPane().add(new AvailableSeatsDialog(dialog, show));
        }else{
            dialog.getContentPane().add(new SeatsDialog(dialog, show));
        }
        

        // Set up custom close behavior
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        // Show the JDialog
        dialog.setVisible(true);
    }

    private Image scaleImage(Image originalImage, int targetWidth, int targetHeight) {
        int originalWidth = originalImage.getWidth(null);
        int originalHeight = originalImage.getHeight(null);

        // Calculate scaling factor
        double widthRatio = (double) targetWidth / originalWidth;
        double heightRatio = (double) targetHeight / originalHeight;
        double scaleRatio = Math.min(widthRatio, heightRatio);

        int newWidth = (int) (originalWidth * scaleRatio);
        int newHeight = (int) (originalHeight * scaleRatio);

        // Create a new BufferedImage with the new size
        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g2d.dispose();

        return scaledImage;
    }
}
