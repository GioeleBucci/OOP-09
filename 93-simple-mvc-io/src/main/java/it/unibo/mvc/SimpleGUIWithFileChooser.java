package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

  private static final int PROPORTION = 4;

  private final JFrame frame = new JFrame();
  private final JFileChooser fileChooser = new JFileChooser();

  public SimpleGUIWithFileChooser(Controller controller) {
    frame.setTitle("My second Java graphical interface");
    final JPanel canvas = new JPanel();
    canvas.setLayout(new BorderLayout());
    final JPanel secondaryCanvas = new JPanel();
    secondaryCanvas.setLayout(new BorderLayout());
    canvas.add(secondaryCanvas, BorderLayout.NORTH);
    // this field should display the currently selected file path
    final JTextField textField = new JTextField(controller.getFilePath());
    textField.setEditable(false);
    secondaryCanvas.add(textField, BorderLayout.CENTER);
    final JButton browseBtn = new JButton("Browse");
    secondaryCanvas.add(browseBtn, BorderLayout.LINE_END);
    final JTextArea textArea = new JTextArea();
    canvas.add(textArea);
    final JButton saveBtn = new JButton("Save");
    canvas.add(saveBtn, BorderLayout.SOUTH);
    frame.setContentPane(canvas);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    browseBtn.addActionListener(e -> {
      int action = fileChooser.showSaveDialog(null);
      switch (action) {
        case JFileChooser.APPROVE_OPTION:
          controller.setFile(fileChooser.getSelectedFile());
          textField.setText(controller.getFilePath());
          break;
        case JFileChooser.CANCEL_OPTION:
          break;
        default:
          JOptionPane.showMessageDialog(null, "An error has occourred!");
      }
    });

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
    new SimpleGUIWithFileChooser(new Controller()).display();
  }

}
