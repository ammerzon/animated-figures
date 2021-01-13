package com.ammerzon.animatedfigures.core.figures.impl;

import com.ammerzon.animatedfigures.core.figures.Figure;
import com.ammerzon.animatedfigures.core.shapes.Shape;
import com.ammerzon.animatedfigures.core.shapes.impl.CircleShape;
import com.ammerzon.animatedfigures.core.shapes.impl.RectangleShape;
import com.ammerzon.animatedfigures.core.visitors.ShapeVisitor;
import com.ammerzon.animatedfigures.helpers.ColorConverter;
import com.ammerzon.animatedfigures.helpers.Point;
import com.ammerzon.animatedfigures.helpers.Size;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MagnifierFigure implements Figure {

  private static final int MAGNIFIER_SIZE = 60;
  private static final int HANDLE_HEIGHT = MAGNIFIER_SIZE / 4;
  private static final int HANDLE_WIDTH = 70;
  private static final Color MAGNIFIER_COLOR = ColorConverter.hex2Rgb("#4b7bec");
  private static final Color HANDLE_COLOR = ColorConverter.hex2Rgb("#aa6027");
  private final List<Shape> shapes = new ArrayList<>();

  public MagnifierFigure(Point origin) {
    shapes.add(new RectangleShape(
        origin.withOffset(MAGNIFIER_SIZE - 10, MAGNIFIER_SIZE / 2 - HANDLE_HEIGHT / 2),
        HANDLE_COLOR,
        new Size(HANDLE_WIDTH, HANDLE_HEIGHT)));
    shapes.add(new CircleShape(
        origin,
        MAGNIFIER_COLOR,
        MAGNIFIER_SIZE));
  }

  @Override
  public List<Shape> getShapes() {
    return Collections.unmodifiableList(shapes);
  }

  @Override
  public void accept(ShapeVisitor visitor) {
    visitor.visit(this);
  }
}
