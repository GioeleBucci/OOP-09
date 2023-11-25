package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

  private static final int PROPORTION = 4;
  private final JFrame frame = new JFrame();

  public SimpleGUI(SimpleController controller) {
    final JPanel canvas = new JPanel();
    canvas.setLayout(new BorderLayout());

    final JTextField textField = new JTextField("Write here");
    canvas.add(textField, BorderLayout.NORTH);

    final JTextArea textArea = new JTextArea();
    canvas.add(textArea, BorderLayout.CENTER);

    final JPanel buttonsCanvas = new JPanel();
    buttonsCanvas.setLayout(new BorderLayout());
    canvas.add(buttonsCanvas, BorderLayout.SOUTH);

    final JButton printBtn = new JButton("Print");
    buttonsCanvas.add(printBtn, BorderLayout.CENTER);
    final JButton historyBtn = new JButton("Show history");
    buttonsCanvas.add(historyBtn, BorderLayout.LINE_END);
    frame.setContentPane(canvas);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    printBtn.addActionListener(e -> {
      controller.setStringToPrint(textField.getText());
      controller.printNextString();
    });

    historyBtn.addActionListener(e -> textArea.setText(controller.getHistory().toString()));
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
    new SimpleGUI(new SimpleController()).display();
  }

}
