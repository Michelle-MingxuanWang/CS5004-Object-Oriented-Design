package lab04;

/**
 * This class represents a abstract class GenericNode which
 * implements the Node interface.
 */
public abstract class GenericNode implements Node {
  protected String value;
  protected Node next;
  protected Node pre;
  
  /** 
   * Constructs an abstract node class.
   * @param value the string of the node
   */
  public GenericNode(String value) {
    this.value = value;
  }
  
  /**
   * Get the value of the node.
   * @return the string of the node.
   */
  public String getValue() {
    return this.value;
  }
  
  /**
   * Get the previous node of the node.
   * @return the previous node of the node.
   */
  public Node getPre() {
    return this.pre;
  }
  
  /**
   * Get the next node of the node.
   * @return the next node of the node.
   */
  public Node getNext() {
    return this.next;
  }
  
  /**
   * Update the previous node.
   * @param newPre the new previous node
   * !!throw exception when newPre is empty node
   */
  public void updatePre(Node newPre) {
    this.pre = newPre;
  }
  
  /**
   * Update the next node.
   * @param newNext the new previous node
   * !!throw exception when newNext is empty node
   */
  public void updateNext(Node newNext) {
    this.next = newNext;
  }
  
}