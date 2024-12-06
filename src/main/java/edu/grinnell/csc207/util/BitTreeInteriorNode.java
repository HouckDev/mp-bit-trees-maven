package edu.grinnell.csc207.util;

/**
 * A node of a bittree.
 */
public class BitTreeInteriorNode implements BitTreeNode {
  /**
   * Left child of this node.
   */
  private BitTreeNode leftChild;

  /**
   * @param leftChild
   */
  public void setLeftChild(BitTreeNode leftChild) {
    this.leftChild = leftChild;
  } // setLeftChild

  /**
   * @return the left child node
   */
  public BitTreeNode getLeftChild() {
    return leftChild;
  } // getLeftChild

  /**
   * The right child of this node.
   */
  private BitTreeNode rightChild;

  /**
   * @param rightChild
   */
  public void setRightChild(BitTreeNode rightChild) {
    this.rightChild = rightChild;
  } // setRightChild

  /**
   * @return the right child node
   */
  public BitTreeNode getRightChild() {
    return rightChild;
  } // getRightChild

} // BitTreeInteriorNode
