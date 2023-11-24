package it.unibo.mvc;

import java.util.List;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;

/**
 * Application entry-point.
 */
public final class LaunchApp {

  private static final int VIEW_AMOUNT = 3;

  private LaunchApp() {
  }

  /**
   * Runs the application.
   *
   * @param args ignored
   * @throws ClassNotFoundException    if the fetches class does not exist
   * @throws NoSuchMethodException     if the 0-ary constructor do not exist
   * @throws InvocationTargetException if the constructor throws exceptions
   * @throws InstantiationException    if the constructor throws exceptions
   * @throws IllegalAccessException    in case of reflection issues
   * @throws IllegalArgumentException  in case of reflection issues
   */
  public static void main(final String... args) throws Exception {
    final var model = new DrawNumberImpl();
    final DrawNumberController app = new DrawNumberControllerImpl(model);

    final String halfClassPath = DrawNumberView.class.getName().replace("View", "").replace("api", "view");
    for (String string : List.of("SwingView", "TerminalView")) {
      String classPath = halfClassPath + string;
      for (int i = 0; i < VIEW_AMOUNT; i++) {
        app.addView((DrawNumberView)  Class.forName(classPath).getConstructor().newInstance());
      }
    }
  }
}
