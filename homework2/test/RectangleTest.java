

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

/**
 * A JUnit test class for the Rectangle class.
 */
public class RectangleTest {
  
  private Rectangle rectangle;
  
  @Before
  public void setup() {
    rectangle = new Rectangle(2, 3, 3, 2);
  }
  
  /**
   * This test test the constructor and the toString method.
   */
  @Test
  public void testToString() {
    assertEquals("x:2, y:3, w:3, h:2", rectangle.toString());
  }
  
  /**
   * Test the overlap method when the x and y coordinate of one of the rectangle is 0.
   */
  @Test
  public void testOverlapZero() {
    Rectangle rectangleZero = new Rectangle(0, 0, 3, 4);
    assertEquals(true, rectangle.overlap(rectangleZero));
    assertEquals(true, rectangleZero.overlap(rectangle));
  }

  /**
   * Test the overlap method when the x and y coordinate of one of the rectangle is negative.
   */
  @Test
  public void testOverlapNegative() {
    Rectangle rectangleNegative = new Rectangle(-1, -2, 4, 6);
    assertEquals(true, rectangle.overlap(rectangleNegative));
    assertEquals(true, rectangleNegative.overlap(rectangle));
  }
  
  /**
   * Test the overlap method when two rectangles are overlapped by their corner.
   */
  @Test
  public void testOverlapCorner() {
    Rectangle rectangleLowerRight = new Rectangle(4, 1, 3, 3);
    Rectangle rectangleUpperLeft = new Rectangle(0, 4, 3, 3);
    assertEquals(true, rectangle.overlap(rectangleLowerRight));
    assertEquals(true, rectangleLowerRight.overlap(rectangle));
    assertEquals(true, rectangle.overlap(rectangleUpperLeft));
    assertEquals(true, rectangleUpperLeft.overlap(rectangle));
  }
  
  /**
   * Test the overlap method when two rectangles are overlapped by 
   * one of their edges and the overlapping edge of the other rectangle 
   * is smaller than the current rectangle. 
   */
  @Test
  public void testOverlapEdgeSmaller() {
    Rectangle rectangleUp = new Rectangle(3, 4, 1, 2);
    Rectangle rectangleRight = new Rectangle(4, 4, 2, 1);
    assertEquals(true, rectangle.overlap(rectangleUp));
    assertEquals(true, rectangleUp.overlap(rectangle));
    assertEquals(true, rectangle.overlap(rectangleRight));
    assertEquals(true, rectangleRight.overlap(rectangle));
  }
  
  /**
   * Test the overlap method when two rectangles are overlapped by 
   * one of their edges and the overlapping edge of the other rectangle 
   * is larger than the current rectangle. 
   */
  @Test
  public void testOverlapEdgeLarger() {
    Rectangle rectangleDown = new Rectangle(1, 1, 5, 3);
    Rectangle rectangleRight = new Rectangle(3, 1, 4, 5);
    assertEquals(true, rectangle.overlap(rectangleDown));
    assertEquals(true, rectangle.overlap(rectangleRight));
  }
  
  /**
   * Test the overlap method when one of the rectangles are included in the other.  
   */
  @Test
  public void testOverlapInclude() {
    Rectangle rectangleOutside = new Rectangle(-1, 2, 8, 4);
    assertEquals(true, rectangle.overlap(rectangleOutside));
    assertEquals(true, rectangleOutside.overlap(rectangle));
  }
  
  /**
   * Test the overlap method when one of the rectangles are included in the other
   * and touches edges of the other.  
   */
  @Test
  public void testOverlapIncludeTouch() {
    Rectangle rectangleOutside = new Rectangle(2, 3, 6, 6);
    assertEquals(true, rectangle.overlap(rectangleOutside));
    assertEquals(true, rectangleOutside.overlap(rectangle));
  }
  
  /**
   * Test the overlap method when two rectangles are equal.
   */
  @Test
  public void testOverlapEqual() {
    assertEquals(true, rectangle.overlap(rectangle));
  }
  
  /**
   * Test the overlap method when all corresponding edges 
   * of the two rectangles are parallel.
   */
  @Test
  public void testOverlapParrallel() {
    Rectangle rectangleUp = new Rectangle(2, 4, 3, 3);
    Rectangle rectangleRight = new Rectangle(3, 3, 3, 2);
    assertEquals(true, rectangle.overlap(rectangleUp));
    assertEquals(true, rectangleUp.overlap(rectangle));
    assertEquals(true, rectangle.overlap(rectangleRight));
    assertEquals(true, rectangleRight.overlap(rectangle));
  }
  
  /**
   * Test the overlap method when two rectangles are separated.
   */
  @Test
  public void testOverlapSeparate() {
    Rectangle rectangleUp = new Rectangle(2, 7, 2, 3);
    Rectangle rectangleRight = new Rectangle(7, 4, 3, 2);
    assertEquals(false, rectangle.overlap(rectangleUp));
    assertEquals(false, rectangleUp.overlap(rectangle));
    assertEquals(false, rectangle.overlap(rectangleRight));
    assertEquals(false, rectangleRight.overlap(rectangle));
  }
  
  /**
   * Test the overlap method when two rectangles touch each other.
   */
  @Test
  public void testOverlapTouch() {
    Rectangle rectangleUp = new Rectangle(3, 5, 3, 4);
    Rectangle rectangleRight = new Rectangle(5, 2, 3, 2);
    assertEquals(false, rectangle.overlap(rectangleUp));
    assertEquals(false, rectangleUp.overlap(rectangle));
    assertEquals(false, rectangle.overlap(rectangleRight));
    assertEquals(false, rectangleRight.overlap(rectangle));
  }

  /**
   * Test the intersect method when the x and y coordinate of one of the rectangle is 0.
   */
  @Test
  public void testIntersectZero() {
    Rectangle rectangleZero = new Rectangle(0, 0, 3, 4);
    assertEquals("x:2, y:3, w:1, h:1", rectangle.intersect(rectangleZero).toString());
    assertEquals("x:2, y:3, w:1, h:1", rectangleZero.intersect(rectangle).toString());
  }

  /**
   * Test the intersect method when the x and y coordinate of one of the rectangle is negative.
   */
  @Test
  public void testIntersectNegative() {
    Rectangle rectangleNegative = new Rectangle(-1, -2, 4, 6);
    assertEquals("x:2, y:3, w:1, h:1", rectangle.intersect(rectangleNegative).toString());
    assertEquals("x:2, y:3, w:1, h:1", rectangleNegative.intersect(rectangle).toString());
  }
  
  /**
   * Test the intersect method when two rectangles are intersected by their corner.
   */
  @Test
  public void testIntersectCorner() {
    Rectangle rectangleLowerRight = new Rectangle(4, 1, 3, 3);
    Rectangle rectangleUpperLeft = new Rectangle(0, 4, 3, 3);
    assertEquals("x:4, y:3, w:1, h:1", rectangle.intersect(rectangleLowerRight).toString());
    assertEquals("x:4, y:3, w:1, h:1", rectangleLowerRight.intersect(rectangle).toString());
    assertEquals("x:2, y:4, w:1, h:1", rectangle.intersect(rectangleUpperLeft).toString());
    assertEquals("x:2, y:4, w:1, h:1", rectangleUpperLeft.intersect(rectangle).toString());
  }
  
  /**
   * Test the intersect method when two rectangles are intersected by 
   * one of their edges and the intersecting edge of the other rectangle 
   * is smaller than the current rectangle. 
   */
  @Test
  public void testIntersectEdgeSmaller() {
    Rectangle rectangleUp = new Rectangle(3, 4, 1, 2);
    Rectangle rectangleRight = new Rectangle(4, 4, 2, 1);
    assertEquals("x:3, y:4, w:1, h:1", rectangle.intersect(rectangleUp).toString());
    assertEquals("x:3, y:4, w:1, h:1", rectangleUp.intersect(rectangle).toString());
    assertEquals("x:4, y:4, w:1, h:1", rectangle.intersect(rectangleRight).toString());
    assertEquals("x:4, y:4, w:1, h:1", rectangleRight.intersect(rectangle).toString());
  }
  
  /**
   * Test the intersect method when two rectangles are intersected by 
   * one of their edges and the intersecting edge of the other rectangle 
   * is larger than the current rectangle. 
   */
  @Test
  public void testIntersectEdgeLarger() {
    Rectangle rectangleDown = new Rectangle(1, 1, 5, 3);
    Rectangle rectangleRight = new Rectangle(3, 1, 4, 5);
    assertEquals("x:2, y:3, w:3, h:1", rectangle.intersect(rectangleDown).toString());
    assertEquals("x:2, y:3, w:3, h:1", rectangleDown.intersect(rectangle).toString());
    assertEquals("x:3, y:3, w:2, h:2", rectangle.intersect(rectangleRight).toString());
    assertEquals("x:3, y:3, w:2, h:2", rectangleRight.intersect(rectangle).toString());
  }
  
  /**
   * Test the intersect method when one of the rectangles are included in the other.  
   */
  @Test
  public void testIntersectInclude() {
    Rectangle rectangleOutside = new Rectangle(-1, 2, 8, 4);
    assertEquals("x:2, y:3, w:3, h:2", rectangle.intersect(rectangleOutside).toString());
    assertEquals("x:2, y:3, w:3, h:2", rectangleOutside.intersect(rectangle).toString());
  }
  
  /**
   * Test the intersect method when one of the rectangles are included in the other
   * and touches edges of the other.  
   */
  @Test
  public void testIntersectIncludeTouch() {
    Rectangle rectangleOutside = new Rectangle(2, 3, 6, 6);
    assertEquals("x:2, y:3, w:3, h:2", rectangle.intersect(rectangleOutside).toString());
    assertEquals("x:2, y:3, w:3, h:2", rectangleOutside.intersect(rectangle).toString());
  }
  
  /**
   * Test the intersect method when two rectangles are equal.
   */
  @Test
  public void testIntersectEqual() {
    assertEquals("x:2, y:3, w:3, h:2", rectangle.intersect(rectangle).toString());
  }
  
  /**
   * Test the intersect method when all corresponding edges 
   * of the two rectangles are parallel.
   */
  @Test
  public void testIntersectParrallel() {
    Rectangle rectangleUp = new Rectangle(2, 4, 3, 3);
    Rectangle rectangleRight = new Rectangle(3, 3, 3, 2);
    assertEquals("x:2, y:4, w:3, h:1", rectangle.intersect(rectangleUp).toString());
    assertEquals("x:2, y:4, w:3, h:1", rectangleUp.intersect(rectangle).toString());
    assertEquals("x:3, y:3, w:2, h:2", rectangle.intersect(rectangleRight).toString());
    assertEquals("x:3, y:3, w:2, h:2", rectangleRight.intersect(rectangle).toString());
  }
  
  /**
   * Test whether the intersect can correctly throw exception when 
   * two rectangles are separated. 
   */
  @Test(expected = NoSuchElementException.class)
  public void testIllegalIntersectSeparate() {
    Rectangle rectangleUp = new Rectangle(2, 7, 2, 3);
    rectangle.intersect(rectangleUp);
  }
  
  /**
   * Test whether the intersect can correctly throw exception when 
   * two rectangles touch each other.
   */
  @Test (expected = NoSuchElementException.class)
  public void testIllegalIntersectTouch() {
    Rectangle rectangleUp = new Rectangle(3, 5, 3, 4);
    rectangle.intersect(rectangleUp);
  }

  /**
   * Test the union method when the x and y coordinate of one of the rectangle is 0.
   */
  @Test
  public void testUnionZero() {
    Rectangle rectangleZero = new Rectangle(0, 0, 3, 4);
    assertEquals("x:0, y:0, w:5, h:5", rectangle.union(rectangleZero).toString());
    assertEquals("x:0, y:0, w:5, h:5", rectangleZero.union(rectangle).toString());
  }

  /**
   * Test the union method when the x and y coordinate of one of the rectangle is negative.
   */
  @Test
  public void testUnionNegative() {
    Rectangle rectangleNegative = new Rectangle(-1, -2, 4, 6);
    assertEquals("x:-1, y:-2, w:6, h:7", rectangle.union(rectangleNegative).toString());
    assertEquals("x:-1, y:-2, w:6, h:7", rectangleNegative.union(rectangle).toString());
  }
  
  /**
   * Test the union method when two rectangles are overlapped by their corner.
   */
  @Test
  public void testUnionCorner() {
    Rectangle rectangleLowerRight = new Rectangle(4, 1, 3, 3);
    Rectangle rectangleUpperLeft = new Rectangle(0, 4, 3, 3);
    assertEquals("x:2, y:1, w:5, h:4", rectangle.union(rectangleLowerRight).toString());
    assertEquals("x:2, y:1, w:5, h:4", rectangleLowerRight.union(rectangle).toString());
    assertEquals("x:0, y:3, w:5, h:4", rectangle.union(rectangleUpperLeft).toString());
    assertEquals("x:0, y:3, w:5, h:4", rectangleUpperLeft.union(rectangle).toString());
  }
  
  /**
   * Test the union method when two rectangles are overlapped by 
   * one of their edges and the overlapping edge of the other rectangle 
   * is smaller than the current rectangle. 
   */
  @Test
  public void testUnionEdgeSmaller() {
    Rectangle rectangleUp = new Rectangle(3, 4, 1, 2);
    Rectangle rectangleRight = new Rectangle(4, 4, 2, 1);
    assertEquals("x:2, y:3, w:3, h:3", rectangle.union(rectangleUp).toString());
    assertEquals("x:2, y:3, w:3, h:3", rectangleUp.union(rectangle).toString());
    assertEquals("x:2, y:3, w:4, h:2", rectangle.union(rectangleRight).toString());
    assertEquals("x:2, y:3, w:4, h:2", rectangleRight.union(rectangle).toString());
  }
  
  /**
   * Test the union method when two rectangles are overlapped by 
   * one of their edges and the overlapping edge of the other rectangle 
   * is larger than the current rectangle. 
   */
  @Test
  public void testUnionEdgeLarger() {
    Rectangle rectangleDown = new Rectangle(1, 1, 5, 3);
    Rectangle rectangleRight = new Rectangle(3, 1, 4, 5);
    assertEquals("x:1, y:1, w:5, h:4", rectangle.union(rectangleDown).toString());
    assertEquals("x:1, y:1, w:5, h:4", rectangleDown.union(rectangle).toString());
    assertEquals("x:2, y:1, w:5, h:5", rectangle.union(rectangleRight).toString());
    assertEquals("x:2, y:1, w:5, h:5", rectangleRight.union(rectangle).toString());
  }
  
  /**
   * Test the union method when one of the rectangles are included in the other.  
   */
  @Test
  public void testUnionInclude() {
    Rectangle rectangleOutside = new Rectangle(-1, 2, 8, 4);
    assertEquals("x:-1, y:2, w:8, h:4", rectangle.union(rectangleOutside).toString());
    assertEquals("x:-1, y:2, w:8, h:4", rectangleOutside.union(rectangle).toString());
  }
  
  /**
   * Test the union method when one of the rectangles are included in the other
   * and touches edges of the other.  
   */
  @Test
  public void testUnionIncludeTouch() {
    Rectangle rectangleOutside = new Rectangle(2, 3, 6, 6);
    assertEquals("x:2, y:3, w:6, h:6", rectangle.union(rectangleOutside).toString());
    assertEquals("x:2, y:3, w:6, h:6", rectangleOutside.union(rectangle).toString());
  }
  
  /**
   * Test the union method when two rectangles are equal.
   */
  @Test
  public void testUnionEqual() {
    assertEquals("x:2, y:3, w:3, h:2", rectangle.union(rectangle).toString());
  }
  
  /**
   * Test the union method when all corresponding edges 
   * of the two rectangles are parallel.
   */
  @Test
  public void testUnionParrallel() {
    Rectangle rectangleUp = new Rectangle(2, 4, 3, 3);
    Rectangle rectangleRight = new Rectangle(3, 3, 3, 2);
    assertEquals("x:2, y:3, w:3, h:4", rectangle.union(rectangleUp).toString());
    assertEquals("x:2, y:3, w:3, h:4", rectangleUp.union(rectangle).toString());
    assertEquals("x:2, y:3, w:4, h:2", rectangle.union(rectangleRight).toString());
    assertEquals("x:2, y:3, w:4, h:2", rectangleRight.union(rectangle).toString());
  }
  
  /**
   * Test whether the union method when two rectangles are separated. 
   */
  @Test
  public void testUnionSeparate() {
    Rectangle rectangleUp = new Rectangle(2, 7, 2, 3);
    Rectangle rectangleRight = new Rectangle(7, 4, 3, 2);
    assertEquals("x:2, y:3, w:3, h:7", rectangle.union(rectangleUp).toString());
    assertEquals("x:2, y:3, w:3, h:7", rectangleUp.union(rectangle).toString());
    assertEquals("x:2, y:3, w:8, h:3", rectangle.union(rectangleRight).toString());
    assertEquals("x:2, y:3, w:8, h:3", rectangleRight.union(rectangle).toString());
  }
  
  /**
   * Test the union method when two rectangles touch each other.
   */
  @Test
  public void testUnionTouch() {
    Rectangle rectangleUp = new Rectangle(3, 5, 3, 4);
    Rectangle rectangleRight = new Rectangle(5, 2, 3, 2);
    assertEquals("x:2, y:3, w:4, h:6", rectangle.union(rectangleUp).toString());
    assertEquals("x:2, y:3, w:4, h:6", rectangleUp.union(rectangle).toString());
    assertEquals("x:2, y:2, w:6, h:3", rectangle.union(rectangleRight).toString());
    assertEquals("x:2, y:2, w:6, h:3", rectangleRight.union(rectangle).toString());

  }

}
