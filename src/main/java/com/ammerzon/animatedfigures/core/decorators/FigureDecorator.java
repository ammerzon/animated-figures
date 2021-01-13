package com.ammerzon.animatedfigures.core.decorators;

import com.ammerzon.animatedfigures.core.figures.Figure;
import com.ammerzon.animatedfigures.core.shapes.Shape;
import com.ammerzon.animatedfigures.core.visitors.ShapeVisitor;
import com.ammerzon.animatedfigures.helpers.Point;
import com.ammerzon.animatedfigures.helpers.Size;
import java.awt.Graphics;
import java.util.List;

public class FigureDecorator implements Figure {

  protected final Figure figure;

  protected FigureDecorator(Figure figure) {
    this.figure = figure;
  }

  @Override
  public List<Shape> getShapes() {
    return figure.getShapes();
  }

  @Override
  public void accept(ShapeVisitor visitor) {
    figure.accept(visitor);
  }

  @Override
  public Size getSize() {
    return figure.getSize();
  }

  @Override
  public Point getOrigin() {
    return figure.getOrigin();
  }

  @Override
  public void paint(Graphics g) {
    figure.paint(g);
  }
}
