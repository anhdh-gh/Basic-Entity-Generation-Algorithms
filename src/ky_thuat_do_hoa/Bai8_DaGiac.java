package ky_thuat_do_hoa;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Bai8_DaGiac extends JPanel {

    private ArrayList<ArrayList<Point>> listLine;
    private int width = 1;

    public Bai8_DaGiac() {
        initComponents();
        listLine = new ArrayList<>();
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
        if (listLine.isEmpty()) {
            ArrayList<Point> listPoint = new ArrayList<>();
            Point p = new Point(evt.getX(), evt.getY(), 5, Color.red);
            this.addPoint(listPoint, p);
            listLine.add(listPoint);
        } else {
            ArrayList<Point> listPoint = new ArrayList<>();
            Point p = new Point(evt.getX(), evt.getY(), 5, Color.red);
            this.addPoint(listLine.get(listLine.size() - 1), p);
            this.drawLine(listLine.get(listLine.size() - 1));
            this.addPoint(listPoint, p);
            listLine.add(listPoint);
        }

    }//GEN-LAST:event_formMouseClicked

    public void drawLine(ArrayList<Point> list) {
        double dx = list.get(1).getX() - list.get(0).getX();
        double dy = list.get(1).getY() - list.get(0).getY();
        double k = dy / dx;
        if (0 < k && k < 1 || -1 < k && k < 0) {
            if (list.get(0).getX() > list.get(1).getX()) {
                this.midPoint(list, list.get(1), list.get(0), k);
            } else {
                this.midPoint(list, list.get(0), list.get(1), k);
            }
        } else if (k > 1 || k < -1) {
            if (list.get(0).getY() > list.get(1).getY()) {
                this.midPoint(list, list.get(1), list.get(0), k);
            } else {
                this.midPoint(list, list.get(0), list.get(1), k);
            }
        }
    }
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:       
        this.addPoint(listLine.get(listLine.size() - 1), listLine.get(0).get(0));
        this.drawLine(listLine.get(listLine.size() - 1));
    }//GEN-LAST:event_startButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < listLine.size(); i++) {
            listLine.get(i).clear();
        }
        listLine.clear();
        showPointArea.setText("");
        startButton.setEnabled(true);
        this.repaint();
    }//GEN-LAST:event_resetButtonActionPerformed

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < listLine.size(); i++) {
            for (Point p : listLine.get(i)) {
                p.draw(g);
            }
        }
    }

    private void midPoint(ArrayList<Point> listPoint, Point st, Point end, double k) {

        double dx = end.getX() - st.getX();
        double dy = end.getY() - st.getY();

        if (0 < k && k < 1) {
            int y = st.getY();
            double d = dy - dx / 2;
            for (int x = st.getX() + 1; x <= end.getX(); x += width) {
                if (d <= 0) {
                    d += dy;
                } else {
                    y += width;
                    d = d + dy - dx;
                }
                this.addPoint(listPoint, new Point(x, y, width, Color.red));
            }
        } else if (-1 < k && k < 0) {
            int y = st.getY();
            double d = dy + dx / 2;
            for (int x = st.getX() + 1; x <= end.getX(); x += width) {
                if (d >= 0) {
                    d += dy;

                } else {
                    y -= width;
                    d += dy + dx;
                }
                this.addPoint(listPoint, new Point(x, y, width, Color.red));
            }
        } else if (k > 1) {
            int x = st.getX();
            double d = dy / 2 - dx;
            for (int y = st.getY(); y <= end.getY(); y += width) {
                if (d >= 0) {
                    d -= dx;

                } else {
                    x += width;
                    d += dy - dx;
                }
                this.addPoint(listPoint, new Point(x, y, width, Color.red));
            }
        } else if (k < -1) {
            int x = st.getX();
            double d = -dy / 2 - dx;
            for (int y = st.getY(); y <= end.getY(); y += width) {
                if (d <= 0) {
                    d -= dx;

                } else {
                    x -= width;
                    d += -dy - dx;
                }
                this.addPoint(listPoint, new Point(x, y, width, Color.red));
            }
        }
    }

    private void addPoint(ArrayList<Point> listPoint, Point p) {
        if (listPoint.isEmpty()) {
            listPoint.add(p);
        } else if (listPoint.size() == 1) {
            listPoint.add(p);
        } else {
            listPoint.add(p);
        }
        
        showPointArea.append("Point " + listLine.size() + ": " + "x = " + p.getX() + ", y = " + p.getY() + "\n");
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
