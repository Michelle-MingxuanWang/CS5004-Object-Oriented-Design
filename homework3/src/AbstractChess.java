


public abstract class AbstractChess implements ChessPiece {
  protected int row;
  protected int col;
  protected Color color;
  
  /**
   * Constructs a abstract chess class.
   * @param row the row coordinate of the chess piece.
   * @param col the column coordinate of the chess piece.
   * @param color the color of the chess piece.
   * @throws IllegalArgumentException if the coordinates are out of bound.
   */
  public AbstractChess(int row, int col, Color color) throws IllegalArgumentException {
    if (!isValidPosition(row, col)) {
      throw new IllegalArgumentException("Index out of bounds");
    }
    this.row = row;
    this.col = col;
    this.color = color;
  }
  
  /**
   * Get the row coordinate.
   * @return the row coordinate
   */
  public int getRow() {
    return this.row;
  }
  
  /**
   * Get the column coordinate.
   * @return the row coordinate
   */
  public int getColumn() {
    return this.col;
  }
  
  /**
   * Get the color.
   * @return the color in enum
   */
  public Color getColor() {
    return this.color;
  }

  /**
   * Determine whether the chess piece can kill the designated chess piece.
   * @param piece the chess piece being evaluated to get killed
   * @return the boolean of whether the chess piece can kill the designated 
chess piece.
   */
  public boolean canKill(ChessPiece piece) {
    if (this.getColor() == piece.getColor()) {
      return false;
    }
    return this.canMove(piece.getRow(),piece.getColumn());
  }
  
  /**
   * Determine whether the designated position is in diagonal position 
with this chess piece.
   * @param row the row coordinate
   * @param col the column coordinate
   * @return the boolean of whether the designated position is in diagonal 
position with this chess piece.
   * @throws IllegalArgumentException when index is out of bound or 
chess did not move.
   */
  protected boolean isDiagonal(int row, int col) throws IllegalArgumentException {
    if (!isValidPosition(row, col)) {
      throw new IllegalArgumentException("Index out of bounds");
    }
    if (this.distance(row, col) == 0) {
      throw new IllegalArgumentException("Chess did not move");
    }
    return Math.abs(row - this.row) == Math.abs(col - this.col);
  }
  
  /**
   * Determine whether the designated position is in vertical or horizontal position 
with this chess piece.
   * @param row the row coordinate
   * @param col the column coordinate
   * @return the boolean of whether the designated position is in vertical or horizontal 
position with this chess piece.
   * @throws IllegalArgumentException when index is out of bound or 
chess did not move.
   */
  protected boolean isVerticalorHorizontal(int row, int col) throws IllegalArgumentException  {
    if (!isValidPosition(row, col)) {
      throw new IllegalArgumentException("Index out of bounds");
    }
    if (this.isSamePosition(row, col)) {
      throw new IllegalArgumentException("Chess did not move");
    }
    return row == this.row || col == this.col;
  }
  
  /**
   * Calculate the distance between this chess piece and the designated position.
   * @param row the row coordinate
   * @param col the column coordinate
   * @return the distance between this chess piece and the designated position
   */
  protected double distance(int row, int col) {
    return Math.sqrt(Math.pow((row - this.row), 2) + Math.pow((col - this.col), 2));
  }
  
  /**
   * Determine whether the position is valid.
   * @param row the row coordinate
   * @param col the column coordinate
   * @return whether the position is valid
   */
  protected boolean isValidPosition(int row, int col) {
    return row >= 0 && col >= 0 && row <= 8 && col <= 8;
  }
  
  /**
   * Determine whether the position is the same.
   * @param row the row coordinate
   * @param col the column coordinate
   * @return whether the position is the same
   */
  protected boolean isSamePosition(int row, int col) {
    return this.distance(row, col) == 0;
  }
  
}
