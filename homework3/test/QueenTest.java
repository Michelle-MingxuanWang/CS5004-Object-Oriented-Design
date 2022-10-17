

import org.junit.Before;
import org.junit.Test;

import homework3.ChessPiece.Color;

import static org.junit.Assert.assertEquals;

/**
 * Test for Queen class.
 *
 */
public class QueenTest {
  
  private Queen queen;
  private Color black;
  private Color white;
  
  /**
   * Setup the test objects.
   */
  @Before
  public void setup() {
    black = Color.BLACK;
    white = Color.WHITE;
    queen = new Queen(2, 3, black);
  }
  
  /**
   * Test the getter methods.
   */
  @Test
  public void testGetter() {
    assertEquals(2, queen.getRow());
    assertEquals(3, queen.getColumn());
    assertEquals(black, queen.getColor());
  }
  
  /**
   * Test the canMove method when the return value should be 
true or false. Include the situation where the queen move 
horizontal or vertically or diagonally.
   */
  @Test
  public void testCanMove() {
    assertEquals(true, queen.canMove(3, 4));
    assertEquals(true, queen.canMove(3, 3));
    assertEquals(false, queen.canMove(4, 4));
  }
  
  /**
   * Test whether the canMove method can successfully throw error 
when the indexes are larger than the upper bound.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalCanMoveBoundUpper() {
    queen.canMove(9, 10);
  }
  
  /**
   * Test whether the canMove method can successfully throw exception 
when the indexes are smaller than the lower bound.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalCanMoveBoundLower() {
    queen.canMove(-1, -2);
  }
  
  /**
   * Test whether the canMove method can successfully throw 
exception when the designated position is the same with the
original position.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalCanMoveNotMove() {
    queen.canMove(2, 3);
  }
  
  /**
   * Test the canKill method when the piece is the same or 
different color. Include the situation where the queen move 
horizontal or vertically or diagonally.
   */
  @Test
  public void testCanKill() {
    Queen otherWhite1 = new Queen(1, 2, white);
    Queen otherWhite2 = new Queen(2, 2, white);
    Queen otherWhite3 = new Queen(1, 1, white);
    
    Queen otherBlack1 = new Queen(1, 2, black);
    Queen otherBlack2 = new Queen(2, 2, black);
    Queen otherBlack3 = new Queen(1, 1, black);  
    
    assertEquals(true, queen.canKill(otherWhite1));
    assertEquals(true, queen.canKill(otherWhite2));
    assertEquals(false, queen.canKill(otherWhite3));
    assertEquals(true, otherWhite1.canKill(queen));
    assertEquals(true, otherWhite2.canKill(queen));
    assertEquals(false, otherWhite3.canKill(queen));
    
    assertEquals(false, queen.canKill(otherBlack1));
    assertEquals(false, queen.canKill(otherBlack2));
    assertEquals(false, queen.canKill(otherBlack3));
    assertEquals(false, otherBlack1.canKill(queen));
    assertEquals(false, otherBlack2.canKill(queen));
    assertEquals(false, otherBlack3.canKill(queen));
  }
  
}

