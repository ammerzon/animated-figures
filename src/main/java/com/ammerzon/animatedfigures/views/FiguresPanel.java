package com.ammerzon.animatedfigures.views;

import com.ammerzon.animatedfigures.core.figures.Figure;
import com.ammerzon.animatedfigures.core.visitors.ShapeVisitor;

public interface FiguresPanel {

  void addFigure(Figure figure);

  void addVisitor(ShapeVisitor visitor);

  void startAnimations();

  void stopAnimations();
}
