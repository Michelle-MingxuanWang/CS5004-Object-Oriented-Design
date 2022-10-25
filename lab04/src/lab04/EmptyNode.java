package lab04;

/**
 * This class represents an class EmptyNode which
 * extends the GenericNode abstract class.
 */
public class EmptyNode extends GenericNode implements Node{
  
  /**
   * Constructs a EmptyNode object and initialize it to the
   * given string.
   * 
   * @param value the string of the node
   */
  public EmptyNode(String value) {
    super(value);
  }
  
  @Override
  /**
   * Whether the node is a empty node.
   */
  public boolean isEmpty() {
    return true;
  }
  
  @Override
  /**
   * Whether the node is a word node.
   */
  public boolean isWord() {
    return false;
  }
  
}