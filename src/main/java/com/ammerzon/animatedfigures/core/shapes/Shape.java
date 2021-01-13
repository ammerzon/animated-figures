package com.ammerzon.animatedfigures.core.shapes;

import com.ammerzon.animatedfigures.helpers.Point;
import com.ammerzon.animatedfigures.helpers.Size;
import java.awt.Graphics;

public interface Shape {

  Point getOrigin();

  Size getSize();

  void paint(Graphics g);

}
