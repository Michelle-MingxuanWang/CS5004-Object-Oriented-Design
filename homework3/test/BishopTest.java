import org.junit.Before;
import org.junit.Test;

import ChessPiece.Color;

import static org.junit.Assert.assertEquals;

/**
 * Test for Bishop class.
 *
 */
public class BishopTest {
  
  private Bishop bishop;
  private Color black;
  private Color white;
  
  /**
   * Setup the test objects.
   */
  @Before
  public void setup() {
    black = Color.BLACK;
    white = Color.WHITE;
    bishop = new Bishop(2, 3, black);
  }
  
  /**
   * Test the getter methods.
   */
  @Test
  public void testGetter() {
    assertEquals(2, bishop.getRow());
    assertEquals(3, bishop.getColumn());
    assertEquals(black, bishop.getColor());
  }
  
  /**
   * Test the canMove method when the return value should be 
true or false.
   */
  @Test
  public void testCanMove() {
    assertEquals(true, bishop.canMove(3, 4));
    assertEquals(false, bishop.canMove(4, 4));
  }
  
  /**
   * Test whether the canMove method can successfully throw error 
when the indexes are larger than the upper bound.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalCanMoveBoundUpper() {
    bishop.canMove(9, 10);
  }
  
  /**
   * Test whether the canMove method can successfully throw exception 
when the indexes are smaller than the lower bound.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalCanMoveBoundLower() {
    bishop.canMove(-1, -2);
  }
  
  /**
   * Test whether the canMove method can successfully throw 
exception when the designated position is the same with the
original position.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalCanMoveNotMove() {
    bishop.canMove(2, 3);
  }
  
  /**
   * Test the canKill method when the piece is the same or 
different color.
   */
  @Test
  public void testCanKill() {
    Bishop otherWhite1 = new Bishop(1, 2, white);
    Bishop otherWhite2 = new Bishop(2, 2, white);
    
    Bishop otherBlack1 = new Bishop(1, 2, black);
    Bishop otherBlack2 = new Bishop(2, 2, black);
    
    assertEquals(true, bishop.canKill(otherWhite1));
    assertEquals(true, otherWhite1.canKill(bishop));
    assertEquals(false, bishop.canKill(otherWhite2));
    assertEquals(false, otherWhite2.canKill(bishop));
    
    assertEquals(false, bishop.canKill(otherBlack1));
    assertEquals(false, otherBlack1.canKill(bishop));
    assertEquals(false, bishop.canKill(otherBlack2));
    assertEquals(false, otherBlack2.canKill(bishop));
  }
  
}
