package com.Chapter_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimlpleGui3C implements ActionListener {

    JFrame frame;

    public static void main(String[] args)
    {
        SimlpleGui3C gui = new SimlpleGui3C();
        gui.start();
    }

    public void start()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change colors");
        button.addActionListener(this);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(300,300);
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

class MyDrawPanel extends JPanel
{
    public void printComponent(Graphics g)
    {

    }
}
