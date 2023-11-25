package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class SimpleController implements Controller {

  private String currentStr;
  private List<String> history = new ArrayList<>();

  @Override
  public void setStringToPrint(String s) {
    Objects.requireNonNull(s, "cannot set a null value");
    this.currentStr = s;
  }

  @Override
  public String getStringToPrint() {
    return currentStr;
  }

  @Override
  public List<String> getHistory() {
    return List.copyOf(history);
  }

  @Override
  public void printNextString() {
    if (currentStr == null) {
      throw new IllegalStateException("No string has been set");
    }
    history.add(currentStr);
    System.out.println(currentStr);
  }

}
