package future.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class RealData implements Data {

  private final String content;

  public RealData(int count, char c) {
    System.out.println(String.format("        making RealData(%d, %s) BEGIN", count, c));

    char[] buffer = new char[count];
    for (int i = 0; i < count; i++) {
      buffer[i] = c;
      try {
        TimeUnit.MILLISECONDS.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    System.out.println(String.format("        making RealData(%d, %s) END", count, c));
    this.content = new String(buffer);
  }

  @Override
  public String getContent() {
    return content;
  }

}
