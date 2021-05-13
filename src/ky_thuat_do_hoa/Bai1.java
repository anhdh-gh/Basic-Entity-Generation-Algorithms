package ky_thuat_do_hoa;

import java.awt.*;
import javax.swing.*;

public class Bai1 extends JPanel {
    
    public Bai1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        showPoint = new javax.swing.JTextArea();
        controller = new javax.swing.JPanel();
        start = new javax.swing.JButton();
        quick = new javax.swing.JButton();
        reset = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Points", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        showPoint.setEditable(false);
        showPoint.setColumns(20);
        showPoint.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        showPoint.setRows(5);
        showPoint.setOpaque(false);
        jScrollPane1.setViewportView(showPoint);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.LINE_START);

        controller.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controller", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        start.setText("Start");
        controller.add(start);

        quick.setText("Quick");
        controller.add(quick);

        reset.setText("Reset");
        controller.add(reset);

        jPanel1.add(controller, java.awt.BorderLayout.PAGE_END);

        add(jPanel1, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controller;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton quick;
    private javax.swing.JButton reset;
    private javax.swing.JTextArea showPoint;
    private javax.swing.JButton start;
    // End of variables declaration//GEN-END:variables
}