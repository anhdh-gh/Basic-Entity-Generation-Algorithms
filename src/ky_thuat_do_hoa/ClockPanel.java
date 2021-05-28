package ky_thuat_do_hoa;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class ClockPanel extends JPanel implements ActionListener {

    private final Timer timer;
    private final int pixel = 5;
    private final ArrayList<Point> circle = new ArrayList<>();
    private final int centerX = 800;
    private final int centerY = 355;
    private final int radius = 300;
    private final ArrayList<Point> secondLine = new ArrayList<>();
    private final ArrayList<Point> minuteLine = new ArrayList<>();
    private final ArrayList<Point> hourLine = new ArrayList<>();
    private String timeStr = "";

    public ClockPanel() {
        initComponents();

        // Vẽ vòng tròn bao ngoài
        drawCircle(centerX, centerY, radius, Color.BLACK);
        
        // Cập nhật lại UI sau 1s
        timer = new Timer(1000, this);
        timer.start();        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Times", Font.BOLD, 40));
        
        // Vẽ các kim
        circle.forEach(p -> {p.draw(g);});
        secondLine.forEach(p -> {p.draw(g);});
        minuteLine.forEach(p -> {p.draw(g);});
        hourLine.forEach(p -> {p.draw(g);});
        
        // Vẽ số
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString("12", centerX-20, (int) (centerY - radius*0.9 + 15));
        g2d.drawString("3", (int) (centerX - 8 + radius*0.9), centerY+15);
        g2d.drawString("6", centerX - 15, (int) (centerY + radius*0.9 + 15));
        g2d.drawString("9", (int) (centerX - radius*0.9 - 10), centerY+15);
        
        // Vẽ giờ chữ đằng dưới
        g2d.drawString(timeStr, centerX - 100, 2*centerY);
    }
    
    private void pc(int xc, int yc, int x, int y, Color color) {
        circle.add(new Point(xc + x, yc + y, pixel, color));
        circle.add(new Point(xc - x, yc - y, pixel, color));
        circle.add(new Point(xc - x, yc + y, pixel, color));
        circle.add(new Point(xc + x, yc - y, pixel, color));
        this.repaint();
    }
    
    private void drawCircle(int xc, int yc, int radiusValue, Color color) {
        int y = radiusValue;
        int p = 3 - 2*radiusValue;
        pc(xc, yc, radiusValue, 0, color);
        for(int x = 0 ; x < y ; x++) {
            if(p < 0) p += 4*x+6;
            else {
                p += 4*(x-y)+10;
                y--;
            }
            pc(xc, yc, x, y, color);
            pc(xc, yc, y, x, color);
        }
        pc(xc, yc, y, y, color);
    }   
    
    private void drawLine(ArrayList<Point> line, int x1, int y1, int x2, int y2, Color color) {
        line.clear();
        int dx = x2 - x1;
        int dy = y2 - y1;
        double k = (double)dy/dx;
        if((k > 0 && k < 1) || (k > -1 && k < 0))
            if(x1 <= x2) this.bresenham(line, x1, y1, x2, y2, color);
            else this.bresenham(line, x2, y2, x1, y1, color);
        else if(k > 1 || k < -1)
            if(y1 <= y2) this.bresenham(line, x1, y1, x2, y2, color);
            else this.bresenham(line, x2, y2, x1, y1, color);         
        else if (k == 0) 
            this.bresenham(line, x1, y1, x2, y2, color);
    }
    
    private void bresenham(ArrayList<Point> line, int x1, int y1, int x2, int y2, Color color) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        double k = (double)dy/dx;
        if(k > 0 && k < 1) {
            int y = y1;
            int p = 2*dy - dx;
            for(int x = x1 ; x <= x2 ; x++) {
                if(p < 0) p += 2*dy;
                else {
                    p += 2*(dy-dx);
                    y++;
                }          
                line.add(new Point(x, y, pixel, color));
            }
        }
        else if(k > 1) {
            int x = x1;
            int p=dy-2*dx;
            for(int y = y1 ; y <= y2 ; y++) {
                if(p > 0) p -= 2*dx;
                else {
                    p += 2*(dy-dx);
                    x++;
                }
                line.add(new Point(x, y, pixel, color));
            }
        }
        else if(k > -1 && k < 0) {
            int y = y1;
            int p=2*dy+dx;
            for(int x = x1 ; x <= x2 ; x++) {
                if(p > 0) p += 2*dy;
                else {
                    p += 2*(dy+dx);
                    y--;
                }              
                line.add(new Point(x, y, pixel, color));
            }            
        }
        else if(k < -1) {
            int x = x1;
            int p=-dy-2*dx;
            for(int y = y1 ; y <= y2 ; y++) {
                if(p < 0) p -= 2*dx;
                else {
                    p -= 2*(dy+dx);
                    x--;
                }
                line.add(new Point(x, y, pixel, color));
            }
        }
        else if(k == 0) {
            if(x1 < x2)
                for(int x = x1; x < x2 ; x++)
                    line.add(new Point(x, y1, pixel, color));
            else 
                for(int x = x1; x > x2 ; x--)
                    line.add(new Point(x, y1, pixel, color));               
        }
    }
    
    private void paintClock() {
        // Thời gian hiện tại
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        
        // Vẽ kim giây
        int secondLength = (int) (radius*0.8);
        int secondEndX = (int) (centerX + secondLength*Math.sin(second*Math.PI/30));        
        int secondEndY = (int) (centerY - secondLength*Math.cos(second*Math.PI/30));
        drawLine(secondLine, centerX, centerY, secondEndX, secondEndY, Color.RED);
    
        // Vẽ kim phút
        int minuteReal = minute + second/60;
        int minuteLength = (int) (radius*0.65);
        int minuteEndX = (int) (centerX + minuteLength*Math.sin(minuteReal*Math.PI/30));
        int minuteEndY = (int) (centerY - minuteLength*Math.cos(minuteReal*Math.PI/30));        
        drawLine(minuteLine, centerX, centerY, minuteEndX, minuteEndY, Color.BLUE);    
    
        // Vẽ kim giờ
        int hourReal = (hour%12) + minuteReal/60;                         
        int hourLength = (int) (radius*0.5);
        int hourEndX = (int) (centerX + hourLength*Math.sin(hourReal*Math.PI/6));
        int hourEndY = (int) (centerY - hourLength*Math.cos(hourReal*Math.PI/6));
        drawLine(hourLine, centerX, centerY, hourEndX, hourEndY, Color.GREEN);  
        
        // Đặt giá trị cho thời gian chữ
        String hourStr = Integer.toString(hour);
        String minuteStr = Integer.toString(minute);
        String secondStr = Integer.toString(second);
        
        hourStr = (hourStr.length() == 1) ? "0" + hourStr : hourStr;
        minuteStr = (minuteStr.length() == 1) ? "0" + minuteStr : minuteStr;
        secondStr = (secondStr.length() == 1) ? "0" + secondStr : secondStr;
        timeStr =  hourStr + " : " + minuteStr + " : " + secondStr;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        paintClock();
        this.repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}