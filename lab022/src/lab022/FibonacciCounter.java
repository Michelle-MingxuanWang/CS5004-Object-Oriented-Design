package lab022;

/**
 * This class represents a Fibonacci counter. The counter contains the count of Fibonacci numbers 
 * and the corresponding Fibonacci number. 
 *
 */
class FibonacciCounter {
  private int count;
  private double number;
  
  /**
   * Constructs a FibonacciCounter object that takes count as a parameter. 
   * Initialize count and number.
   * 
   * @param count the count of the current number in FibonacciCounter
   * @throws IllegalArgumentException if the count is less than 0
   */

  public FibonacciCounter(int count) throws IllegalArgumentException { 
    if (count < 0) {
      throw new IllegalArgumentException("Count cannot be less than zero");
    }
    this.count = count;
    this.number = 1 / Math.sqrt(5) * (
        Math.pow((1 + Math.sqrt(5)) / 2,count) - Math.pow((1 - Math.sqrt(5)) / 2,count));
  }
  
  /**
   * Return a new object after increment the count. 
   * 
   * @return a new object after increment the count
   */
  public FibonacciCounter increment() {
    return new FibonacciCounter(this.count + 1);
  }
  
  /**
   * Return a new object after decrement the count. 
   * 
   * @return a new object after decrement the count
   */
  public FibonacciCounter decrement() {
    if (this.count > 0) {
      return new FibonacciCounter(this.count - 1);
    } else {
      return this;
    }
  }
  
  /**
   * Get the count of the fibonacci counter.
   * 
   * @return the count of the fibonacci counter.
   */
  public double getCount() {
    return this.count;
  }
  
  /**
   * Get the number of the fibonacci counter.
   * 
   * @return the number of the fibonacci counter.
   */
  public double getNumber() {
    return this.number;
  }
  
}