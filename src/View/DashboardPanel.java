/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.AnalysisImp;
import Controller.CinemaImp;
import Controller.EmployeeImp;
import Controller.RoomImp;
import Controller.SharedData;
import Model.Cinema;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.XYItemEntity;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author DELL
 */
public class DashboardPanel extends javax.swing.JPanel {

    /**
     * Creates new form DashboardPanel
     */
    private int cinema_id;
    private String[] genreList;
    private String[] monthList;

    public DashboardPanel() {
        initComponents();
        
        SharedData sharedData = SharedData.getInstance();
        cinema_id = sharedData.getCinema_id();
        genreList = sharedData.getGenreList();
        monthList = sharedData.getMonthList();

        for (String monthList1 : monthList) {
            monthBox2.addItem(monthList1);
        }

        for (String genreList1 : genreList) {
            genreBox.addItem(genreList1);
        }

        LocalDate date = LocalDate.parse(LocalDate.now().toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String getMonthName = date.getMonth().name().toLowerCase();
        int getYear = date.getYear();
        for (int i = 0; i < yearBox1.getItemCount(); i++) {
            int setYear = Integer.parseInt(yearBox1.getItemAt(i));
            if (setYear == getYear) {
                yearBox1.setSelectedIndex(i);
                yearBox2.setSelectedIndex(i);
                break;
            }
        }
        for (int i = 0; i < monthBox2.getItemCount(); i++) {
            String setMonth = monthBox2.getItemAt(i).toLowerCase();
            if (setMonth.equals(getMonthName)) {
                monthBox2.setSelectedIndex(i);
                break;
            }
        }

        imageSetup(branchImage, "C://Users/DELL/Downloads/cinema.png");
        imageSetup(employeeImage, "C://Users/DELL/Downloads/employee.png");
        imageSetup(roomImage, "C://Users/DELL/Downloads/room.png");

        setup();
    }

    private void setup() {
        yearlyMovieLineChart();
        monthlyMovieBarChart();
        setCount();
    }

    public void setCount() {
        Cinema cinema = new CinemaImp().getCinema(cinema_id);
        branchField.setText(cinema.getBranch());
        cityField.setText(cinema.getCity());
        int emp_count = new EmployeeImp().getAllEmployee(cinema_id).size();
        int room_count = new RoomImp().getAllRoom(cinema_id).size();
        employeeCount.setText(String.valueOf(emp_count));
        roomCount.setText(String.valueOf(room_count));
    }

    private void imageSetup(JLabel imageLabel, String file) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(file));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Scale the image
        Image scaledImage = bufferedImage.getScaledInstance(94, 94, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(imageIcon);

    }

    public void yearlyMovieLineChart() {
        DefaultCategoryDataset dataset = new AnalysisImp().getYearMovieAnalysis(cinema_id, genreList, Integer.parseInt(yearBox1.getSelectedItem().toString()), monthList);

        JFreeChart chart = ChartFactory.createLineChart(
                "Genre Graph",
                "Month",
                "Score",
                dataset,
                PlotOrientation.VERTICAL, true, true, false);
chart.setBackgroundPaint(Color.WHITE);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setDomainZoomable(false);
        chartPanel.setRangeZoomable(false);
        chartPanel.setPreferredSize(new Dimension(120, 420));
        // Update panel layout
        moviePanel1.setLayout(new BorderLayout());
        moviePanel1.removeAll();
        moviePanel1.add(chartPanel, BorderLayout.CENTER);
        moviePanel1.revalidate();
        moviePanel1.repaint();

        // Add mouse listener
        chartPanel.addChartMouseListener(new ChartMouseListener() {

            @Override
            public void chartMouseClicked(ChartMouseEvent e) {
                ChartEntity entity = e.getEntity();
                if (entity instanceof CategoryItemEntity) {
                    CategoryItemEntity itemEntity = (CategoryItemEntity) entity;
                    String seriesKey = itemEntity.getDataset().getRowKey(itemEntity.getSeries()).toString();
                    String categoryKey = itemEntity.getDataset().getColumnKey(itemEntity.getCategoryIndex()).toString();
                    Number value = itemEntity.getDataset().getValue(itemEntity.getSeries(), itemEntity.getCategoryIndex());

                    String message = String.format("%s, Month: %s, Value: %s", seriesKey, categoryKey, value);
                    JOptionPane.showMessageDialog(null, message);
                } else if (entity instanceof XYItemEntity) {
                    XYItemEntity itemEntity = (XYItemEntity) entity;
                    int seriesIndex = itemEntity.getSeriesIndex();
                    int itemIndex = itemEntity.getItem();
                    double x = itemEntity.getDataset().getX(seriesIndex, itemIndex).doubleValue();
                    double y = itemEntity.getDataset().getY(seriesIndex, itemIndex).doubleValue();

                    String message = String.format("%d, Item: %d, X: %.2f, Y: %.2f", seriesIndex, itemIndex, x, y);
                    JOptionPane.showMessageDialog(null, message);
                }
            }

            @Override
            public void chartMouseMoved(ChartMouseEvent e) {
                // No-op
            }
        });
        yearlyMoviePieChart();
    }

    public void yearlyMoviePieChart() {
        DefaultPieDataset dataset = new AnalysisImp().getYearMovieAnalysisPieChart(cinema_id, genreList, Integer.parseInt(yearBox1.getSelectedItem().toString()), monthList);
        JFreeChart chart = ChartFactory.createPieChart(
                "Genre Income", // chart title
                dataset, // data
                true, // include legend
                true,
                false);
        chart.setBackgroundPaint(Color.WHITE);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setDomainZoomable(true);
        chartPanel.setPreferredSize(new Dimension(120, 420));
        moviePiechartPanel1.setLayout(new BorderLayout());
        moviePiechartPanel1.removeAll();
        moviePiechartPanel1.add(chartPanel, BorderLayout.NORTH);
        moviePiechartPanel1.revalidate();
        moviePiechartPanel1.repaint();
    }

    public void monthlyMovieBarChart() {
        final DefaultCategoryDataset dataset = new AnalysisImp().getMonthGenreMovieAnalysis(cinema_id, genreBox.getSelectedItem().toString(), Integer.parseInt(yearBox2.getSelectedItem().toString()), monthBox2.getSelectedItem().toString());
        JFreeChart chart = ChartFactory.createBarChart(
                "Movie Graph",
                "Movie",
                "Score",
                dataset,
                PlotOrientation.HORIZONTAL, true, true, false);
        chart.setBackgroundPaint(Color.WHITE);
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Set the width of the bars (in pixels)
        renderer.setItemMargin(0.1); // Set the margin between bars
        renderer.setMaximumBarWidth(0.1); // Width of each bar (as a fraction of the category width)

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setDomainZoomable(false);
        chartPanel.setRangeZoomable(false);
        chartPanel.setPreferredSize(new Dimension(120, 420));
        // Update panel layout
        moviePanel2.setLayout(new BorderLayout());
        moviePanel2.removeAll();
        moviePanel2.add(chartPanel, BorderLayout.CENTER);
        moviePanel2.revalidate();
        moviePanel2.repaint();
        chartPanel.addChartMouseListener(new ChartMouseListener() {

            public void chartMouseClicked(ChartMouseEvent e) {
                ChartEntity entity = e.getEntity();
                if (entity instanceof CategoryItemEntity) {
                    CategoryItemEntity itemEntity = (CategoryItemEntity) entity;
                    String seriesKey = itemEntity.getDataset().getRowKey(itemEntity.getSeries()).toString();
                    String categoryKey = itemEntity.getDataset().getColumnKey(itemEntity.getCategoryIndex()).toString();
                    Number value = itemEntity.getDataset().getValue(itemEntity.getSeries(), itemEntity.getCategoryIndex());

                    String message = String.format("Movie: %s, Value: %s", seriesKey, value);
                    JOptionPane.showMessageDialog(null, message);
                } else if (entity instanceof XYItemEntity) {
                    XYItemEntity itemEntity = (XYItemEntity) entity;
                    int seriesIndex = itemEntity.getSeriesIndex();
                    int itemIndex = itemEntity.getItem();
                    double x = itemEntity.getDataset().getX(seriesIndex, itemIndex).doubleValue();
                    double y = itemEntity.getDataset().getY(seriesIndex, itemIndex).doubleValue();

                    String message = String.format("%d, Item: %d, X: %.2f, Y: %.2f", seriesIndex, itemIndex, x, y);
                    JOptionPane.showMessageDialog(null, message);
                }
            }

            public void chartMouseMoved(ChartMouseEvent e) {
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

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        scrollPanel = new javax.swing.JPanel();
        moviePanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        yearBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        yearBox2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        monthBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        genreBox = new javax.swing.JComboBox<>();
        moviePanel2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        branchImage = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        branchField = new javax.swing.JLabel();
        cityField = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        employeeImage = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        employeeCount = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        roomImage = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        roomCount = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        moviePiechartPanel1 = new javax.swing.JPanel();
        refreshBtn = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setMaximumSize(new java.awt.Dimension(932, 639));
        setMinimumSize(new java.awt.Dimension(932, 639));
        setPreferredSize(new java.awt.Dimension(1100, 623));

        scrollPane.setBorder(null);
        scrollPane.setPreferredSize(new java.awt.Dimension(1132, 1502));

        scrollPanel.setPreferredSize(new java.awt.Dimension(1130, 1500));

        moviePanel1.setBackground(new java.awt.Color(255, 255, 255));
        moviePanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        yearBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Year :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(yearBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addComponent(yearBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        yearBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Year :");

        jLabel2.setText("Month :");

        jLabel7.setText("Genre :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel5))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(genreBox, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(12, 12, 12))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(genreBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(monthBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(yearBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        moviePanel2.setBackground(new java.awt.Color(255, 255, 255));
        moviePanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        branchImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        branchImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\logo.png")); // NOI18N
        branchImage.setMaximumSize(new java.awt.Dimension(80, 80));
        branchImage.setMinimumSize(new java.awt.Dimension(80, 80));
        branchImage.setPreferredSize(new java.awt.Dimension(80, 80));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel8.setText("Branch : ");

        branchField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        branchField.setText("0");

        cityField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cityField.setText("Taungoo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(branchImage, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, 0)
                        .addComponent(branchField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cityField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(branchImage, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(branchField))
                        .addGap(18, 18, 18)
                        .addComponent(cityField)
                        .addGap(27, 27, 27))))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        employeeImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        employeeImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\logo.png")); // NOI18N
        employeeImage.setMaximumSize(new java.awt.Dimension(80, 80));
        employeeImage.setMinimumSize(new java.awt.Dimension(80, 80));
        employeeImage.setPreferredSize(new java.awt.Dimension(80, 80));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Employee");

        employeeCount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        employeeCount.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(employeeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeCount, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(employeeCount)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(employeeImage, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        roomImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roomImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\logo.png")); // NOI18N
        roomImage.setMaximumSize(new java.awt.Dimension(80, 80));
        roomImage.setMinimumSize(new java.awt.Dimension(80, 80));
        roomImage.setPreferredSize(new java.awt.Dimension(80, 80));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Room");

        roomCount.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        roomCount.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(roomImage, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(roomCount, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(roomCount)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(roomImage, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Dashboard");

        moviePiechartPanel1.setBackground(new java.awt.Color(255, 255, 255));
        moviePiechartPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scrollPanelLayout = new javax.swing.GroupLayout(scrollPanel);
        scrollPanel.setLayout(scrollPanelLayout);
        scrollPanelLayout.setHorizontalGroup(
            scrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scrollPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(scrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(scrollPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshBtn)
                        .addGap(12, 12, 12))
                    .addGroup(scrollPanelLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(scrollPanelLayout.createSequentialGroup()
                        .addComponent(moviePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(moviePiechartPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(moviePanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        scrollPanelLayout.setVerticalGroup(
            scrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scrollPanelLayout.createSequentialGroup()
                .addGroup(scrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(scrollPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scrollPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(refreshBtn)
                        .addGap(18, 18, 18)))
                .addGroup(scrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(scrollPanelLayout.createSequentialGroup()
                        .addGroup(scrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moviePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(moviePiechartPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moviePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1175, Short.MAX_VALUE))
        );

        scrollPane.setViewportView(scrollPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new Thread(() -> {
            // Simulate a background task
            try {
                Thread.sleep(100); // Simulate a delay
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            yearlyMovieLineChart();
        }).start();


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new Thread(() -> {
            // Simulate a background task
            try {
                Thread.sleep(100); // Simulate a delay
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            monthlyMovieBarChart();
        }).start();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
        new Thread(() -> {
            // Simulate a background task
            try {
                Thread.sleep(100); // Simulate a delay
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            setup();
        }).start();

    }//GEN-LAST:event_refreshBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel branchField;
    private javax.swing.JLabel branchImage;
    private javax.swing.JLabel cityField;
    private javax.swing.JLabel employeeCount;
    private javax.swing.JLabel employeeImage;
    private javax.swing.JComboBox<String> genreBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JComboBox<String> monthBox2;
    private javax.swing.JPanel moviePanel1;
    private javax.swing.JPanel moviePanel2;
    private javax.swing.JPanel moviePiechartPanel1;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JLabel roomCount;
    private javax.swing.JLabel roomImage;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel scrollPanel;
    private javax.swing.JComboBox<String> yearBox1;
    private javax.swing.JComboBox<String> yearBox2;
    // End of variables declaration//GEN-END:variables

}
