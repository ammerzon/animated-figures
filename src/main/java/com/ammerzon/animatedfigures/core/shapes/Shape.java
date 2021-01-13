package com.ammerzon.animatedfigures.core.shapes;

import com.ammerzon.animatedfigures.helpers.Inset;
import com.ammerzon.animatedfigures.helpers.Point;
import com.ammerzon.animatedfigures.helpers.Size;
import java.awt.Graphics;

public interface Shape {

  Point getOrigin();

  void setOrigin(Point origin);

  Size getSize();

  default void move(int xOffset, int yOffset) {
    setOrigin(getOrigin().withOffset(xOffset, yOffset));
  }

  void resize(Inset inset);

  void paint(Graphics g);

}
