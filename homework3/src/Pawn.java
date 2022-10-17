


/**
 * This class represents a pawn chess piece.
 *
 */
public class Pawn extends AbstractChess {
  
  /**
   * Constructs a Pawn object and initialize it to the given
row and column coordinates and color.
   * @param row the row coordinate of the chess piece.
   * @param col the column coordinate of the chess piece.
   * @param color the color of the chess piece.
   */
  public Pawn(int row, int col, Color color) {
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
    
    if (this.getColor() == black) {
      return this.columnDiff(col) == -1 && this.rowAbsDiff(row) == 0;
    }
    else {
      return this.columnDiff(col) == 1 && this.rowAbsDiff(row) == 0;
    }
    
  }
  
  /**
   * Determine whether the chess piece can kill the designated chess piece.
   * @param piece the chess piece being evaluated to get killed
   * @return the boolean of whether the chess piece can kill the designated 
chess piece.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    if (this.getColor() == piece.getColor()) {
      return false;
    }
    if (this.getColor() == black) {
      return (this.columnDiff(piece.getColumn()) == -1) && 
          (this.rowAbsDiff(piece.getRow()) == 1);
    }
    else {
      return (this.columnDiff(piece.getColumn()) == 1) && 
          (this.rowAbsDiff(piece.getRow()) == 1);
    }
  }
  
  /**
   * Calculate the difference of a column position and this 
chess piece's column position.
   * @param col the column position
   * @return the difference of column position
   */
  private int columnDiff(int col) {
    return col - this.getColumn();
  }
  
  /**
   * Calculate the absolute value of difference of a row position and
this chess piece's row position.
   * @param row the row position
   * @return the absolute value of difference of row position
   */
  private int rowAbsDiff(int row) {
    return Math.abs(row - this.getRow());
  }
  
  
}
