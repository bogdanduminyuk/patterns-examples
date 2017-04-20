
enum Resolution {HIGH, LOW};


public class HelloWorld
{

  public static void main(String[] args)
  {
    ApControl hr = new ApControl(Resolution.HIGH);
    ApControl lr = new ApControl(Resolution.LOW);
    
    hr.doDraw();
    hr.doPrint();
    
    lr.doDraw();
    lr.doPrint();
  }
}


class ApControl {
  private DisplayDriver dd;
  private PrintDriver pd;
  
  public ApControl(Resolution resolution) {
    DriverFactory df = DriverFactory.getFactory(resolution);
    dd = df.getDisplayDriver();
    pd = df.getPrintDriver();
  }
  
  public void doDraw() {
    dd.draw();
  }
  
  public void doPrint() {
    pd.print();
  }
}


/*
 * Display драйвера
 */


abstract class DisplayDriver {  
  abstract public void draw();
}



class LowResDispDriver extends DisplayDriver {
  public void draw() {
    System.out.println("Draw of LowResDispDriver");
  }
}


class HighResDispDriver extends DisplayDriver {
  public void draw() {
    System.out.println("Draw of HighResDispDriver");
  }
}


/*
 * Print драйвера
 */


abstract class PrintDriver {
  abstract public void print();
}


class LowResPrintDriver extends PrintDriver {
  public void print() {
    System.out.println("Print of LowResPrintDriver");
  }
}


class HighResPrintDriver extends PrintDriver {
  public void print() {
    System.out.println("Print of HighResPrintDriver");
  }
}

/*
 * Фабрики
 */

abstract class DriverFactory {
  
  public static DriverFactory getFactory(Resolution resolution) {
    if (resolution == Resolution.HIGH)
      return new HighResFactory();
    else if (resolution == Resolution.LOW)
      return new LowResFactory();
    else
      return null;
  }
    
  abstract public DisplayDriver getDisplayDriver();
  abstract public PrintDriver getPrintDriver();
}


class LowResFactory extends DriverFactory {
  public DisplayDriver getDisplayDriver() {
    return new LowResDispDriver();
  }
  
  public PrintDriver getPrintDriver() {
    return new LowResPrintDriver();
  }
}


class HighResFactory extends DriverFactory {
  public DisplayDriver getDisplayDriver() {
    return new HighResDispDriver();
  }
  
  public PrintDriver getPrintDriver() {
    return new HighResPrintDriver();
  }
}