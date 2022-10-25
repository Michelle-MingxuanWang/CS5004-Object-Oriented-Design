package lab04;

/**
 * This class represents an class SentenceImpl which
 * implement the Sentence interface.
 */
public class SentenceImpl implements Sentence {
  private Node head;
  private Node tail;
  private int length;
  private String longestWord;
  
  /**
   * Constructs a SentenceImpl object and initialize it to
   * the given value of length, longestWord, and tail.
   */
  public SentenceImpl() {
    this.length = 0;
    this.longestWord = "";
    this.head = new EmptyNode(""); 
    this.tail = new EmptyNode("");
  }
  
  /**
   * Return the number of words of the sentence.
   * @return the number of words of the sentence
   */
  public int getNumberOfWords() {
    return this.length;
  }
  
  /**
   * Return the longest word of the sentence.
   * @return the longest word of the sentence
   */
  public String longestWord() {
    return this.longestWord;
  }
  
  /**
   * Add a node to the tail of the sentence.
   * @param node the added node
   */
  public void addTail(Node node) {
    if (this.head.isEmpty() == true) {
      this.head = node;
    }
    else {
      this.tail.getPre().updateNext(node);
      node.updateNext(this.tail);
    }
  }
  
  /**
  public String toString() {
    
  } */
  
  /**
  public Sentence clone() {
    
  } */
}