package it.unibo.mvc;

import java.util.List;

public interface Controller {

  /**
   * sets next string to print
   * 
   * @param s the string to print
   * @throws NullPointerException if passed string is null
   */
  void setStringToPrint(String s);

  /**
   * get the next string to print
   * 
   * @return the next string that will be printed
   */
  String getStringToPrint();

  /**
   * get all the previously printed strings
   * 
   * @return a list of every string that has been printed
   */
  List<String> getHistory();

  /**
   * print the currently set string.
   * 
   * @throws IllegalStateException if no string is set
   */
  void printNextString();

}
