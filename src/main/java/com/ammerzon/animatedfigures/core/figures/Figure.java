package com.ammerzon.animatedfigures.core.figures;

import com.ammerzon.animatedfigures.core.shapes.Shape;
import com.ammerzon.animatedfigures.core.visitors.ShapeVisitor;
import com.ammerzon.animatedfigures.helpers.Inset;
import com.ammerzon.animatedfigures.helpers.Point;
import com.ammerzon.animatedfigures.helpers.Size;
import java.awt.Graphics;
import java.util.List;

public interface Figure extends Shape {

  List<Shape> getShapes();

  @Override
  default Point getOrigin() {
    var minX = getShapes()
        .stream()
        .map(s -> s.getOrigin().x())
        .min(Integer::compare)
        .orElse(0);
    var minY = getShapes()
        .stream()
        .map(s -> s.getOrigin().y())
        .min(Integer::compare)
        .orElse(0);

    return new Point(minX, minY);
  }

  @Override
  default void setOrigin(Point origin) {
    getShapes().forEach(s -> s.setOrigin(origin));
  }

  @Override
  default void move(int xOffset, int yOffset) {
    getShapes().forEach(s -> s.move(xOffset, yOffset));
  }

  @Override
  default void resize(Inset inset) {
    getShapes().forEach(s -> s.resize(inset));
  }

  @Override
  default Size getSize() {
    var origin = getOrigin();
    var maxX = getShapes()
        .stream()
        .map(s -> s.getOrigin().x() + s.getSize().width())
        .max(Double::compare)
        .orElse(0.0);
    var maxY = getShapes()
        .stream()
        .map(s -> s.getOrigin().y() + s.getSize().height())
        .max(Double::compare)
        .orElse(0.0);

    return new Size(maxX - origin.x(), maxY - origin.y());
  }

  @Override
  default void paint(Graphics g) {
    getShapes().forEach(s -> s.paint(g));
  }

  void accept(ShapeVisitor visitor);
}
