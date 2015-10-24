package thread_specific_storage.nothreadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("BEGIN");

    for (int i = 0; i < 10; i++) {
      Log.println("main: i = " + i);
      try {
        TimeUnit.MILLISECONDS.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    Log.close();

    System.out.println("END");
  }
}
