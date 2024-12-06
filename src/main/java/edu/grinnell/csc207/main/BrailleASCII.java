package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.BrailleAsciiTables;

/**
 *
 */
public class BrailleASCII {
  // +------+--------------------------------------------------------
  // | Main |
  // +------+

  /**
   * @throws Exception
   * @param args
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    if (args.length < 1) {
      throw new Exception("Missing Format");
    } // if
    if (args.length < 2) {
      throw new Exception("Missing Input");
    } // if
    String format = args[0];
    String input = args[1];
    switch (format) {
      case "braille":
        for (int i = 0; i < input.length(); i++) {
          try {
            pen.print(BrailleAsciiTables.toBraille(input.charAt(i)));

          } catch (Exception e) {
            pen.println();
            pen.println("Trouble translating because No corresponding value");
            break;
          } // try catch
        } // for
        break;
      case "ascii":
        if (input.length() % 6 != 0) {

          pen.println();
          pen.println("Invalid length of bit string");
          break;
        } // if
        for (int i = 0; i < input.length(); i += 6) {
          try {
            pen.print(BrailleAsciiTables.toAscii(input.substring(i, i + 6)));

          } catch (Exception e) {
            pen.println();
            pen.println("Trouble translating because No corresponding value");
            break;
          } // try catch
        } // for
        break;
      case "unicode":
        for (int i = 0; i < input.length(); i++) {
          try {
            pen.print(BrailleAsciiTables.toUnicode(BrailleAsciiTables.toBraille(input.charAt(i))));

          } catch (Exception e) {
            pen.println();
            pen.println("Trouble translating because No corresponding value");
            break;
          } // try catch
        } // for
        break;
      default:
        throw new Exception("Invalid format");
    } // switch

    pen.close();
  } // main(String[]

} // class BrailleASCII
