package edu.grinnell.csc207.util;


/**
 * Leaf of a bit tree.
 */
public class BitTreeLeaf implements BitTreeNode {
  /**
   * The key of this node.
   */
  private String key;

  /**
   * @return the key
   */
  public String getKey() {
    return key;
  } // getValue

  /**
   * The stored value.
   */
  private String value;

  /**
   * @param value
   */
  public void setValue(String value) {
    this.value = value;
  } // setValue

  /**
   * @return the value
   */
  public String getValue() {
    return value;
  } // getValue

  /**
   * @param key
   * @param value
   */
  public BitTreeLeaf(String key, String value) {
    this.key = key;
    this.value = value;
  } // BitTreeLeaf
} // BitTreeLeaf
