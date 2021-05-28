package ky_thuat_do_hoa;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Objects;

public class Point {

    private int x, y, width;
    private Color color;

    public Point(int x, int y, int width, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor() {
        return color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setStroke(new BasicStroke(this.width));
        g2d.setColor(color);
        g2d.drawLine(x, y, x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof Point) {
            Point p = (Point) o;
            return p.getX() == this.getX() && p.getY() == this.getY() && p.getWidth() == this.getWidth();
        }
        return false;
    }

    @Override
    public int hashCode() {
        int temp = x + y + width;
        return Objects.hash(x);
    }
}
