package balking;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Yoshimasa Tanabe
 */
public class Data {

  private final String fileName;
  private String content;
  private boolean changed;

  public Data(String fileName, String content) {
    this.fileName = fileName;
    this.content = content;
    this.changed = true;
  }

  public synchronized void change(String newContent) {
    content = newContent;
    changed = true;
  }

  public synchronized void save() throws IOException {
    if (!changed) {
      return;
    }
    doSave();
    changed = false;
  }

  private void doSave() throws IOException {
    System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
    try (FileWriter writer = new FileWriter(fileName)) {
      writer.write(content);
      writer.close();
    }
  }

}
