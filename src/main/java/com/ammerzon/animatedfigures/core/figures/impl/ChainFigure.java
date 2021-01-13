package com.ammerzon.animatedfigures.core.figures.impl;

import com.ammerzon.animatedfigures.core.figures.Figure;
import com.ammerzon.animatedfigures.core.shapes.Shape;
import com.ammerzon.animatedfigures.core.shapes.impl.CircleShape;
import com.ammerzon.animatedfigures.core.visitors.ShapeVisitor;
import com.ammerzon.animatedfigures.helpers.ColorConverter;
import com.ammerzon.animatedfigures.helpers.Point;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ChainFigure implements Figure {

  private static final int CHAIN_LINK_DIAMETER = 80;
  private static final Color CHAIN_LINK_COLOR = ColorConverter.hex2Rgb("#eb3b5a");
  private final List<Shape> shapes = new ArrayList<>();

  public ChainFigure(Point origin, int chainLinks) {
    IntStream.range(1, chainLinks).forEach(i -> {
      shapes.add(new CircleShape(
          origin.withOffset((int) (i * (CHAIN_LINK_DIAMETER * 0.6)), 0),
          CHAIN_LINK_COLOR,
          false,
          CHAIN_LINK_DIAMETER));
    });
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
