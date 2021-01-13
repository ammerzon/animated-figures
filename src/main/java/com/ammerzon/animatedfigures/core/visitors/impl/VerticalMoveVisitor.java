package com.ammerzon.animatedfigures.core.visitors.impl;

import com.ammerzon.animatedfigures.core.figures.Figure;
import com.ammerzon.animatedfigures.core.figures.impl.ChainFigure;
import com.ammerzon.animatedfigures.core.figures.impl.MagnifierFigure;
import com.ammerzon.animatedfigures.core.visitors.ShapeVisitor;
import com.ammerzon.animatedfigures.helpers.Direction;
import com.ammerzon.animatedfigures.helpers.Size;
import java.util.HashMap;
import java.util.Objects;

public final class VerticalMoveVisitor implements ShapeVisitor {

  private static final int SPEED = 2;
  private final Size frame;
  private final HashMap<Figure, Direction> visitedFigures = new HashMap<>();

  public VerticalMoveVisitor(Size frame) {
    this.frame = frame;
  }

  @Override
  public void visit(ChainFigure figure) {
    moveFigure(figure);
  }

  @Override
  public void visit(MagnifierFigure figure) {
    moveFigure(figure);
  }

  private void moveFigure(Figure figure) {
    var direction = Direction.UP;
    if (visitedFigures.containsKey(figure)) {
      direction = visitedFigures.get(figure);
    }

    var speed = direction == Direction.DOWN ? SPEED : -SPEED;
    figure.move(0, speed);

    if (figure.getOrigin().x() + figure.getSize().height() >= frame.height()) {
      visitedFigures.put(figure, Direction.UP);
    } else if (figure.getOrigin().y() <= 0) {
      visitedFigures.put(figure, Direction.DOWN);
    }
  }

}
