package ky_thuat_do_hoa;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Bai9_GiaoDiem2DoanThang extends JPanel {

    private ArrayList<Point> listPoint1;
    private ArrayList<Point> listPoint2;
    private Point a, b;
    private int width = 1;

    public Bai9_GiaoDiem2DoanThang() {
        initComponents();
        listPoint1 = new ArrayList<>();
        listPoint2 = new ArrayList<>();
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
        if (listPoint1.isEmpty() && listPoint2.isEmpty()) {
            a = new Point(evt.getX(), evt.getY(), 5, Color.red);
            this.addPoint(listPoint1, a);

        } else if (listPoint1.size() == 1 && listPoint2.isEmpty()) {
            b = new Point(evt.getX(), evt.getY(), 5, Color.red);
            this.addPoint(listPoint1, b);
            drawLine(listPoint1);
        } else if(listPoint1.size() > 2 && listPoint2.isEmpty()) {
            a = new Point(evt.getX(), evt.getY(), 5, Color.red);
            this.addPoint(listPoint2, a);
        } else if(listPoint1.size() > 2 && listPoint2.size() == 1) {
            b = new Point(evt.getX(), evt.getY(), 5, Color.red);
            this.addPoint(listPoint2, b);
            drawLine(listPoint2);
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
        showPointArea.append("Giao điểm của hai đoạn thẳng:\n");
        System.out.println(listPoint1.size() + " " + listPoint2.size());
        for(Point p : listPoint1) {
            for(Point p1 : listPoint2)
                if(p1.getX() == p.getX() && p1.getY() == p.getY()) {
                    showPointArea.append("x = " + p.getX() + ", y = " + p.getY() + "\n");
                }
        }
        startButton.setEnabled(false);
    }//GEN-LAST:event_startButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        listPoint1.clear();
        listPoint2.clear();
        a = null;
        b = null;
        showPointArea.setText("");
        startButton.setEnabled(true);
        this.repaint();
    }//GEN-LAST:event_resetButtonActionPerformed

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        listPoint1.forEach(p -> {
            p.draw(g);
        });
        listPoint2.forEach(p -> {
            p.draw(g);
        });
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
            showPointArea.append("Point 1: " + "x = " + p.getX() + ", y = " + p.getY() + "\n");
            listPoint.add(p);
        } else if (listPoint.size() == 1) {
            showPointArea.append("Point 2: " + "x = " + p.getX() + ", y = " + p.getY() + "\n");
            listPoint.add(p);
        } else {
            listPoint.add(p);
        }
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
