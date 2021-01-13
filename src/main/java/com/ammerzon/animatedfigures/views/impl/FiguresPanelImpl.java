package com.ammerzon.animatedfigures.views.impl;

import static java.lang.Thread.sleep;

import com.ammerzon.animatedfigures.core.figures.Figure;
import com.ammerzon.animatedfigures.core.visitors.ShapeVisitor;
import com.ammerzon.animatedfigures.views.FiguresPanel;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class FiguresPanelImpl extends JPanel implements FiguresPanel {

  private static final int ANIMATION_DELAY = 20;
  private final List<Figure> figures = new ArrayList<>();
  private final List<ShapeVisitor> visitors = new ArrayList<>();
  private Thread animationThread;

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    figures.forEach(figure -> figure.paint(g));
  }

  @Override
  public void addFigure(Figure figure) {
    figures.add(figure);
  }

  @Override
  public void addVisitor(ShapeVisitor visitor) {
    visitors.add(visitor);
  }

  @Override
  public void startAnimations() {
    animationThread = new Thread(() -> {
      try {
        while (!Thread.interrupted()) {
          figures.forEach(f -> visitors.forEach(f::accept));
          repaint();
          sleep(ANIMATION_DELAY);
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    animationThread.start();
  }

  @Override
  public void stopAnimations() {
    animationThread.interrupt();
  }

}
