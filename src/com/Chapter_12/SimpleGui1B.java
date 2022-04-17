package com.Chapter_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui1B implements ActionListener {
    JButton button;

    public static void main(String[] args)
    {
        SimpleGui1B simple = new SimpleGui1B();
        simple.go();
    }

    public void go()
    {
        JFrame frame = new JFrame();
        button = new JButton("Click me");

        button.addActionListener( this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        button.setText("I've been cliked!");
    }
}
