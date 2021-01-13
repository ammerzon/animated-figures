package com.ammerzon.animatedfigures.core.shapes.impl;

import com.ammerzon.animatedfigures.helpers.Point;
import com.ammerzon.animatedfigures.helpers.Size;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class RectangleShape extends BaseShape {

  private final Size size;

  public RectangleShape(Point origin, Color color, Size size) {
    this(origin, color, true, size);
  }

  public RectangleShape(Point origin, Color color, boolean filled, Size size) {
    super(origin, color, filled);
    this.size = size;
  }

  @Override
  public Size getSize() {
    return size;
  }

  @Override
  public void paint(Graphics g) {
    var ga = (Graphics2D) g;
    ga.setPaint(color);

    if (filled) {
      g.fillRect(origin.x(), origin.y(), size.width(), size.height());
    } else {
      g.drawRect(origin.x(), origin.y(), size.width(), size.height());
    }
  }

}
