package ky_thuat_do_hoa;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Bai1 extends JPanel {
    
    private final ArrayList<Point> points;
    private final int width = 5; 
    
    public Bai1() {
        initComponents();
        points = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        showPoints = new javax.swing.JTextArea();
        controller = new javax.swing.JPanel();
        start = new javax.swing.JButton();
        reset = new javax.swing.JButton();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Points", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        showPoints.setEditable(false);
        showPoints.setColumns(20);
        showPoints.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        showPoints.setRows(5);
        showPoints.setOpaque(false);
        jScrollPane1.setViewportView(showPoints);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.LINE_START);

        controller.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controller", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        start.setText("Start");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        controller.add(start);

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        controller.add(reset);

        jPanel1.add(controller, java.awt.BorderLayout.PAGE_END);

        add(jPanel1, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(points.isEmpty()) 
            this.addPoint(evt.getX(), evt.getY());
        else if(points.size() == 1)
            this.addPoint(evt.getX(), evt.getY());
    }//GEN-LAST:event_formMouseClicked

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        if(points.size() == 2) {
            int x1 = points.get(0).getX();
            int y1 = points.get(0).getY();
            int x2 = points.get(1).getX();
            int y2 = points.get(1).getY();
            int dx = x2 - x1;
            int dy = y2 - y1;
            double k = (double)dy/dx;
            showPoints.append("k = " + k + "\n");
            if((k > 0 && k < 1) || (k > -1 && k < 0))
                if(x1 <= x2) this.bresenham(x1, y1, x2, y2);
                else this.bresenham(x2, y2, x1, y1);
            else if(k > 1 || k < -1)
                if(y1 <= y2) this.bresenham(x1, y1, x2, y2);
                else this.bresenham(x2, y2, x1, y1);                
        }
    }//GEN-LAST:event_startActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        points.clear();
        showPoints.setText("");
        this.repaint();
    }//GEN-LAST:event_resetActionPerformed

    private void addPoint(int x, int y) {
        if(points.isEmpty()) {
            showPoints.append("Point 1: ");
            points.add(new Point(x, y, this.width, Color.RED));
        }
        else if(points.size() == 1) {
            showPoints.append("Point 2: ");
            points.add(new Point(x, y, this.width, Color.RED));
        }        
        else {
            points.add(points.size() - 1, new Point(x, y, this.width, Color.RED));
        }
        showPoints.append("x = " + x + ", y = " + y + "\n");
        this.repaint();
    }
    
    private void bresenham(int x1, int y1, int x2, int y2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        double k = (double)dy/dx;
        if(k > 0 && k < 1) {
            int y = y1;
            int p = 2*dy - dx;
            for(int x = x1 ; x <= x2 ; x+=this.width) {
                if(p < 0) p += 2*dy;
                else {
                    p += 2*(dy-dx);
                    y+=this.width;
                }              
                addPoint(x, y);
            }
        }
        else if(k > 1) {
            int x = x1;
            int p=dy-2*dx;
            for(int y = y1 ; y <= y2 ; y+=this.width) {
                if(p > 0) p -= 2*dx;
                else {
                    p += 2*(dy-dx);
                    x+=this.width;
                }
                addPoint(x, y);
            }
        }
        else if(k > -1 && k < 0) {
            int y = y1;
            int p=2*dy+dx;
            for(int x = x1 ; x <= x2 ; x+=this.width) {
                if(p > 0) p += 2*dy;
                else {
                    p += 2*(dy+dx);
                    y-=this.width;
                }              
                addPoint(x, y);
            }            
        }
        else if(k < -1) {
            int x = x1;
            int p=-dy-2*dx;
            for(int y = y1 ; y <= y2 ; y+=this.width) {
                if(p < 0) p -= 2*dx;
                else {
                    p -= 2*(dy+dx);
                    x-=this.width;
                }
                addPoint(x, y);
            }
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        points.forEach(point -> {
            point.draw(g);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controller;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reset;
    private javax.swing.JTextArea showPoints;
    private javax.swing.JButton start;
    // End of variables declaration//GEN-END:variables
}