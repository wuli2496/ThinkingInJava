package net.test.chapter22_GUI;

import javax.swing.*;

public class HelloSwing {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Hello swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }
}
