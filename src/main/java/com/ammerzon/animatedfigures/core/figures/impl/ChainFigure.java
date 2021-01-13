package com.ammerzon.animatedfigures.core.figures.impl;

import com.ammerzon.animatedfigures.core.figures.Figure;
import com.ammerzon.animatedfigures.core.shapes.Shape;
import com.ammerzon.animatedfigures.core.visitors.ShapeVisitor;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class ChainFigure implements Figure {

  private final List<Shape> shapes = new ArrayList<>();

  @Override
  public List<Shape> getShapes() {
    return shapes;
  }

  @Override
  public void accept(ShapeVisitor visitor) {
    visitor.visit(this);
  }

  @Override
  public void paint(Graphics g) {

  }
}
