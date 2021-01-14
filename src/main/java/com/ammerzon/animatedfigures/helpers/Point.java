package com.ammerzon.animatedfigures.helpers;

public record Point(int x, int y) {

  public Point withOffset(int xOffset, int yOffset) {
    return new Point(x + xOffset, y + yOffset);
  }
}
