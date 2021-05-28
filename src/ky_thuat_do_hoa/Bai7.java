package ky_thuat_do_hoa;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Bai7 extends JPanel {
    
    private final int pixel = 3;
    private final Map<Character, CharacterArray> map = new HashMap<>();
    private String text = "J";
    
    public Bai7() {
        initComponents();
        
        map.put('H', new CharacterArray(new int[][]{
            {1,1,0,0,0,0,0,0,1,1},
            {1,1,0,0,0,0,0,0,1,1},
            {1,1,0,0,0,0,0,0,1,1},
            {1,1,0,0,0,0,0,0,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,0,0,0,0,0,0,1,1},
            {1,1,0,0,0,0,0,0,1,1},
            {1,1,0,0,0,0,0,0,1,1},
            {1,1,0,0,0,0,0,0,1,1}
        }));
        
        map.put('J', new CharacterArray(new int[][]{
            {1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1},
            {0,0,0,0,1,1,0,0,0,0},
            {0,0,0,0,1,1,0,0,0,0},
            {0,0,0,0,1,1,0,0,0,0},
            {0,0,0,0,1,1,0,0,0,0},
            {0,0,0,0,1,1,0,0,0,0},
            {0,1,1,0,1,1,0,0,0,0},
            {0,1,1,0,1,1,0,0,0,0},
            {0,0,1,1,1,0,0,0,0,0}
        }));
        
        map.put('O', new CharacterArray(new int[][]{
            {0,0,0,1,1,1,1,0,0,0},
            {0,0,1,1,1,1,1,1,0,0},
            {1,1,0,0,0,0,0,0,1,1},
            {1,1,0,0,0,0,0,0,1,1},
            {1,1,0,0,0,0,0,0,1,1},
            {1,1,0,0,0,0,0,0,1,1},
            {1,1,0,0,0,0,0,0,1,1},
            {1,1,0,0,0,0,0,0,1,1},
            {0,0,1,1,1,1,1,1,0,0},
            {0,0,0,1,1,1,1,0,0,0}
        }));
        
        map.put('N', new CharacterArray(new int[][]{
            {1,1,0,0,0,0,0,0,1,1},
            {1,1,1,1,0,0,0,0,1,1},
            {1,1,0,1,1,0,0,0,1,1},
            {1,1,0,1,1,0,0,0,1,1},
            {1,1,0,0,1,1,0,0,1,1},
            {1,1,0,0,1,1,0,0,1,1},
            {1,1,0,0,0,1,1,0,1,1},
            {1,1,0,0,0,1,1,0,1,1},
            {1,1,0,0,0,0,1,1,1,1},
            {1,1,0,0,0,0,0,0,1,1}
        }));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());
        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jComboBox1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "J", "O", "H", "N" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        text = (String) jComboBox1.getSelectedItem();
        this.repaint();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(this.pixel));

        for(int i = 0 ; i < text.length() ; i++) {
            char x = text.charAt(i);
            int a[][] = map.get(x).getArr();
            for(int j = 0 ; j < a.length ; j++)
                for(int k = 0 ; k < a[j].length ; k++)
                    if(a[j][k] != 0) {
                        g2d.setColor(Color.red);
                        g2d.drawLine(this.getWidth()/2+k, this.getHeight()/2+j, this.getWidth()/2+k, this.getHeight()/2+j);
                    }
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    class CharacterArray {
        private final int arr[][];
        
        public CharacterArray(int arr[][]) {
            this.arr = arr;
        }
        
        public int[][] getArr() {
            return this.arr;
        }
    } 
}