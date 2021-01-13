package com.ammerzon.animatedfigures.helpers;

public record Size(double width, double height) {
  public Size withInset(Inset inset) {
    return new Size(width + inset.top() + inset.bottom(), height + inset.left() + inset.right());
  }
}
