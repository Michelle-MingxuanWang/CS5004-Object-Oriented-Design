

import org.junit.Before;
import org.junit.Test;

import homework3.ChessPiece.Color;

import static org.junit.Assert.assertEquals;

/**
 * Test for Knight class.
 *
 */
public class KnightTest {
  
  private Knight knight;
  private Color black;
  private Color white;
  
  /**
   * Setup the test objects.
   */
  @Before
  public void setup() {
    black = Color.BLACK;
    white = Color.WHITE;
    knight = new Knight(2, 3, black);
  }
  
  /**
   * Test the getter methods.
   */
  @Test
  public void testGetter() {
    assertEquals(2, knight.getRow());
    assertEquals(3, knight.getColumn());
    assertEquals(black, knight.getColor());
  }
  
  /**
   * Test the canMove method when the return value should be 
true or false.
   */
  @Test
  public void testCanMove() {
    assertEquals(true, knight.canMove(1, 1));
    assertEquals(false, knight.canMove(1, 2));
  }
  
  /**
   * Test whether the canMove method can successfully throw error 
when the indexes are larger than the upper bound.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalCanMoveBoundUpper() {
    knight.canMove(9, 10);
  }
  
  /**
   * Test whether the canMove method can successfully throw exception 
when the indexes are smaller than the lower bound.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalCanMoveBoundLower() {
    knight.canMove(-1, -2);
  }
  
  /**
   * Test whether the canMove method can successfully throw 
exception when the designated position is the same with the
original position.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalCanMoveNotMove() {
    knight.canMove(2, 3);
  }
  
  /**
   * Test the canKill method when the piece is the same or 
different color.
   */
  @Test
  public void testCanKill() {
    Knight otherWhite1 = new Knight(1, 1, white);
    Knight otherWhite2 = new Knight(1, 2, white);
    
    Knight otherBlack1 = new Knight(1, 1, black);
    Knight otherBlack2 = new Knight(1, 2, black);
    
    assertEquals(true, knight.canKill(otherWhite1));
    assertEquals(true, otherWhite1.canKill(knight));
    assertEquals(false, knight.canKill(otherWhite2));
    assertEquals(false, otherWhite2.canKill(knight));
    
    assertEquals(false, knight.canKill(otherBlack1));
    assertEquals(false, otherBlack1.canKill(knight));
    assertEquals(false, knight.canKill(otherBlack2));
    assertEquals(false, otherBlack2.canKill(knight));
  }
  
}

