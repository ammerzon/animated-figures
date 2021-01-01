package com.ammerzon.animatedfigures;

import com.ammerzon.animatedfigures.views.FiguresPanel;
import javax.swing.JFrame;

public final class App {

  public static void main(String[] args) {
    System.setProperty("apple.laf.useScreenMenuBar", "true");
    JFrame.setDefaultLookAndFeelDecorated(true);

    var frame = new JFrame("Animated Figures");
    var panel = new FiguresPanel();

    frame.getContentPane().add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1000, 600);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}

