package ky_thuat_do_hoa;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Bai3_Midpoint extends JPanel {

    private ArrayList<Point> listPoint;
    private Point a, b;

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
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        if (a == null) {
            a = new Point(evt.getX(), evt.getY(), 5, Color.red);
            this.addPoint(a);

        } else if (b == null) {
            b = new Point(evt.getX(), evt.getY(), 5, Color.red);
            this.addPoint(b);
        }
    }//GEN-LAST:event_formMouseClicked

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        while (listPoint.size() == 2) {
            double dx = b.getX() - a.getX();
            double dy = b.getY() - a.getY();
            double k = dy / dx;
            System.out.println(k);
            showPointArea.append("k = " + k + "\n");
            if (0 < k && k < 1 || -1 < k && k < 0) {
                if (a.getX() > b.getX()) {
                    this.midPoint(b, a, k);
                } else {
                    this.midPoint(a, b, k);
                }
            } else if (k > 1 || k < -1) {
                if (a.getY() > b.getY()) {
                    this.midPoint(b, a, k);
                } else {
                    this.midPoint(a, b, k);
                }
            }
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        listPoint.clear();
        a = null;
        b = null;
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

    private void midPoint(Point st, Point end, double k) {

        double dx = end.getX() - st.getX();
        double dy = end.getY() - st.getY();

        if (0 < k && k < 1) {
            int y = st.getY();
            double d = dy - dx / 2;
            for (int x = st.getX() + 1; x < end.getX(); x++) {
                if (d <= 0) {
                    d += dy;
                } else {
                    y++;
                    d = d + dy - dx;
                }
                this.addPoint(new Point(x, y, 5, Color.red));
            }
        } else if (-1 < k && k < 0) {
            int y = st.getY();
            double d = dy + dx / 2;
            for (int x = st.getX() + 1; x < end.getX(); x++) {
                if (d >= 0) {
                    d += dy;

                } else {
                    y--;
                    d += dy + dx;
                }
                this.addPoint(new Point(x, y, 5, Color.red));
            }
        } else if (k > 1) {
            int x = st.getX();
            double d = dy / 2 - dx;
            for (int y = st.getY(); y < end.getY(); y++) {
                if (d >= 0) {
                    d -= dx;

                } else {
                    x++;
                    d += dy - dx;
                }
                this.addPoint(new Point(x, y, 5, Color.red));
            }
        } else if (k < -1) {
            int x = st.getX();
            double d = -dy / 2 - dx;
            for (int y = st.getY(); y < end.getY(); y++) {
                if (d <= 0) {
                    d -= dx;

                } else {
                    x--;
                    d += -dy - dx;
                }
                this.addPoint(new Point(x, y, 5, Color.red));
            }
        }
    }

    private void addPoint(Point p) {
        if (listPoint.isEmpty()) {
            showPointArea.append("Point 1: ");
            listPoint.add(p);
        } else if (listPoint.size() == 1) {
            showPointArea.append("Point 2: ");
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
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
