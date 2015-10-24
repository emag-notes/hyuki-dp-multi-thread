package thread_specific_storage.threadlocal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Yoshimasa Tanabe
 */
public class TSLog {

  private PrintWriter writer = null;

  public TSLog(String fileName) {
    try {
      writer = new PrintWriter(new FileWriter(fileName));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void println(String s) {
    writer.println(s);
  }

  public void close() {
    writer.println("=== ENd of log ===");
    writer.close();
  }

}
