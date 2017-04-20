
abstract class Shape {
  protected Drawing dp;
  
  public Shape(Drawing dp) {
    this.dp = dp; 
  }
  
  public void drawCircle() {
    dp.drawCircle();
  }
  public void drawLine() {
    dp.drawLine();
  }
  
  abstract public void draw();
}


class Rectangle extends Shape {
  
  public Rectangle(Drawing dp) {super(dp);}
  
  public void draw() {
    System.out.println("Drawing Rectangle");
    dp.drawLine();
    dp.drawLine();
    dp.drawLine();
    dp.drawLine();
  }
}


class Circle extends Shape {
  
  public Circle(Drawing dp) {super(dp);}
  
  public void draw() {
    System.out.println("Drawing Circle");
    dp.drawCircle();
  }
}


abstract class Drawing {
  abstract public void drawCircle();
  abstract public void drawLine();
}


class V1Drawing extends Drawing {
  public void drawCircle() {
    System.out.println("V1Drawing: drawCircle()");
  }
  
  public void drawLine() {
    System.out.println("V1Drawing: drawLine()");
  }
}



class V2Drawing extends Drawing {
  public void drawCircle() {
    System.out.println("V2Drawing: drawCircle()");
  }
  
  public void drawLine() {
    System.out.println("V2Drawing: drawLine()");
  }
}


public class HelloWorld
{
  public static void main(String[] args)
  {
	Drawing dp;
    Shape rect, circle;
    
    dp = new V1Drawing();
    rect = new Rectangle(dp);
    
    dp = new V2Drawing();
    circle = new Circle(dp);
    
    rect.draw();
    circle.draw();
  }
}
