package com.Chapter_12;

import javax.swing.*;

public class WindowTask {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        JButton button = new JButton();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
}