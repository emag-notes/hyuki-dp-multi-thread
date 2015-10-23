package two_phase_termination.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class MyTask implements Runnable {

  private static final int PHASE = 5;
  private static final Random RANDOM = new Random(314159);

  private final CyclicBarrier phaseBarrier;
  private final CountDownLatch doneLatch;
  private final int context;

  public MyTask(CyclicBarrier phaseBarrier, CountDownLatch doneLatch, int context) {
    this.phaseBarrier = phaseBarrier;
    this.doneLatch = doneLatch;
    this.context = context;
  }

  @Override
  public void run() {
    try {
      for (int phase = 0; phase < PHASE; phase++) {
        doPhase(phase);
        phaseBarrier.await();
      }
    } catch (InterruptedException | BrokenBarrierException e) {
      e.printStackTrace();
    } finally {
      doneLatch.countDown();
    }
  }

  private void doPhase(int phase) {
    String name = Thread.currentThread().getName();
    System.out.println(name + ":MyTask:BEGIN:context = " + context + ", phase = " + phase);
    try {
      TimeUnit.MILLISECONDS.sleep(RANDOM.nextInt(3_000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      System.out.println(name + ":MyTask:END:context = " + context + ", phase = " + phase);
    }
  }

}
