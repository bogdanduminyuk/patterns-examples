
public class Client
{
  
  public static void main(String[] args)
  {
	Printable one = new HeaderPrinterDecorator(new FooterPrinterDecorator(new DisplayPrinter()));
    Printable two = new HeaderPrinterDecorator(new HeaderPrinterDecorator(new FooterPrinterDecorator(new PaperPrinter())));
    one.print();
    System.out.println("----------------------");
    two.print();
    
  }
}



interface Printable {
  public void print();
}

class DisplayPrinter implements Printable {
  public void print() {
    System.out.println("Print to the display");
  }
}

class PaperPrinter implements Printable {
  public void print() {
    System.out.println("Print to the paper");
  }
}


abstract class PrinterDecorator implements Printable {
  private Printable printer;
  
  public PrinterDecorator() {}
  
  
  public PrinterDecorator(Printable p) {
    printer = p;
  }
  
  public void print() {
    if (printer != null)
      printer.print();
  }
}

class HeaderPrinterDecorator extends PrinterDecorator {
  public HeaderPrinterDecorator(Printable p) {
    super(p);
  }
  
  public void print() {
    System.out.println("Header");
    super.print();
  }
}

class FooterPrinterDecorator extends PrinterDecorator {
  /*public FooterPrinterDecorator(Printable p) {
    super(p);
  }*/
  
  public void print() {
    super.print();
    System.out.println("Footer");
  }
}