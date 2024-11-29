/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.AnalysisImp;
import Controller.SharedData;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

/**
 *
 * @author DELL
 */
public class AnalysisPanel extends javax.swing.JPanel {

    /**
     * Creates new form AnalysisPanel
     */
    private String[] genreList;
    private String[] monthList;
    private int cinema_id;

    public AnalysisPanel() {
        initComponents();

        SharedData sharedData = SharedData.getInstance();
        cinema_id = sharedData.getCinema_id();
        genreList = sharedData.getGenreList();
        monthList = sharedData.getMonthList();
        monthBox3.addItem("All");
        for (int i = 0; i < monthList.length; i++) {
            monthBox3.addItem(monthList[i]);
        }
        LocalDate date = LocalDate.parse(LocalDate.now().toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //String getMonthName = date.getMonth().name().toLowerCase();
        int getYear = date.getYear();
        for (int i = 0; i < yearBox1.getItemCount(); i++) {
            int setYear = Integer.parseInt(yearBox1.getItemAt(i));
            if (setYear == getYear) {
                yearBox1.setSelectedIndex(i);
                yearBox3.setSelectedIndex(i);
                break;
            }
        }
        new Thread(() -> {
            // Simulate a background task
            try {
                Thread.sleep(1500); // Simulate a delay
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            try {
                yearlyProfitBarChart();
                incomeBarChart(monthList);
                outcomeBarChart(monthList);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();

    }

    public void yearlyProfitBarChart() {

        final DefaultCategoryDataset dataset = new AnalysisImp().getCinemaProfitAnalysis(cinema_id, Integer.parseInt(yearBox1.getSelectedItem().toString()), monthList);
        JFreeChart chart = ChartFactory.createBarChart(
                "Profit Graph",
                "Month",
                "Score",
                dataset,
                PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.WHITE);
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Set the width of the bars (in pixels)
        renderer.setItemMargin(0.1); // Set the margin between bars
        renderer.setMaximumBarWidth(0.1);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setDomainZoomable(false);
        chartPanel.setRangeZoomable(false);

        // Update panel layout
        profitPanel1.setLayout(new BorderLayout());
        profitPanel1.removeAll();
        profitPanel1.add(chartPanel, BorderLayout.CENTER);
        profitPanel1.revalidate();
        profitPanel1.repaint();
        chartPanel.addChartMouseListener(new ChartMouseListener() {

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

        scrollPane = new javax.swing.JScrollPane();
        scrollPanel = new javax.swing.JPanel();
        profitPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        yearBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        yearBox3 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        monthBox3 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        incomePanel = new javax.swing.JPanel();
        outcomePanel = new javax.swing.JPanel();

        profitPanel1.setBackground(new java.awt.Color(255, 255, 255));
        profitPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Analysis");

        yearBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Year :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 702, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(yearBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jButton3.setText("OK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        yearBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));

        jLabel8.setText("Year :");

        jLabel9.setText("Month :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(yearBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(30, 30, 30))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(yearBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(monthBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        incomePanel.setBackground(new java.awt.Color(255, 255, 255));
        incomePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        outcomePanel.setBackground(new java.awt.Color(255, 255, 255));
        outcomePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout scrollPanelLayout = new javax.swing.GroupLayout(scrollPanel);
        scrollPanel.setLayout(scrollPanelLayout);
        scrollPanelLayout.setHorizontalGroup(
            scrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scrollPanelLayout.createSequentialGroup()
                .addGroup(scrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 60, Short.MAX_VALUE))
            .addGroup(scrollPanelLayout.createSequentialGroup()
                .addGroup(scrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(scrollPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(profitPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1010, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(scrollPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(incomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(outcomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        scrollPanelLayout.setVerticalGroup(
            scrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scrollPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(profitPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(scrollPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(incomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outcomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 1366, Short.MAX_VALUE))
        );

        scrollPane.setViewportView(scrollPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPane)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
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

            yearlyProfitBarChart();
        }).start();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new Thread(() -> {
            // Simulate a background task
            try {
                Thread.sleep(100); // Simulate a delay
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            if (monthBox3.getSelectedItem().equals("All")) {
                incomeBarChart(monthList);
                outcomeBarChart(monthList);
            } else {
                String[] month = {monthBox3.getSelectedItem().toString()};
                incomeBarChart(month);
                outcomeBarChart(month);
            }
        }).start();

    }//GEN-LAST:event_jButton3ActionPerformed
    public void incomeBarChart(String[] monthList) {

        final DefaultCategoryDataset dataset = new AnalysisImp().getOnlyCinemaAnalysis(cinema_id, genreList, Integer.parseInt(yearBox3.getSelectedItem().toString()), monthList);
        JFreeChart chart = ChartFactory.createBarChart(
                "Income Graph",
                "Genre",
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

        // Update panel layout
        incomePanel.setLayout(new BorderLayout());
        incomePanel.removeAll();
        incomePanel.add(chartPanel, BorderLayout.CENTER);
        incomePanel.revalidate();
        incomePanel.repaint();
        chartPanel.addChartMouseListener(new ChartMouseListener() {

            public void chartMouseClicked(ChartMouseEvent e) {
                ChartEntity entity = e.getEntity();
                if (entity instanceof CategoryItemEntity) {
                    CategoryItemEntity itemEntity = (CategoryItemEntity) entity;
                    String seriesKey = itemEntity.getDataset().getRowKey(itemEntity.getSeries()).toString();
                    String categoryKey = itemEntity.getDataset().getColumnKey(itemEntity.getCategoryIndex()).toString();
                    Number value = itemEntity.getDataset().getValue(itemEntity.getSeries(), itemEntity.getCategoryIndex());

                    String message = String.format("Genre: %s, Value: %s", seriesKey, value);
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

    public void outcomeBarChart(String[] monthList) {

        final DefaultCategoryDataset dataset = new AnalysisImp().getOnlyExpenseAnalysis(cinema_id, Integer.parseInt(yearBox3.getSelectedItem().toString()), monthList);
        JFreeChart chart = ChartFactory.createBarChart(
                "Outcome Graph",
                "Category",
                "Score",
                dataset,
                PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.WHITE);
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Set the width of the bars (in pixels)
        renderer.setItemMargin(0.1); // Set the margin between bars
        renderer.setMaximumBarWidth(0.2);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setDomainZoomable(false);
        chartPanel.setRangeZoomable(false);

        // Update panel layout
        outcomePanel.setLayout(new BorderLayout());
        outcomePanel.removeAll();
        outcomePanel.add(chartPanel, BorderLayout.CENTER);
        outcomePanel.revalidate();
        outcomePanel.repaint();
        chartPanel.addChartMouseListener(new ChartMouseListener() {

            public void chartMouseClicked(ChartMouseEvent e) {
                ChartEntity entity = e.getEntity();
                if (entity instanceof CategoryItemEntity) {
                    CategoryItemEntity itemEntity = (CategoryItemEntity) entity;
                    String seriesKey = itemEntity.getDataset().getRowKey(itemEntity.getSeries()).toString();
                    String categoryKey = itemEntity.getDataset().getColumnKey(itemEntity.getCategoryIndex()).toString();
                    Number value = itemEntity.getDataset().getValue(itemEntity.getSeries(), itemEntity.getCategoryIndex());

                    String message = String.format("%s, Value: %s", seriesKey, value);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel incomePanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox<String> monthBox3;
    private javax.swing.JPanel outcomePanel;
    private javax.swing.JPanel profitPanel1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel scrollPanel;
    private javax.swing.JComboBox<String> yearBox1;
    private javax.swing.JComboBox<String> yearBox3;
    // End of variables declaration//GEN-END:variables

}
