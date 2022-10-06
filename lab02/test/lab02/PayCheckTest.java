package lab02;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * A JUnit test class for the PayCheck class.
 */
public class PayCheckTest {
  private PayCheck paycheckRachel;
  private PayCheck paycheckTom;
  
  /**
   * Setup the objects to test the class.
   */
  @Before
  public void setup() {
    paycheckRachel = new PayCheck("Rachel", 36.5, 40.6);
    paycheckTom = new PayCheck("Tom", 48.214, 40.335);
  }
  
  /**
   * Test method getName.
   */
  @Test
  public void testGetName() {
    assertEquals("Rachel", paycheckRachel.getName());
  }
  
  /**
   * Test method getHours.
   */
  @Test
  public void testGetHours() {
    assertEquals(36.5, paycheckRachel.getHours(), 0.01);
  }
  
  /**
   * Test method getRate.
   */
  @Test
  public void testGetRate() {
    assertEquals(40.6, paycheckRachel.getRate(), 0.01);
  }
  
  /**
   * Test method getTotalPay.
   */
  @Test
  public void testGetTotalPay() {
    assertEquals(1481.90, paycheckRachel.getTotalPay(), 0.01);
    assertEquals(2110.37, paycheckTom.getTotalPay(), 0.01);
  }
  
  /**
   * Test method toString.
   */
  @Test
  public void testToString() {
    assertEquals("$1481.90", paycheckRachel.toString());
    assertEquals("$2110.37", paycheckTom.toString());
  }
  
}