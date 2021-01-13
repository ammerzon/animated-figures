package com.ammerzon.animatedfigures;

import com.ammerzon.animatedfigures.core.decorators.BackgroundDecorator;
import com.ammerzon.animatedfigures.core.decorators.BorderDecorator;
import com.ammerzon.animatedfigures.core.figures.impl.ChainFigure;
import com.ammerzon.animatedfigures.core.figures.impl.MagnifierFigure;
import com.ammerzon.animatedfigures.core.visitors.impl.HorizontalMoveVisitor;
import com.ammerzon.animatedfigures.core.visitors.impl.ResizeVisitor;
import com.ammerzon.animatedfigures.core.visitors.impl.RotateVisitor;
import com.ammerzon.animatedfigures.helpers.ColorConverter;
import com.ammerzon.animatedfigures.helpers.Point;
import com.ammerzon.animatedfigures.views.FiguresPanel;
import com.ammerzon.animatedfigures.views.impl.FiguresPanelImpl;
import javax.swing.JFrame;

public final class App {

  public static void main(String[] args) {
    System.setProperty("apple.laf.useScreenMenuBar", "true");
    JFrame.setDefaultLookAndFeelDecorated(true);

    var frame = new JFrame("Animated Figures");
    var panel = new FiguresPanelImpl();
    addFiguresToPanel(panel);

    frame.getContentPane().add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1000, 600);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  private static void addFiguresToPanel(FiguresPanel panel) {
    panel.addFigure(new ChainFigure(new Point(300, 200), 6));
    panel.addFigure(new BackgroundDecorator(
        new ChainFigure(new Point(100, 100), 5),
        ColorConverter.hex2Rgb("#95a5a6")));
    panel.addFigure(new BorderDecorator(
        new MagnifierFigure(new Point(400, 300)),
        ColorConverter.hex2Rgb("#d35400")));
    panel.addFigure(new BackgroundDecorator(
        new BorderDecorator(
            new MagnifierFigure(new Point(600, 400)),
            ColorConverter.hex2Rgb("#27ae60")),
        ColorConverter.hex2Rgb("#2c3e50")));
    panel.addVisitor(new ResizeVisitor());
    panel.addVisitor(new HorizontalMoveVisitor());
    panel.addVisitor(new RotateVisitor());
  }
}

