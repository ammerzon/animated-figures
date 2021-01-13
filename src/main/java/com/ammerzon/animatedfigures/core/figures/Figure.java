package com.ammerzon.animatedfigures.core.figures;

import com.ammerzon.animatedfigures.core.shapes.Shape;
import com.ammerzon.animatedfigures.core.visitors.ShapeVisitor;
import com.ammerzon.animatedfigures.helpers.Point;
import java.util.List;

public interface Figure extends Shape {

  List<Shape> getShapes();

  @Override
  default Point getOrigin() {
    var minX = getShapes().stream().map(s -> s.getOrigin().x()).min(Integer::compare).orElse(0);
    var minY = getShapes().stream().map(s -> s.getOrigin().y()).min(Integer::compare).orElse(0);

    return new Point(minX, minY);
  }

  void accept(ShapeVisitor visitor);
}
