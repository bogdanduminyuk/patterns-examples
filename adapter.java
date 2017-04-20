
import java.lang.Math;
import java.util.*;


abstract class Shape {
	abstract void display();
    abstract void undisplay();
}

class Line extends Shape {
  void display() {
    System.out.println("Display line");
  }
  void undisplay() {
    System.out.println("Undisplay line");
  }
}

class Square extends Shape {
  void display() {
    System.out.println("Display Square");
  }
  void undisplay() {
    System.out.println("Undisplay Square");
  }
}

class XCircle {
  void displayIt() {
    System.out.println("Display XCirlce");
  }
  void undisplayIt() {
    System.out.println("Undisplay XCirlce");
  }
}

class CircleAdapter extends Shape {
  private XCircle xc = new XCircle();
  
  void display() {
    xc.displayIt();
  }
  void undisplay() {
    xc.undisplayIt();
  }
}


public class HelloWorld
{

  public static void main(String[] args)
  {
    ArrayList<Shape> list = new ArrayList<Shape>();
    list.add(new Line());
    list.add(new Square());
    list.add(new Square());

    list.add(new CircleAdapter());
    
    for(Shape shape: list)
      shape.display();
    
    for(Shape shape: list)
      shape.undisplay();
  }
}