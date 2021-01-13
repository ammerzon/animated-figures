package com.ammerzon.animatedfigures.core.visitors;

import com.ammerzon.animatedfigures.core.figures.impl.ChainFigure;
import com.ammerzon.animatedfigures.core.figures.impl.MagnifierFigure;

public interface ShapeVisitor {

  void visit(ChainFigure figure);

  void visit(MagnifierFigure figure);
}
