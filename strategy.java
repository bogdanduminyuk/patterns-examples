public class HelloWorld
{

  public static void main(String[] args)
  {
    Sorter bubble = new Sorter(new BubbleSort());
    Sorter quick = new Sorter(new QuickSort());
    bubble.doSort();
    quick.doSort();
  }
}


class Sorter {
  private SortStrategy strategy;
  
  public Sorter(SortStrategy strategy) {
    this.strategy = strategy;
  }
  
  public void doSort() {
    strategy.sort();
  }
}


abstract class SortStrategy {
  abstract public void sort();
}

class BubbleSort extends SortStrategy {
  public void sort() {
  	System.out.println("BubbleSort");
  }
}

class QuickSort extends SortStrategy {
  public void sort() {
  	System.out.println("QuickSort");
  }
}