package two_phase_termination.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class MyTask implements Runnable {

  private static final Random RANDOM = new Random(314159);

  private final CountDownLatch doneLatch;
  private final int context;

  public MyTask(CountDownLatch doneLatch, int context) {
    this.doneLatch = doneLatch;
    this.context = context;
  }

  @Override
  public void run() {
    doTask();
    doneLatch.countDown();
  }

  private void doTask() {
    String name = Thread.currentThread().getName();
    System.out.println(name + ":MyTask:BEGIN:context = " + context);
    try {
      TimeUnit.MILLISECONDS.sleep(RANDOM.nextInt(3_000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      System.out.println(name + ":MyTask:END:context = " + context);
    }
  }

}
