

import org.junit.Before;
import org.junit.Test;

import homework3.ChessPiece.Color;

import static org.junit.Assert.assertEquals;

/**
 * Test for Pawn class.
 *
 */
public class PawnTest {
  
  private Pawn pawn;
  private Color black;
  private Color white;
  
  /**
   * Setup the test objects.
   */
  @Before
  public void setup() {
    black = Color.BLACK;
    white = Color.WHITE;
    pawn = new Pawn(2, 3, black);
  }
  
  /**
   * Test the getter methods.
   */
  @Test
  public void testGetter() {
    assertEquals(2, pawn.getRow());
    assertEquals(3, pawn.getColumn());
    assertEquals(black, pawn.getColor());
  }
  
  /**
   * Test the canMove method when the return value should be 
true or false.
   */
  @Test
  public void testCanMove() {
    Pawn pawnWhite = new Pawn(2, 3, white);
    assertEquals(true, pawn.canMove(2, 2));
    assertEquals(false, pawn.canMove(2, 4));
    assertEquals(false, pawn.canMove(3, 2));
    assertEquals(false, pawn.canMove(3, 3));
    
    assertEquals(true, pawnWhite.canMove(2, 4));
    assertEquals(false, pawnWhite.canMove(2, 2));
    assertEquals(false, pawnWhite.canMove(3, 4));
    assertEquals(false, pawnWhite.canMove(3, 3));
  }
  
  /**
   * Test whether the canMove method can successfully throw error 
when the indexes are larger than the upper bound.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalCanMoveBoundUpper() {
    pawn.canMove(9, 10);
  }
  
  /**
   * Test whether the canMove method can successfully throw exception 
when the indexes are smaller than the lower bound.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalCanMoveBoundLower() {
    pawn.canMove(-1, -2);
  }
  
  /**
   * Test whether the canMove method can successfully throw 
exception when the designated position is the same with the
original position.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalCanMoveNotMove() {
    pawn.canMove(2, 3);
  }
  
  /**
   * Test the canKill method when the piece is the same or 
different color.
   */
  @Test
  public void testCanKill() {
    Pawn otherWhite1 = new Pawn(3, 4, white);
    Pawn otherWhite2 = new Pawn(3, 2, white);
    Pawn otherWhite3 = new Pawn(2, 4, white);
    Pawn otherWhite4 = new Pawn(2, 2, white);
    
    Pawn otherBlack1 = new Pawn(3, 4, black);
    Pawn otherBlack2 = new Pawn(3, 2, black);
    Pawn otherBlack3 = new Pawn(2, 4, black);
    Pawn otherBlack4 = new Pawn(2, 2, black);
    
    assertEquals(false, pawn.canKill(otherWhite1));
    assertEquals(false, otherWhite1.canKill(pawn));
    assertEquals(true, pawn.canKill(otherWhite2));
    assertEquals(true, otherWhite2.canKill(pawn));
    assertEquals(false, pawn.canKill(otherWhite3));
    assertEquals(false, otherWhite3.canKill(pawn));
    assertEquals(false, pawn.canKill(otherWhite4));
    assertEquals(false, otherWhite4.canKill(pawn));
    
    assertEquals(false, pawn.canKill(otherBlack1));
    assertEquals(false, otherBlack1.canKill(pawn));
    assertEquals(false, pawn.canKill(otherBlack2));
    assertEquals(false, otherBlack2.canKill(pawn));
    assertEquals(false, pawn.canKill(otherBlack3));
    assertEquals(false, otherBlack3.canKill(pawn));
    assertEquals(false, pawn.canKill(otherBlack4));
    assertEquals(false, otherBlack4.canKill(pawn));
  }
  
}

