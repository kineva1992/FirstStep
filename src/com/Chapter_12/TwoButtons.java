package com.Chapter_12;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TwoButtons  {

    JFrame frame;
    JLabel lable;

    public static void main(String[] args)
    {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton lableButton = new JButton("Change Lable");
        lableButton.addActionListener(new LableListener());

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());

        lable = new JLabel("i'm a lable");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, lableButton);
        frame.getContentPane().add(BorderLayout.WEST, lable);

        frame.setSize(300,300);
        frame.setVisible(true);
    }

    class LableListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            lable.setText("Ouch!");
        }
    }

    class ColorListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.repaint();
        }
    }

}
