package ky_thuat_do_hoa;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Bai3_Bresemham extends JPanel {

    private final ArrayList<Point> points;
    private final int width = 5; 

    public Bai3_Bresemham() {
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
        radius = new javax.swing.JSlider();

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Radius", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        jPanel2.setLayout(new java.awt.BorderLayout());

        radius.setMajorTickSpacing(25);
        radius.setMaximum(300);
        radius.setMinorTickSpacing(5);
        radius.setPaintLabels(true);
        radius.setPaintTicks(true);
        radius.setToolTipText("");
        radius.setValue(150);
        radius.setValueIsAdjusting(true);
        jPanel2.add(radius, java.awt.BorderLayout.PAGE_START);

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
            int radiusValue = radius.getValue();
            showPointArea.append("Radius = " + radiusValue + "\n");
            bresemham(xc, yc, radiusValue);
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
            points.add(new Point(x, y, this.width, Color.RED));
        }
        else {
            points.add(new Point(x, y, 1, Color.RED));
        }
        showPointArea.append("x = " + x + ", y = " + y + "\n");
        this.repaint();
    }    
    
    private void pc(int xc, int yc, int x, int y) {
        addPoint(xc + x, yc + y);
        addPoint(xc - x, yc - y);
        addPoint(xc - x, yc + y);
        addPoint(xc + x, yc - y);
    }
    
    private void bresemham(int xc, int yc, int radiusValue) {
        int y = radiusValue;
        int p = 3 - 2*radiusValue;
        pc(xc, yc, radiusValue, 0);
        for(int x = 0 ; x < y ; x++) {
            if(p < 0) p += 4*x+6;
            else {
                p += 4*(x-y)+10;
                y--;
            }
            pc(xc, yc, x, y);
            pc(xc, yc, y, x);
        }
        pc(xc, yc, y, y);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider radius;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextArea showPointArea;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}