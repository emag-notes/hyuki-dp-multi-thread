package introduction1;

import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class SleepTest {

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.println("Good!");
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
