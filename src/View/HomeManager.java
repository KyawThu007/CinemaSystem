/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author DELL
 */
public class HomeManager extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    private CardLayout cardLayout = null;
    private boolean flag = false;
    private static final int FADE_DURATION = 100; // Duration of the fade effect in milliseconds
    private static final int FADE_STEPS = 20; // Number of steps in the fade effect

    public HomeManager() {
        initComponents();

        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("C://Users//DELL//Desktop//logo.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Scale the image
        Image scaledImage = bufferedImage.getScaledInstance(190, 190, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(imageIcon);

        this.setLocationRelativeTo(null);
        cardLayout = new CardLayout();
        panelChange.setLayout(cardLayout);

        // Create Dashboard Panel
        panelChange.add(new DashboardPanel(), "DashboardPanel");
        // Create Show Panel
        panelChange.add(new ShowPanel(), "ShowPanel");
        // Create Recipt Panel
        panelChange.add(new TicketPanel(), "TicketPanel");
        // Create Movie Panel
        panelChange.add(new MoviePanel(), "MoviePanel");
        // Create Room Panel
        panelChange.add(new RoomPanel(), "RoomPanel");
        // Create Employee Panel
        panelChange.add(new EmployeePanel(), "EmployeePanel");
        // Create Salary Panel
        panelChange.add(new SalaryPanel(), "SalaryPanel");
        // Create Expense Panel
        panelChange.add(new ExpensePanel(), "ExpensePanel");
        // Create Analysis Panel
        panelChange.add(new AnalysisPanel(), "AnalysisPanel");

        startFadeEffect(dashboardBtn);
        dashboardBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startFadeEffect(dashboardBtn);
                cardLayout.show(panelChange, "DashboardPanel");
                panelBackground(showBtn);
                panelBackground(ticketBtn);
                panelBackground(movieBtn);
                panelBackground(roomBtn);
                panelBackground(employeeBtn);
                panelBackground(salaryBtn);
                panelBackground(expenseBtn);
                panelBackground(analysisBtn);
                panelBackground(counterBtn);
            }
        });
        showBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startFadeEffect(showBtn);
                cardLayout.show(panelChange, "ShowPanel");
                panelBackground(dashboardBtn);
                panelBackground(ticketBtn);
                panelBackground(movieBtn);
                panelBackground(roomBtn);
                panelBackground(employeeBtn);
                panelBackground(salaryBtn);
                panelBackground(expenseBtn);
                panelBackground(analysisBtn);
                panelBackground(counterBtn);
            }
        });
        ticketBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startFadeEffect(ticketBtn);
                cardLayout.show(panelChange, "TicketPanel");
                panelBackground(dashboardBtn);
                panelBackground(showBtn);
                panelBackground(movieBtn);
                panelBackground(roomBtn);
                panelBackground(employeeBtn);
                panelBackground(salaryBtn);
                panelBackground(expenseBtn);
                panelBackground(analysisBtn);
                panelBackground(counterBtn);
            }
        });
        movieBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startFadeEffect(movieBtn);
                cardLayout.show(panelChange, "MoviePanel");
                panelBackground(dashboardBtn);
                panelBackground(showBtn);
                panelBackground(ticketBtn);
                panelBackground(roomBtn);
                panelBackground(employeeBtn);
                panelBackground(salaryBtn);
                panelBackground(expenseBtn);
                panelBackground(analysisBtn);
                panelBackground(counterBtn);
            }
        });
        roomBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startFadeEffect(roomBtn);
                cardLayout.show(panelChange, "RoomPanel");
                panelBackground(dashboardBtn);
                panelBackground(showBtn);
                panelBackground(ticketBtn);
                panelBackground(movieBtn);
                panelBackground(employeeBtn);
                panelBackground(salaryBtn);
                panelBackground(expenseBtn);
                panelBackground(analysisBtn);
                panelBackground(counterBtn);
            }
        });
        employeeBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startFadeEffect(employeeBtn);
                cardLayout.show(panelChange, "EmployeePanel");
                panelBackground(dashboardBtn);
                panelBackground(showBtn);
                panelBackground(ticketBtn);
                panelBackground(movieBtn);
                panelBackground(roomBtn);
                panelBackground(salaryBtn);
                panelBackground(expenseBtn);
                panelBackground(analysisBtn);
                panelBackground(counterBtn);
            }
        });
        salaryBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startFadeEffect(salaryBtn);
                cardLayout.show(panelChange, "SalaryPanel");
                panelBackground(dashboardBtn);
                panelBackground(showBtn);
                panelBackground(ticketBtn);
                panelBackground(movieBtn);
                panelBackground(roomBtn);
                panelBackground(employeeBtn);
                panelBackground(expenseBtn);
                panelBackground(analysisBtn);
                panelBackground(counterBtn);
            }
        });
        expenseBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startFadeEffect(expenseBtn);
                cardLayout.show(panelChange, "ExpensePanel");
                panelBackground(dashboardBtn);
                panelBackground(showBtn);
                panelBackground(ticketBtn);
                panelBackground(movieBtn);
                panelBackground(roomBtn);
                panelBackground(employeeBtn);
                panelBackground(salaryBtn);
                panelBackground(analysisBtn);
                panelBackground(counterBtn);
            }
        });
        analysisBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                startFadeEffect(analysisBtn);
                cardLayout.show(panelChange, "AnalysisPanel");
                panelBackground(dashboardBtn);
                panelBackground(showBtn);
                panelBackground(ticketBtn);
                panelBackground(movieBtn);
                panelBackground(roomBtn);
                panelBackground(employeeBtn);
                panelBackground(salaryBtn);
                panelBackground(expenseBtn);
                panelBackground(counterBtn);
            }
        });
        counterBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (flag) {
                    flag = false;
                } else {
                    startFadeEffect(counterBtn);
                    panelBackground(dashboardBtn);
                    panelBackground(showBtn);
                    panelBackground(ticketBtn);
                    panelBackground(movieBtn);
                    panelBackground(roomBtn);
                    panelBackground(employeeBtn);
                    panelBackground(salaryBtn);
                    panelBackground(expenseBtn);
                    panelBackground(analysisBtn);
                    new LoginForm().setVisible(true);
                    flag = true;
                }
            }
        });
        imageSetup(dashboardImage, "C://Users/DELL/Downloads/dashboard.png");
        imageSetup(showImage, "C://Users/DELL/Downloads/cinema.png");
        imageSetup(ticketImage, "C://Users/DELL/Downloads/ticket.png");
        imageSetup(movieImage, "C://Users/DELL/Downloads/movie.png");
        imageSetup(roomImage, "C://Users/DELL/Downloads/room.png");
        imageSetup(employeeImage, "C://Users/DELL/Downloads/employee.png");
        imageSetup(salaryImage, "C://Users/DELL/Downloads/salary.png");
        imageSetup(expenseImage, "C://Users/DELL/Downloads/expense.png");
        imageSetup(analysisImage, "C://Users/DELL/Downloads/analysis.png");
        imageSetup(counterImage, "C://Users/DELL/Downloads/counter.png");
    }

    public void imageSetup(JLabel imageLabel, String file) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(file));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Scale the image
        Image scaledImage = bufferedImage.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(imageIcon);

    }

    public void panelBackground(JPanel jpanel) {
        jpanel.setBackground(new Color(204, 204, 204));
    }

    private void startFadeEffect(JPanel panel) {
        final Color originalColor = panel.getBackground();
        final Color targetColor = Color.LIGHT_GRAY; // The color to fade to

        Timer timer = new Timer(FADE_DURATION / FADE_STEPS, new ActionListener() {
            private int step = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                // Calculate the new color
                float progress = (float) step / FADE_STEPS;
                int red = (int) (originalColor.getRed() + progress * (targetColor.getRed() - originalColor.getRed()));
                int green = (int) (originalColor.getGreen() + progress * (targetColor.getGreen() - originalColor.getGreen()));
                int blue = (int) (originalColor.getBlue() + progress * (targetColor.getBlue() - originalColor.getBlue()));
                panel.setBackground(new Color(red, green, blue));

                // Increment step and check if fade is complete
                step++;
                if (step > FADE_STEPS) {
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
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
        imageLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        dashboardBtn = new javax.swing.JPanel();
        dashboardImage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        showBtn = new javax.swing.JPanel();
        showImage = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ticketBtn = new javax.swing.JPanel();
        ticketImage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        movieBtn = new javax.swing.JPanel();
        movieImage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        roomBtn = new javax.swing.JPanel();
        roomImage = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        employeeBtn = new javax.swing.JPanel();
        employeeImage = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        analysisBtn = new javax.swing.JPanel();
        analysisImage = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        counterBtn = new javax.swing.JPanel();
        counterImage = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        expenseBtn = new javax.swing.JPanel();
        expenseImage = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        salaryBtn = new javax.swing.JPanel();
        salaryImage = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelChange = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(102, 102, 102));

        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\logo.png")); // NOI18N
        imageLabel.setMaximumSize(new java.awt.Dimension(80, 80));
        imageLabel.setMinimumSize(new java.awt.Dimension(80, 80));
        imageLabel.setPreferredSize(new java.awt.Dimension(80, 80));

        jScrollPane1.setBackground(new java.awt.Color(0, 102, 102));
        jScrollPane1.setBorder(null);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        dashboardBtn.setBackground(new java.awt.Color(204, 204, 204));

        dashboardImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboardImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\logo.png")); // NOI18N
        dashboardImage.setMaximumSize(new java.awt.Dimension(80, 80));
        dashboardImage.setMinimumSize(new java.awt.Dimension(80, 80));
        dashboardImage.setPreferredSize(new java.awt.Dimension(80, 80));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Dashboard");

        javax.swing.GroupLayout dashboardBtnLayout = new javax.swing.GroupLayout(dashboardBtn);
        dashboardBtn.setLayout(dashboardBtnLayout);
        dashboardBtnLayout.setHorizontalGroup(
            dashboardBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardBtnLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(dashboardImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        dashboardBtnLayout.setVerticalGroup(
            dashboardBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardBtnLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(dashboardImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(dashboardBtnLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        showBtn.setBackground(new java.awt.Color(204, 204, 204));

        showImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\logo.png")); // NOI18N
        showImage.setMaximumSize(new java.awt.Dimension(80, 80));
        showImage.setMinimumSize(new java.awt.Dimension(80, 80));
        showImage.setPreferredSize(new java.awt.Dimension(80, 80));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Show");

        javax.swing.GroupLayout showBtnLayout = new javax.swing.GroupLayout(showBtn);
        showBtn.setLayout(showBtnLayout);
        showBtnLayout.setHorizontalGroup(
            showBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showBtnLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(showImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        showBtnLayout.setVerticalGroup(
            showBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(showBtnLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(showImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(showBtnLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ticketBtn.setBackground(new java.awt.Color(204, 204, 204));

        ticketImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ticketImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\logo.png")); // NOI18N
        ticketImage.setMaximumSize(new java.awt.Dimension(80, 80));
        ticketImage.setMinimumSize(new java.awt.Dimension(80, 80));
        ticketImage.setPreferredSize(new java.awt.Dimension(80, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Ticket");

        javax.swing.GroupLayout ticketBtnLayout = new javax.swing.GroupLayout(ticketBtn);
        ticketBtn.setLayout(ticketBtnLayout);
        ticketBtnLayout.setHorizontalGroup(
            ticketBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ticketBtnLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(ticketImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ticketBtnLayout.setVerticalGroup(
            ticketBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ticketBtnLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(ticketImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(ticketBtnLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        movieBtn.setBackground(new java.awt.Color(204, 204, 204));

        movieImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        movieImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\logo.png")); // NOI18N
        movieImage.setMaximumSize(new java.awt.Dimension(80, 80));
        movieImage.setMinimumSize(new java.awt.Dimension(80, 80));
        movieImage.setPreferredSize(new java.awt.Dimension(80, 80));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Movie");

        javax.swing.GroupLayout movieBtnLayout = new javax.swing.GroupLayout(movieBtn);
        movieBtn.setLayout(movieBtnLayout);
        movieBtnLayout.setHorizontalGroup(
            movieBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(movieBtnLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(movieImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        movieBtnLayout.setVerticalGroup(
            movieBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(movieBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(movieImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(movieBtnLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roomBtn.setBackground(new java.awt.Color(204, 204, 204));

        roomImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roomImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\logo.png")); // NOI18N
        roomImage.setMaximumSize(new java.awt.Dimension(80, 80));
        roomImage.setMinimumSize(new java.awt.Dimension(80, 80));
        roomImage.setPreferredSize(new java.awt.Dimension(80, 80));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Room");

        javax.swing.GroupLayout roomBtnLayout = new javax.swing.GroupLayout(roomBtn);
        roomBtn.setLayout(roomBtnLayout);
        roomBtnLayout.setHorizontalGroup(
            roomBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomBtnLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(roomImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        roomBtnLayout.setVerticalGroup(
            roomBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(roomImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(roomBtnLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        employeeBtn.setBackground(new java.awt.Color(204, 204, 204));

        employeeImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        employeeImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\logo.png")); // NOI18N
        employeeImage.setMaximumSize(new java.awt.Dimension(80, 80));
        employeeImage.setMinimumSize(new java.awt.Dimension(80, 80));
        employeeImage.setPreferredSize(new java.awt.Dimension(80, 80));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Employee");

        javax.swing.GroupLayout employeeBtnLayout = new javax.swing.GroupLayout(employeeBtn);
        employeeBtn.setLayout(employeeBtnLayout);
        employeeBtnLayout.setHorizontalGroup(
            employeeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeBtnLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(employeeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        employeeBtnLayout.setVerticalGroup(
            employeeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(employeeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(employeeBtnLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        analysisBtn.setBackground(new java.awt.Color(204, 204, 204));

        analysisImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        analysisImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\logo.png")); // NOI18N
        analysisImage.setMaximumSize(new java.awt.Dimension(80, 80));
        analysisImage.setMinimumSize(new java.awt.Dimension(80, 80));
        analysisImage.setPreferredSize(new java.awt.Dimension(80, 80));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Analysis");

        javax.swing.GroupLayout analysisBtnLayout = new javax.swing.GroupLayout(analysisBtn);
        analysisBtn.setLayout(analysisBtnLayout);
        analysisBtnLayout.setHorizontalGroup(
            analysisBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(analysisBtnLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(analysisImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        analysisBtnLayout.setVerticalGroup(
            analysisBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(analysisBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(analysisImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(analysisBtnLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        counterBtn.setBackground(new java.awt.Color(204, 204, 204));

        counterImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        counterImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\logo.png")); // NOI18N
        counterImage.setMaximumSize(new java.awt.Dimension(80, 80));
        counterImage.setMinimumSize(new java.awt.Dimension(80, 80));
        counterImage.setPreferredSize(new java.awt.Dimension(80, 80));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Counter");

        javax.swing.GroupLayout counterBtnLayout = new javax.swing.GroupLayout(counterBtn);
        counterBtn.setLayout(counterBtnLayout);
        counterBtnLayout.setHorizontalGroup(
            counterBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(counterBtnLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(counterImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        counterBtnLayout.setVerticalGroup(
            counterBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(counterBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(counterImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(counterBtnLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        expenseBtn.setBackground(new java.awt.Color(204, 204, 204));

        expenseImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expenseImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\logo.png")); // NOI18N
        expenseImage.setMaximumSize(new java.awt.Dimension(80, 80));
        expenseImage.setMinimumSize(new java.awt.Dimension(80, 80));
        expenseImage.setPreferredSize(new java.awt.Dimension(80, 80));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Expense");

        javax.swing.GroupLayout expenseBtnLayout = new javax.swing.GroupLayout(expenseBtn);
        expenseBtn.setLayout(expenseBtnLayout);
        expenseBtnLayout.setHorizontalGroup(
            expenseBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expenseBtnLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(expenseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        expenseBtnLayout.setVerticalGroup(
            expenseBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(expenseBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(expenseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(expenseBtnLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        salaryBtn.setBackground(new java.awt.Color(204, 204, 204));

        salaryImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salaryImage.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Desktop\\logo.png")); // NOI18N
        salaryImage.setMaximumSize(new java.awt.Dimension(80, 80));
        salaryImage.setMinimumSize(new java.awt.Dimension(80, 80));
        salaryImage.setPreferredSize(new java.awt.Dimension(80, 80));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Salary");

        javax.swing.GroupLayout salaryBtnLayout = new javax.swing.GroupLayout(salaryBtn);
        salaryBtn.setLayout(salaryBtnLayout);
        salaryBtnLayout.setHorizontalGroup(
            salaryBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salaryBtnLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(salaryImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        salaryBtnLayout.setVerticalGroup(
            salaryBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salaryBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salaryImage, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(salaryBtnLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(counterBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(analysisBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(expenseBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salaryBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(roomBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(movieBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(dashboardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(showBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ticketBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(dashboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ticketBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(movieBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roomBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salaryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expenseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(analysisBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(counterBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(500, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane1)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.getAccessibleContext().setAccessibleDescription("");

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setBackground(new java.awt.Color(0, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Cinema Management System");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(382, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap(383, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(23, 23, 23))
        );

        panelChange.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelChange.setPreferredSize(new java.awt.Dimension(1100, 623));

        javax.swing.GroupLayout panelChangeLayout = new javax.swing.GroupLayout(panelChange);
        panelChange.setLayout(panelChangeLayout);
        panelChangeLayout.setHorizontalGroup(
            panelChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelChangeLayout.setVerticalGroup(
            panelChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelChange, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(panelChange, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeManager().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel analysisBtn;
    private javax.swing.JLabel analysisImage;
    private javax.swing.JPanel counterBtn;
    private javax.swing.JLabel counterImage;
    private javax.swing.JPanel dashboardBtn;
    private javax.swing.JLabel dashboardImage;
    private javax.swing.JPanel employeeBtn;
    private javax.swing.JLabel employeeImage;
    private javax.swing.JPanel expenseBtn;
    private javax.swing.JLabel expenseImage;
    private javax.swing.JLabel imageLabel;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel movieBtn;
    private javax.swing.JLabel movieImage;
    private javax.swing.JPanel panelChange;
    private javax.swing.JPanel roomBtn;
    private javax.swing.JLabel roomImage;
    private javax.swing.JPanel salaryBtn;
    private javax.swing.JLabel salaryImage;
    private javax.swing.JPanel showBtn;
    private javax.swing.JLabel showImage;
    private javax.swing.JPanel ticketBtn;
    private javax.swing.JLabel ticketImage;
    // End of variables declaration//GEN-END:variables
}
