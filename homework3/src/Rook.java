


/**
 * This class represents a bishop chess piece.
 *
 */
public class Rook extends AbstractChess {
  
  /**
   * Constructs a Rook object and initialize it to the given
row and column coordinates and color.
   * @param row the row coordinate of the chess piece.
   * @param col the column coordinate of the chess piece.
   * @param color the color of the chess piece.
   */
  public Rook(int row, int col, Color color) {
    super(row, col, color);
  }
  
  /**
   * Determine whether the chess piece can move to the designated position.
   * @param row the row of the designated position
   * @param col the column of the designated position
   * @return the boolean of whether the chess piece can move to the position.
   */
  @Override
  public boolean canMove(int row, int col) {
    return this.isVerticalorHorizontal(row, col);
  }
  
  
}
