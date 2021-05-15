package ky_thuat_do_hoa;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Bai4_Midpoint extends JPanel {

    private final ArrayList<Point> points;
    private int width = 1;
    
    public Bai4_Midpoint() {
        initComponents();
        points = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        showPointArea = new javax.swing.JTextArea();
        controller = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        radiusX = new javax.swing.JSlider();
        jPanel4 = new javax.swing.JPanel();
        radiusY = new javax.swing.JSlider();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Points", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        showPointArea.setEditable(false);
        showPointArea.setColumns(20);
        showPointArea.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        showPointArea.setRows(5);
        showPointArea.setOpaque(false);
        jScrollPane1.setViewportView(showPointArea);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.LINE_START);

        controller.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controller", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        controller.add(startButton);

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        controller.add(resetButton);

        jPanel1.add(controller, java.awt.BorderLayout.PAGE_END);

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RadiusX", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());

        radiusX.setMajorTickSpacing(25);
        radiusX.setMaximum(300);
        radiusX.setMinorTickSpacing(5);
        radiusX.setPaintLabels(true);
        radiusX.setPaintTicks(true);
        radiusX.setToolTipText("");
        radiusX.setValue(150);
        radiusX.setValueIsAdjusting(true);
        jPanel3.add(radiusX, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RadiusY", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jPanel4.setLayout(new java.awt.BorderLayout());

        radiusY.setMajorTickSpacing(25);
        radiusY.setMaximum(300);
        radiusY.setMinorTickSpacing(5);
        radiusY.setPaintLabels(true);
        radiusY.setPaintTicks(true);
        radiusY.setToolTipText("");
        radiusY.setValue(150);
        radiusY.setValueIsAdjusting(true);
        jPanel4.add(radiusY, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(points.isEmpty())
            addPoint(evt.getX(), evt.getY());
    }//GEN-LAST:event_formMouseClicked

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        if(points.size() == 1) {
            int xc = points.get(0).getX();
            int yc = points.get(0).getY();
            int radiusXvalue = radiusX.getValue();
            int radiusYvalue = radiusY.getValue();
            showPointArea.append("RadiusX = " + radiusXvalue + "\n");
            showPointArea.append("RadiusY = " + radiusYvalue + "\n");
            midpoint(xc, yc, radiusXvalue, radiusYvalue);
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        points.clear();
        showPointArea.setText("");
        this.repaint();
    }//GEN-LAST:event_resetButtonActionPerformed

    private void addPoint(int x, int y) {
        if(points.isEmpty()) {
            showPointArea.append("Center: ");
            points.add(new Point(x, y, 5, Color.RED));
        } else {
            points.add(new Point(x, y, width, Color.RED));
        }
        
        showPointArea.append("x = " + x + ", y = " + y + "\n");
        this.repaint();
    }    
    
    private void pc(int xc, int yc, int x, int y) {
        addPoint(xc + x, yc + y);
        addPoint(xc - x, yc + y);
        addPoint(xc + x, yc - y);
        addPoint(xc - x, yc - y);
    }
    
    private int round(double n) {
        return (int) (n + 0.5);
    }
    
    private void midpoint(int xCenter, int yCenter, int radiusX, int radiusY) {
        int x = 0;
        int y = radiusY;
        int a2 = radiusX * radiusX;
        int b2 = radiusY * radiusY;
        int fx = 0;
        int fy = 2 * a2 * y;
        int p = round(b2 - (a2 * radiusY) + (0.25 * radiusX));
        pc(xCenter, yCenter, x, y);
        while(fx < fy) {
            x += width;
            fx += 2 * b2;
            if(p < 0) {
                p += b2 * (2 * x + 3);
            } else {
                y -= width;
                p += b2 * (2 * x + 3) + a2 * (-2 * y + 2);
                fy -= 2 * a2;
            }
            pc(xCenter, yCenter, x, y);
        }
        
        p = round(b2 * (x + 0.5) * (x + 0.5) + a2 * (y - 1) * (y - 1) - a2 * b2);
        while(y > 0) {
            y -= width;
            fy -= 2 * a2;
            if(p >= 0) {
                p += a2 * (3 - 2 * y);
            } else {
                x += width;
                fx += 2 * b2;
                p += b2 * (2 * x + 2) + a2 * (-2 * y + 3);
            }
            pc(xCenter, yCenter, x, y);
        }
    }   
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        points.forEach(p -> {
            p.draw(g);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controller;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider radiusX;
    private javax.swing.JSlider radiusY;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextArea showPointArea;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}