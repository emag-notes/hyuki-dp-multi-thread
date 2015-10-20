package thread_per_message;

import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class Helper {

  public void handle(int count, char c) {
    System.out.println(String.format("        handle(%d, %s) BEGIN", count, c));
    for (int i = 0; i < count; i++) {
      slowly();
      System.out.print(c);
    }
    System.out.println();
    System.out.println(String.format("        handle(%d, %s) END", count, c));
  }

  private void slowly() {
    try {
      TimeUnit.MILLISECONDS.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}

