


/**
 * This class represents a bishop chess piece.
 *
 */
public class Knight extends AbstractChess {
  
  /**
   * Constructs a Knight object and initialize it to the given
row and column coordinates and color.
   * @param row the row coordinate of the chess piece.
   * @param col the column coordinate of the chess piece.
   * @param color the color of the chess piece.
   */
  public Knight(int row, int col, Color color) {
    super(row, col, color);
  }
  
  /**
   * Determine whether the chess piece can move to the designated position.
   * @param row the row of the designated position
   * @param col the column of the designated position
   * @return the boolean of whether the chess piece can move to the position.
   * @throws IllegalArgumentException when index is out of bound or 
chess did not move.
   */
  @Override
  public boolean canMove(int row, int col) throws IllegalArgumentException {
    if (!isValidPosition(row, col)) {
      throw new IllegalArgumentException("Index out of bounds");
    }
    if (this.isSamePosition(row, col)) {
      throw new IllegalArgumentException("Chess did not move");
    }
    return this.distance(row, col) == Math.sqrt(5);
  }
  
  
}
