package ky_thuat_do_hoa;

import java.awt.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Bai2 extends JPanel implements Runnable {

    private ArrayList<Point> listPoint;
    private Thread thread;

    public Bai2() {
        initComponents();
        listPoint = new ArrayList<>();
        thread = new Thread();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        showPointArea = new javax.swing.JTextArea();
        controller = new javax.swing.JPanel();
        startButton = new javax.swing.JButton();
        quickButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();

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

        quickButton.setText("Quick");
        controller.add(quickButton);

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        controller.add(resetButton);

        jPanel1.add(controller, java.awt.BorderLayout.PAGE_END);

        add(jPanel1, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        if (listPoint.isEmpty()) {
            listPoint.add(new Point(evt.getX(), evt.getY(), 5, Color.red));
            showPointArea.append("Start point: x = " + evt.getX() + ", y = " + evt.getY() + "\n");
            this.repaint();

        } else if (listPoint.size() == 1) {
            listPoint.add(new Point(evt.getX(), evt.getY(), 5, Color.red));
            showPointArea.append("End point: x = " + evt.getX() + ", y = " + evt.getY() + "\n");
            this.repaint();
        }
    }//GEN-LAST:event_formMouseClicked

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
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
        int x = listPoint.get(0).getX();
        int y = listPoint.get(0).getY();
        int x2 = listPoint.get(1).getX();
        int dx = x2 - x;
        int dy = listPoint.get(1).getY() - y;
        double d = dy - dx / 2;
        while (x < x2) {
            if (d <= 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Bai2.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.addPoint(new Point(x++, y, 5, Color.red));
                d += dy;
            } else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Bai2.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.addPoint(new Point(x++, y++, 5, Color.red));
                d = d + dy - dx;
            }
        }
    }

    private void addPoint(Point p) {
        listPoint.add(new Point(p.getX(), p.getY(), 5, Color.red));
        showPointArea.append("x = " + p.getX() + ", y = " + p.getY() + "\n");
        this.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controller;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton quickButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JTextArea showPointArea;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            Thread.sleep(10);
            this.repaint();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
