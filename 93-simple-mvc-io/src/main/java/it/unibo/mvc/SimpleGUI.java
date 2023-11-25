package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

  private static final int PROPORTION = 4;

  private final JFrame frame = new JFrame();

  public SimpleGUI(Controller controller) {
    frame.setTitle("My first Java graphical interface");
    final JPanel canvas = new JPanel();
    canvas.setLayout(new BorderLayout());
    final JTextArea textArea = new JTextArea("Write here your text");
    canvas.add(textArea, BorderLayout.CENTER);
    final JButton saveBtn = new JButton("Save");
    canvas.add(saveBtn, BorderLayout.SOUTH);
    frame.setContentPane(canvas);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    saveBtn.addActionListener(e -> {
      try {
        controller.writeOnFile(textArea.getText());
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    });
  }

  public void display() {
    final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    final int sw = (int) screen.getWidth();
    final int sh = (int) screen.getHeight();
    frame.setSize(sw / PROPORTION, sh / PROPORTION);
    frame.setLocationByPlatform(true);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    new SimpleGUI(new Controller()).display();
  }
}
