package lab01;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * A JUnit test class for the Person class.
 */
public class PersonTest {

  private Person john;
    
  @Before
  public void setUp() {
    EmailAddress john_email;
    john_email = new EmailAddress("john_doe", "northeastern.edu");
    john = new Person("John", "Doe", 1989, 2132132134, john_email);
  }


  
  @Test
  public void testFirst() {
    assertEquals("John", john.getFirstName());
  }

  @Test
  public void testSecond() {
    assertEquals("Doe", john.getLastName());
  }

  @Test
  public void testYearOfBirth() {
    assertEquals(1989, john.getYearOfBirth());
  }
    
  @Test
  public void testPhoneNumber() {
    assertEquals(2132132134, john.getPhoneNumber());
  }

  @Test
  public void testEmailAddress() {
    assertEquals("john_doe", john.getEmailAddress().getUsername());
    assertEquals("northeastern.edu", john.getEmailAddress().getDomain());
  }
  
    
}
