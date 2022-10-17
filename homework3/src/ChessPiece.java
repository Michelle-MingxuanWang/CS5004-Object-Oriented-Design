

/**
 * Represents a chess piece.
 */
public interface ChessPiece {
  
  /**
   * An enum for the color of the chess piece.
   */
  enum Color {
    BLACK,
    WHITE
  }
  
  /**
   * black and white variable representing the chess color.
   */
  Color black = Color.BLACK;
  Color white = Color.WHITE;
  
  /**
   * Get the row coordinate.
   * @return the row coordinate
   */
  int getRow();
  
  /**
   * Get the column coordinate.
   * @return the row coordinate
   */
  int getColumn();
  
  /**
   * Get the color.
   * @return the color in enum
   */
  Color getColor();
  
  /**
   * Determine whether the chess piece can move to the designated position.
   * @param row the row of the designated position
   * @param col the column of the designated position
   * @return the boolean of whether the chess piece can move to the position.
   */
  boolean canMove(int row, int col);
  
  /**
   * Determine whether the chess piece can kill the designated chess piece.
   * @param piece the chess piece being evaluated to get killed
   * @return the boolean of whether the chess piece can kill the designated 
chess piece.
   */
  boolean canKill(ChessPiece piece);
}
