package lab04;

/**
 * Represents a node.
 *
 */
public interface Node {
  
  //.....
  
  /**
   * Evaluate whether the node is an empty node.
   * @return whether the node is an empty node
   */
  boolean isEmpty();
  
  /**
   * Evaluate whether the node is a word node.
   * @return whether the node is a word node
   */
  boolean isWord();
  
}