package com.ammerzon.animatedfigures.core.decorators;

import com.ammerzon.animatedfigures.core.figures.Figure;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class BackgroundDecorator extends FigureDecorator {
  private static final int OFFSET = 10;
  private final Color color;

  public BackgroundDecorator(Figure figure, Color color) {
    super(figure);
    this.color = color;
  }

  @Override
  public void paint(Graphics g) {
    var origin = getOrigin();
    var size = getSize();

    var ga = (Graphics2D) g;
    ga.setPaint(color);
    g.fillRect(origin.x() - OFFSET, origin.y() - OFFSET, (int) (size.width() + 2.0 * OFFSET),
        (int) (size.height() + 2.0 * OFFSET));

    super.paint(g);
  }
}
