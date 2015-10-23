package two_phase_termination;

import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class CountUpThread extends GracefulThread {

  private long counter = 0;

  protected void doWork() throws InterruptedException {
    counter++;
    System.out.println("doWork: counter = " + counter);
    TimeUnit.MILLISECONDS.sleep(500);
  }

  protected void doShutdown() {
    System.out.println("doShutdown: counter = " + counter);
  }

}
