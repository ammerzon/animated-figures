package com.ammerzon.animatedfigures.core.shapes.impl;

import com.ammerzon.animatedfigures.helpers.Point;
import com.ammerzon.animatedfigures.helpers.Size;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class CircleShape extends BaseShape {

  private final int diameter;

  public CircleShape(Point origin, Color color, int diameter) {
    this(origin, color, true, diameter);
  }

  public CircleShape(Point origin, Color color, boolean filled, int diameter) {
    super(origin, color, filled);
    this.diameter = diameter;
  }

  @Override
  public Size getSize() {
    return new Size(diameter, diameter);
  }

  @Override
  public void paint(Graphics g) {
    var ga = (Graphics2D) g;
    ga.setPaint(color);

    if (filled) {
      g.fillOval(origin.x(), origin.y(), diameter, diameter);
    } else {
      g.drawOval(origin.x(), origin.y(), diameter, diameter);
    }
  }

}
