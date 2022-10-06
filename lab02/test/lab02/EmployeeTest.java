package lab02;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * A JUnit test class for the Employee class.
 */
public class EmployeeTest {
  private Employee employee;
  
  /**
   * Setup the object to test the class.
   */
  @Before
  public void setup() {
    employee = new Employee("Rachel", 0, 40.6);
  }
  
  /**
   * Test method getHoursWorked.
   */
  @Test
  public void testGetHoursWorked() {
    assertEquals(0, employee.getHoursWorked(),0.01);
  }
  
  /**
   * Test method addHoursWorked.
   */
  @Test
  public void testAddHoursWorked() {
    employee.addHoursWorked(36.5);
    assertEquals(36.5, employee.getHoursWorked(), 0.01);
  }
  
  /**
   * Test method resetHoursWorked.
   */
  @Test
  public void testResetHoursWorked() {
    employee.resetHoursWorked();
    assertEquals(0, employee.getHoursWorked(),0.01);
  }
  
  /**
   * Test method getWeeklyCheck.
   */
  @Test
  public void testGetWeeklyCheck() {
    employee.addHoursWorked(36.5);
    PayCheck payCheckRachel = employee.getWeeklyCheck();
    assertEquals("Rachel", payCheckRachel.getName());
    assertEquals(36.5, payCheckRachel.getHours(), 0.01);
    assertEquals(40.6, payCheckRachel.getRate(), 0.01);
    assertEquals(1481.90, payCheckRachel.getTotalPay(), 0.01);
  }
  
  /**
   * Test method toString.
   */
  @Test
  public void testToString() {
    assertEquals("Rachel", employee.toString());
  }
  
  
  
  
  
  
  
  
  
}