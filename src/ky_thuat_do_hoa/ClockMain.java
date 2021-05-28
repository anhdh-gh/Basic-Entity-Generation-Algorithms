/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ky_thuat_do_hoa;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author os
 */
public class ClockMain {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        
        Clock clock = new Clock();
        frame.add(BorderLayout.CENTER, clock);
        //frame.add(BorderLayout.EAST, new Button("change"));
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Thread thread = new Thread(clock);
        thread.start();
    }
}
