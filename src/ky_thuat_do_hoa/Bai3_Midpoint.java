package ky_thuat_do_hoa;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Bai3_Midpoint extends JPanel {

    private ArrayList<Point> listPoint;
    private Color c = Color.red;
    private int width = 5;
    private int radius;

    public Bai3_Midpoint() {
        initComponents();
        
        listPoint = new ArrayList<>();
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
        slider = new javax.swing.JSlider();

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

        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        add(slider, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        if (listPoint.isEmpty()) {
            this.addPoint(new Point(evt.getX(), evt.getY(), width, c));
        }
    }//GEN-LAST:event_formMouseClicked

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        this.radius = this.slider.getValue();
        showPointArea.append("Bán kính: " + radius + "\n");
        this.midPoint();
    }//GEN-LAST:event_startButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        listPoint.clear();
        showPointArea.setText("");
        this.repaint();
    }//GEN-LAST:event_resetButtonActionPerformed

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        listPoint.forEach(p -> {
            p.draw(g);
        });
    }

    private void midPoint() {
        int x = 0;
        int y = radius;
        int xc = listPoint.get(0).getX();
        int yc = listPoint.get(0).getY();
        double d = 5/4 - radius;
        while(x <= y) {
            pc(xc, yc, x, y);
            pc(xc, yc, y, x);
            if(d < 0) {
                d += 2 * x + 3;
            } else {
                d += 2 * (x - y) + 5;
                y -= width - 1;
            }
            x += width - 1;
        }
    }
    
    private void pc(int xc, int yc, int x, int y) {
        this.addPoint(new Point(xc + x, yc + y, width, c));
        this.addPoint(new Point(xc - x, yc - y, width, c));
        this.addPoint(new Point(xc - y, yc + x, width, c));
        this.addPoint(new Point(xc + y, yc - x, width, c));
    }

    private void addPoint(Point p) {
        if (listPoint.isEmpty()) {
            showPointArea.append("Tâm: ");
            
            listPoint.add(p);
        } else {
            listPoint.add(p);
        }
        showPointArea.append("x = " + p.getX() + ", y = " + p.getY() + "\n");
        this.repaint();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controller;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextArea showPointArea;
    private javax.swing.JSlider slider;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
