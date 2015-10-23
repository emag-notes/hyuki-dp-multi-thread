package two_phase_termination.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  private static final int TASKS = 10;

  public static void main(String[] args) {
    System.out.println("BEGIN");

    ExecutorService service = Executors.newFixedThreadPool(5);
    CountDownLatch doneLatch = new CountDownLatch(TASKS);

    try {
      for (int t = 0; t < TASKS; t++) {
        service.execute(new MyTask(doneLatch, t));
      }
      System.out.println("AWAIT");
      doneLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      service.shutdown();
      System.out.println("END");
    }

  }
}
