/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ky_thuat_do_hoa;

import java.util.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author os
 */
public class Clock extends JPanel implements Runnable {
    
    private int xCenter = 150;
    private int yCenter = 150;
    private int width = 1;
    private ArrayList<Point> hours = new ArrayList<>();
    private ArrayList<Point> minutes = new ArrayList<>();
    private ArrayList<Point> seconds = new ArrayList<>();
    public Clock() {
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        hours = new ArrayList<>();
        minutes = new ArrayList<>();
        seconds = new ArrayList<>();
        int xSecond, ySecond, xMinute, yMinute, xHour, yHour;
        int second, minute, hour;
        
        Calendar calendar = Calendar.getInstance();
        second = calendar.get(Calendar.SECOND);
        minute = calendar.get(Calendar.MINUTE);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        
        xSecond = xCenter + (int) (Math.sin(second * Math.PI / 30) * 120);
        ySecond = yCenter - (int) (Math.cos(second * Math.PI / 30) * 120);
        xMinute = xCenter + (int) (Math.sin((minute + second / 60) * Math.PI / 30) * 100);
        yMinute = yCenter - (int) (Math.cos((minute + second / 60) * Math.PI / 30) * 100);
        xHour = xCenter + (int) (Math.sin((hour + minute / 60 + second / 3600) * Math.PI / 12) * 80);
        yHour = yCenter - (int) (Math.cos((hour + minute / 60 + second / 3600) * Math.PI / 12) * 80);
      
        g.fillOval(10, 10, 290, 290);
        g.setFont(new Font("Times", Font.BOLD, 15));
        g.setColor(Color.red);
        g.drawString("12", xCenter, yCenter - 125);
        g.drawString("6", xCenter, yCenter + 135);
        g.drawString("3", xCenter + 130, yCenter + 3);
        g.drawString("9", xCenter - 130, yCenter + 2);
        
        
//        g.drawLine(xCenter, yCenter, xSecond, ySecond);
        seconds.add(new Point(xCenter, yCenter, width, Color.green));
        seconds.add(new Point(xSecond, ySecond, width, Color.green));
        this.drawLine(seconds);
        g.setColor(Color.GREEN);
        for(Point p : seconds) {
            p.draw(g);
        }
        g.setColor(Color.RED);
        g.drawLine(xCenter, yCenter, xMinute, yMinute);
        g.setColor(Color.BLUE);
        g.drawLine(xCenter, yCenter, xHour, yHour);
        
        g.setColor(Color.black);
        g.fillRect(10, 310, 290, 50);
        String hourS = Integer.toString(hour);
        String minuteS = Integer.toString(minute);
        String secondS = Integer.toString(second);
        
        if(hourS.length() == 1)
            hourS = "0" + hourS;
        if(minuteS.length() == 1)
            minuteS = "0" + minuteS;
        if(secondS.length() == 1)
            secondS = "0" + secondS;
        
        String time = hourS + " : " + minuteS + " : " + secondS;
        g.setColor(Color.white);
        g.setFont(new Font("Times", Font.BOLD, 20));
        g.drawString(time, 100, 335);
        
    }
    
    @Override
    public void run() {
        try {
            while(true) {
                Thread.sleep(100);
                this.repaint();
            }
        }
        catch(InterruptedException ex){
        }
    }
    
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
    private void midPoint(ArrayList<Point> listPoint, Point st, Point end, double k) {

        double dx = end.getX() - st.getX();
        double dy = end.getY() - st.getY();
        Color c = Color.red;
        if(listPoint.equals(seconds))
            c = Color.green;
        else if(listPoint.equals(minutes)) 
            c = Color.blue;
        else c = Color.red;
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
                this.addPoint(listPoint, new Point(x, y, width, c));
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
                this.addPoint(listPoint, new Point(x, y, width, c));
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
                this.addPoint(listPoint, new Point(x, y, width, c));
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
                this.addPoint(listPoint, new Point(x, y, width, c));
            }
        } else if(k == 0) {System.out.println("aaaaa");
            int x = st.getX();
            for(int y = st.getY(); y <= end.getY(); y+= width) {
                x++;
                this.addPoint(listPoint, new Point(x, y, width, c));
            }
        }
    }

    private void addPoint(ArrayList<Point> listPoint, Point p) {
        listPoint.add(p);
        this.repaint();
    }
}
