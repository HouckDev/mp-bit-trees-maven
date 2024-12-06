package edu.grinnell.csc207.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Trees intended to be used in storing mappings between fixed-length sequences of bits and
 * corresponding values.
 *
 * @author Your Name Here
 */
public class BitTree {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  /**
   * Root of this tree.
   */
  BitTreeNode root;
  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * @param n
   */
  public BitTree(int n) {
    root = populate("", n);
  } // BitTree(int)

  // +---------------+-----------------------------------------------
  // | Local helpers |
  // +---------------+
  /**
   * @param bits
   * @param depth
   * @return populated node
   */
  public BitTreeNode populate(String bits, int depth) {
    if (depth <= 0) {
      return new BitTreeLeaf(bits, "");
    } // if
    BitTreeInteriorNode temp = new BitTreeInteriorNode();
    temp.setLeftChild(populate(bits + "0", depth - 1));
    temp.setRightChild(populate(bits + "1", depth - 1));
    return temp;

  } // populate
  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * @param bits
   * @param value
   */
  public void set(String bits, String value) {
    BitTreeNode traversalNode = root;
    for (int i = 0; i <= bits.length(); i++) {
      if (traversalNode instanceof BitTreeInteriorNode) {
        if (bits.charAt(i) == '0') {
          traversalNode = ((BitTreeInteriorNode) traversalNode).getLeftChild();
        } else {
          traversalNode = ((BitTreeInteriorNode) traversalNode).getRightChild();

        } // else if
      } else if (traversalNode instanceof BitTreeLeaf) {
        ((BitTreeLeaf) traversalNode).setValue(value);
        return;
      } // else if
    } // for
  } // set(String, String)

  /**
   * @param bits
   * @return The stored value
   */
  public String get(String bits) {
    BitTreeNode traversalNode = root;
    for (int i = 0; i <= bits.length(); i++) {
      if (traversalNode instanceof BitTreeInteriorNode) {
        if (bits.charAt(i) == '0') {
          traversalNode = ((BitTreeInteriorNode) traversalNode).getLeftChild();
        } else {
          traversalNode = ((BitTreeInteriorNode) traversalNode).getRightChild();

        } // else if
      } else if (traversalNode instanceof BitTreeLeaf) {
        return ((BitTreeLeaf) traversalNode).getValue();
      } // else if
    } // for
    return "";
  } // get(String, String)

  /**
   * @param pen
   */
  public void dump(PrintWriter pen) {
    dumpHelper(root, pen);
  } // dump(PrintWriter)

  /**
   * @param node
   * @param pen
   */
  public void dumpHelper(BitTreeNode node, PrintWriter pen) {
    if (node instanceof BitTreeInteriorNode) {
      dumpHelper(((BitTreeInteriorNode) node).getLeftChild(), pen);
      dumpHelper(((BitTreeInteriorNode) node).getRightChild(), pen);
    } else if (node instanceof BitTreeLeaf) {
      pen.println(((BitTreeLeaf) node).getKey() + "," + ((BitTreeLeaf) node).getValue());
    } // else if
  } // dumpHelper

  /**
   * @param source
   */
  public void load(InputStream source) {
    BufferedReader tempBufferedReader = new BufferedReader(new InputStreamReader(source));
    String currentLine = "";
    try {
      while ((currentLine = tempBufferedReader.readLine()) != null) {

        set(currentLine.split(",", 2)[0], currentLine.split(",", 2)[1]);
      } // while
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } // try catch

  } // load(InputStream)

} // class BitTree
