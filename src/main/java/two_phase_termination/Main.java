package two_phase_termination;

import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("main: BEGIN");

    try {
      GracefulThread t = new CountUpThread();
      t.start();

      TimeUnit.SECONDS.sleep(10);

      System.out.println("main: shutdownRequest");
      t.shutdownRequest();

      System.out.println("main: join");
      t.join();
    } catch (InterruptedException e) {
//      e.printStackTrace();
    }

    System.out.println("main: END");
  }
}
