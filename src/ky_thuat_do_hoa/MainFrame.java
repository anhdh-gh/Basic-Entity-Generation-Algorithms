package ky_thuat_do_hoa;

public class MainFrame extends javax.swing.JFrame {

    private final Bai1 bai1 = new Bai1();
    private final Bai2 bai2 = new Bai2();
    private final Bai3_Bresemham bai3_Bresemham = new Bai3_Bresemham();
    private final Bai3_Midpoint bai3_midpoint = new Bai3_Midpoint();
    private final Bai4_Bresemham bai4_Bresemham = new Bai4_Bresemham();
    private final Bai4_Midpoint bai4_MidPoint = new Bai4_Midpoint();
    private final Bai9_GiaoDiem2DoanThang bai9 = new Bai9_GiaoDiem2DoanThang();
    private final Bai8_DaGiac bai8 = new Bai8_DaGiac();
    private final Bai7 bai7 = new Bai7();
    
    public MainFrame() {
        initComponents();
        view.add("Đoạn thẳng Bresemham", bai1);
        view.add("Đoạn thẳng Midpoint", bai2);
        view.add("Đường tròn Bresemham", bai3_Bresemham);
        view.add("Đường tròn Midpoint", bai3_midpoint);
        view.add("Đường elip Bresemham", bai4_Bresemham); 
        view.add("Đường elip Midpoint", bai4_MidPoint); 
        view.add("Sinh ký tự: ", bai7);
        view.add("Vẽ đa giác", bai8); 
        view.add("Tìm giao điểm hai đoạn thẳng", bai9);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        view = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Các giải thuật sinh thực thể cơ sở");
        setExtendedState(6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(view, javax.swing.GroupLayout.DEFAULT_SIZE, 839, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(view, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(853, 587));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane view;
    // End of variables declaration//GEN-END:variables
}