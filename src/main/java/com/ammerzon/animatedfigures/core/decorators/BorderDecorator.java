package com.ammerzon.animatedfigures.core.decorators;

import com.ammerzon.animatedfigures.core.figures.Figure;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class BorderDecorator extends FigureDecorator {

  private static final int OFFSET = 8;
  private final Color color;

  public BorderDecorator(Figure figure, Color color) {
    super(figure);
    this.color = color;
  }

  @Override
  public void paint(Graphics g) {
    var origin = getOrigin();
    var size = getSize();

    var ga = (Graphics2D) g;
    ga.setPaint(color);
    g.drawRect(origin.x() - OFFSET, origin.y() - OFFSET, (int) (size.width() + 2 * OFFSET),
        (int) (size.height() + 2 * OFFSET));

    super.paint(g);
  }
}
