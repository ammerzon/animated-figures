package com.ammerzon.animatedfigures.core.shapes.impl;

import com.ammerzon.animatedfigures.core.shapes.Shape;
import com.ammerzon.animatedfigures.helpers.Point;
import com.ammerzon.animatedfigures.helpers.Size;
import java.awt.Color;

public abstract class BaseShape implements Shape {

  protected Point origin;
  protected Size size;
  protected Color color;
  protected boolean filled;


  public BaseShape(Point origin, Color color, boolean filled) {
    this.origin = origin;
    this.color = color;
    this.filled = filled;
  }

  @Override
  public Point getOrigin() {
    return origin;
  }
}
