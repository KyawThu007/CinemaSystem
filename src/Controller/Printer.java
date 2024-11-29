/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author DELL
 */
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.*;

public class Printer {

    public void printPanel(JPanel panel) {
        // Convert the JPanel to an image
        BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        panel.printAll(g2d);
        g2d.dispose();

        // Create a Printable implementation
        Printable printable = (Graphics g, PageFormat format, int pageIndex) -> {
            if (pageIndex > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            Graphics2D g2d2 = (Graphics2D) g;
            g2d2.translate(format.getImageableX(), format.getImageableY());
            // Center the image on the page
            double imageWidth = image.getWidth();
            double imageHeight = image.getHeight();
            double pageWidth = format.getImageableWidth();
            double pageHeight = format.getImageableHeight();

            double x = (pageWidth - imageWidth) / 2;
            double y = (pageHeight - imageHeight) / 2;

            g2d2.drawImage(image, (int) x, (int) y, null);
            return Printable.PAGE_EXISTS;
        };

        // Setup the print job
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(printable);

        boolean doPrint = job.printDialog(); // Show print dialog to user

        if (doPrint) {
            try {
                job.print(); // Print the document
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }
}
