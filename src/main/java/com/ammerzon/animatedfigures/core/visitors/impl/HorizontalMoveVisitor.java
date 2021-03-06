package com.ammerzon.animatedfigures.core.visitors.impl;

import com.ammerzon.animatedfigures.core.figures.Figure;
import com.ammerzon.animatedfigures.core.figures.impl.ChainFigure;
import com.ammerzon.animatedfigures.core.figures.impl.MagnifierFigure;
import com.ammerzon.animatedfigures.core.visitors.ShapeVisitor;
import com.ammerzon.animatedfigures.helpers.Direction;
import com.ammerzon.animatedfigures.helpers.Size;
import java.util.HashMap;

public final class HorizontalMoveVisitor implements ShapeVisitor {

  private static final int SPEED = 5;
  private final Size frame;
  private final HashMap<Figure, Direction> visitedFigures = new HashMap<>();

  public HorizontalMoveVisitor(Size frame) {
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
    var direction = Direction.RIGHT;
    if (visitedFigures.containsKey(figure)) {
      direction = visitedFigures.get(figure);
    }

    var speed = direction == Direction.RIGHT ? SPEED : -SPEED;
    figure.move(speed, 0);

    if (figure.getOrigin().x() + figure.getSize().width() >= frame.width()) {
      visitedFigures.put(figure, Direction.LEFT);
    } else if (figure.getOrigin().x() <= 0) {
      visitedFigures.put(figure, Direction.RIGHT);
    }
  }

}
