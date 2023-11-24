package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

/**
 * DrawNumberTerminalView
 */
public class DrawNumberTerminalView implements DrawNumberView {

  @Override
  public void setController(final DrawNumberController observer) {
    // no input needed
  }

  @Override
  public void start() {
    // nothing to set up
  }

  @Override
  public void result(DrawResult res) {
    System.out.println(res.getDescription());
  }

}