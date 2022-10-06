package lab022;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the FibonacciCounter class.
 */
public class FibonacciCounterTest {
  private FibonacciCounter fibonacciCounter;
  
  /**
   * Setup the objects to test the class.
   */
  @Before
  public void setup() {
    fibonacciCounter = new FibonacciCounter(3);
  }
  
  /**
   * Test method getCount.
   */
  @Test
  public void testGetCount() {
    assertEquals(3, fibonacciCounter.getCount(), 0.01);
  }
  
  /**
   * Test method getCount when the argument is illegal.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalGetCount() {
    new FibonacciCounter(-1);
  }
  
  /**
   * Test method getNumber.
   */
  @Test
  public void testGetNumber() {
    assertEquals(2, fibonacciCounter.getNumber(), 0.01);
  }
  
  /**
   * Test method increment.
   */
  @Test
  public void testIncrement() {
    assertEquals(4, fibonacciCounter.increment().getCount(), 0.01);
  }
  
  /**
   * Test method decrement.
   */
  @Test 
  public void testDecrement() {
    assertEquals(2, fibonacciCounter.decrement().getCount(), 0.01);
    FibonacciCounter fibonacciCounter2 = new FibonacciCounter(0);
    assertEquals(0, fibonacciCounter2.decrement().getCount(), 0.01);
  }
  
}