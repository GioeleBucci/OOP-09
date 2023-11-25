package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
  private static final String DEFAULT_FILE_NAME = "output.txt";
  private File file = defaultFile();

  private File defaultFile() {
    return new File(System.getProperty("user.home") + System.getProperty("file.separator") + DEFAULT_FILE_NAME);
  }

  /**
   * sets a file
   * 
   * @param file
   * @throws NullPointerException if passed file is null
   */
  public void setFile(File file) {
    Objects.requireNonNull(file);
    this.file = file;
  }

  public File getFile() {
    return file;
  }

  /**
   * Returns the absolute path of the set file
   * 
   * @return the absolute file path
   */
  public String getFilePath() {
    return file.getAbsolutePath();
  }

  /**
   * write a string of data to the file
   * 
   * @param data the text to write in the file
   */
  public void writeOnFile(String data) throws IOException {
    try (PrintStream ps = new PrintStream(file, StandardCharsets.UTF_8)) {
      ps.println(data);
    }
  }

}
