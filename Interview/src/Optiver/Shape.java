package Optiver;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public interface Shape {
  int GetArea();
}

class Rectangle implements Shape{

  int height;
  int width;

  public Rectangle(int height, int width) {
    this.height = height;
    this.width = width;
  }

  @Override
  public int GetArea() {
    return height*width;
  }
}

class Triangle implements Shape{

  int height;
  int width;

  public Triangle(int height, int width) {
    this.height = height;
    this.width = width;
  }

  @Override
  public int GetArea() {
    return Math.round(height*width/2);
  }
}

class Circle implements Shape{
  private static final double PI = 3.14;
  int radius;

  public Circle(int radius) {
    this.radius = radius;
  }

  @Override
  public int GetArea() {
    return (int) Math.round(radius*radius*PI);
  }
}



