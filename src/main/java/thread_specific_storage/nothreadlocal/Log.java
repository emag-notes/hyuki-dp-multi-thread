package thread_specific_storage.nothreadlocal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Yoshimasa Tanabe
 */
public class Log {

  private static PrintWriter writer = null;

  static {
    try {
      writer = new PrintWriter(new FileWriter("build/log.txt"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void println(String s) {
    writer.println(s);
  }

  public static void close() {
    writer.println("=== ENd of log ===");
    writer.close();
  }

}
