package com.ammerzon.animatedfigures.core.shapes;

import com.ammerzon.animatedfigures.helpers.Point;
import java.awt.Graphics;

public interface Shape {
  Point getOrigin();

  void paint(Graphics g);
}
