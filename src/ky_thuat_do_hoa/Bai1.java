package ky_thuat_do_hoa;

public class Bai1 extends javax.swing.JPanel {

    public Bai1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        showPoint = new javax.swing.JTextArea();
        view = new javax.swing.JPanel();
        controller = new javax.swing.JPanel();
        start = new javax.swing.JButton();
        quick = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Points", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N

        showPoint.setEditable(false);
        showPoint.setColumns(20);
        showPoint.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        showPoint.setRows(5);
        jScrollPane1.setViewportView(showPoint);

        add(jScrollPane1, java.awt.BorderLayout.LINE_START);

        view.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "View", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 14))); // NOI18N
        view.setLayout(new java.awt.BorderLayout());

        start.setText("Start");
        controller.add(start);

        quick.setText("Quick");
        controller.add(quick);

        view.add(controller, java.awt.BorderLayout.PAGE_END);

        add(view, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controller;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton quick;
    private javax.swing.JTextArea showPoint;
    private javax.swing.JButton start;
    private javax.swing.JPanel view;
    // End of variables declaration//GEN-END:variables
}