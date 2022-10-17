

import org.junit.Before;
import org.junit.Test;

import homework3.ChessPiece.Color;

import static org.junit.Assert.assertEquals;

/**
 * Test for Rook class.
 *
 */
public class RookTest {
  
  private Rook rook;
  private Color black;
  private Color white;
  
  /**
   * Setup the test objects.
   */
  @Before
  public void setup() {
    black = Color.BLACK;
    white = Color.WHITE;
    rook = new Rook(2, 3, black);
  }
  
  /**
   * Test the getter methods.
   */
  @Test
  public void testGetter() {
    assertEquals(2, rook.getRow());
    assertEquals(3, rook.getColumn());
    assertEquals(black, rook.getColor());
  }
  
  /**
   * Test the canMove method when the return value should be 
true or false.
   */
  @Test
  public void testCanMove() {
    assertEquals(true, rook.canMove(3, 3));
    assertEquals(false, rook.canMove(3, 4));
  }
  
  /**
   * Test whether the canMove method can successfully throw error 
when the indexes are larger than the upper bound.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalCanMoveBoundUpper() {
    rook.canMove(9, 10);
  }
  
  /**
   * Test whether the canMove method can successfully throw exception 
when the indexes are smaller than the lower bound.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalCanMoveBoundLower() {
    rook.canMove(-1, -2);
  }
  
  /**
   * Test whether the canMove method can successfully throw 
exception when the designated position is the same with the
original position.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalCanMoveNotMove() {
    rook.canMove(2, 3);
  }
  
  /**
   * Test the canKill method when the piece is the same or 
different color.
   */
  @Test
  public void testCanKill() {
    Rook otherWhite1 = new Rook(3, 3, white);
    Rook otherWhite2 = new Rook(3, 4, white);
    
    Rook otherBlack1 = new Rook(3, 3, black);
    Rook otherBlack2 = new Rook(3, 4, black);
    
    assertEquals(true, rook.canKill(otherWhite1));
    assertEquals(true, otherWhite1.canKill(rook));
    assertEquals(false, rook.canKill(otherWhite2));
    assertEquals(false, otherWhite2.canKill(rook));
    
    assertEquals(false, rook.canKill(otherBlack1));
    assertEquals(false, otherBlack1.canKill(rook));
    assertEquals(false, rook.canKill(otherBlack2));
    assertEquals(false, otherBlack2.canKill(rook));
  }
  
}

