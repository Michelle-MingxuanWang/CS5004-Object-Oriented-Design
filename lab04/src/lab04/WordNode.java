package lab04;

/**
 * This class represents an class WordNode which
 * extends the GenericNode abstract class.
 */
public class WordNode extends GenericNode {
  
  /**
   * Constructs a WordNode object and initialize it to the
   * given string.
   * 
   * @param value the string of the node
   */
  public WordNode(String value) {
    super(value);
  }
  
  @Override
  /**
   * Whether the node is a empty node.
   */
  public boolean isEmpty() {
    return false;
  }
  
  @Override
  /**
   * Whether the node is a word node.
   */
  public boolean isWord() {
    return true;
  }
  
}