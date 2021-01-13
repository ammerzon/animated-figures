package com.ammerzon.animatedfigures.core.shapes.impl;

import com.ammerzon.animatedfigures.core.shapes.Shape;
import com.ammerzon.animatedfigures.helpers.Point;
import java.awt.Graphics;
import javax.swing.text.Position;

public abstract class BaseShape implements Shape {

  protected Point origin;

  @Override
  public Point getOrigin() {
    return origin;
  }
}
