package com.ammerzon.animatedfigures.core.visitors.impl;

import com.ammerzon.animatedfigures.core.figures.Figure;
import com.ammerzon.animatedfigures.core.figures.impl.ChainFigure;
import com.ammerzon.animatedfigures.core.figures.impl.MagnifierFigure;
import com.ammerzon.animatedfigures.core.visitors.ShapeVisitor;
import com.ammerzon.animatedfigures.helpers.Inset;
import com.ammerzon.animatedfigures.helpers.Transformation;
import java.util.HashMap;

public final class ResizeVisitor implements ShapeVisitor {

  private static final int SPEED = 5;
  private static final int MAX_LIMIT = 300;
  private static final int MIN_LIMIT = 100;
  private final HashMap<Figure, Transformation> visitedFigures = new HashMap<>();

  @Override
  public void visit(ChainFigure figure) {
    resizeFigure(figure);
  }

  @Override
  public void visit(MagnifierFigure figure) {
    resizeFigure(figure);
  }

  private void resizeFigure(Figure figure) {
    var transformation = Transformation.EXPAND;
    if (visitedFigures.containsKey(figure)) {
      transformation = visitedFigures.get(figure);
    }

    var speed = (transformation == Transformation.EXPAND ? SPEED : -SPEED) / 4;
    figure.resize(new Inset(speed, speed, speed, speed));

    if (figure.getSize().height() > MAX_LIMIT || figure.getSize().width() > MAX_LIMIT) {
      visitedFigures.put(figure, Transformation.SHRINK);
    } else if (figure.getSize().height() < MIN_LIMIT || figure.getSize().width() < MIN_LIMIT) {
      visitedFigures.put(figure, Transformation.EXPAND);
    }
  }
}
