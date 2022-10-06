

import java.util.NoSuchElementException;

/**
 * This class represents a rectangle. The rectangle contains the 
 *
 */
public class Rectangle {
  
  private int x;
  private int y;
  private int w;
  private int h;
  
  /**
   * Constructs a Rectangle project and initialize it to the given coordinates, width and height.
   * @param x the x coordinate
   * @param y the y coordinate
   * @param w width of the rectangle
   * @param h height of the rectangle
   * @throws IllegalArgumentException if the width or the height is non-positive
   */
  public Rectangle(int x, int y, int w, int h) throws IllegalArgumentException {
    if (w <= 0 || h <= 0) {
      throw new IllegalArgumentException("Width and height cannot be non-positive");
    }
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
  }

  /**
   * Get the value of the x coordinate.
   * 
   * @return the value of the x coordinate
   */
  private int getX() {
    return x;
  }

  /**
   * Get the value of the y coordinate.
   * 
   * @return the value of the y coordinate
   */
  private int getY() {
    return y;
  }

  /**
   * Get the value of the width of the rectangle.
   * 
   * @return the width of the rectangle
   */
  private int getW() {
    return w;
  }

  /**
   * Get the value of the height of the rectangle.
   * 
   * @return the height of the rectangle
   */
  private int getH() {
    return h;
  }
  
  /**
   * Determine whether the current Rectangle project overlaps with the other Rectangle project.
   * If the x coordinates of the left edge and the right edge or the y coordinates of the up edge 
   * and the down edge are the same, then two rectangles only touch each other but 
   * not overlap with each other. 
   * 
   * @param other the other Rectangle project that needed to be used to determine 
if it is overlapped with the current Rectangle object
   * 
   * @return a boolean of whether the current Rectangle project overlaps with 
the other Rectangle project
   */
  public boolean overlap(Rectangle other) {
    int leftEdgeX = Math.max(this.getX(), other.getX());
    int rightEdgeX = Math.min(this.getX() + this.getW(), other.getX() + other.getW()); 
    int downEdgeY = Math.max(this.getY(), other.getY());
    int upEdgeY = Math.min(this.getY() + this.getH(), other.getY() + other.getH());
    return leftEdgeX < rightEdgeX && downEdgeY < upEdgeY;
  }
  
  /**
   * Return a Rectangle object that represents the overlap of the two rectangles.
   * 
   * @param other the other Rectangle project that needed to be compared to the current 
Rectangle object to find the new overlapped Rectangle object
   * 
   * @return the new Rectangle object that represents the overlap of the two rectangles
@throws NoSuchElementException if the two rectangles do not have intersection
   */
  public Rectangle intersect(Rectangle other) throws NoSuchElementException {
    if (!(this.overlap(other))) {
      throw new NoSuchElementException("The two rectangles do not overlap");
    }
    int leftEdgeX = Math.max(this.getX(), other.getX());
    int rightEdgeX = Math.min(this.getX() + this.getW(), other.getX() + other.getW()); 
    int downEdgeY = Math.max(this.getY(), other.getY());
    int upEdgeY = Math.min(this.getY() + this.getH(), other.getY() + other.getH());
    return new Rectangle(leftEdgeX, downEdgeY, rightEdgeX - leftEdgeX, upEdgeY - downEdgeY);
  }
  
  /**
   * Return a Rectangle object that represents the union of the two rectangles.
   * 
   * @param other the other Rectangle project that needed to be compared to the current 
Rectangle object to find the new Rectangle object represents the union of the two rectangles
     @return the new Rectangle object that represents the union of the two rectangles
   */
  public Rectangle union(Rectangle other) {
    int leftEdgeX = Math.min(this.getX(), other.getX());
    int rightEdgeX = Math.max(this.getX() + this.getW(), other.getX() + other.getW()); 
    int downEdgeY = Math.min(this.getY(), other.getY());
    int upEdgeY = Math.max(this.getY() + this.getH(), other.getY() + other.getH());
    return new Rectangle(leftEdgeX, downEdgeY, rightEdgeX - leftEdgeX, upEdgeY - downEdgeY);
  }
  
  /**
   * Return a string describing the x and y coordinates and the width and heights of the rectangle.
   *
   * @return the string describing the rectangle
   */
  public String toString() {
    return "x:" + this.x + ", y:" + this.y + ", w:" + this.w + ", h:" + this.h;
  }
}
