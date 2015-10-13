package single_threaded_execution.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
class BoundedResource {

  private final Semaphore semaphore;
  private final int permits;
  private final static Random RANDOM = new Random(314159);

  public BoundedResource(int permits) {
    this.semaphore = new Semaphore(permits);
    this.permits = permits;
  }

  public void use() throws InterruptedException {
    semaphore.acquire();
    try {
      doUse();
    } finally {
      semaphore.release();
    }
  }

  protected void doUse() throws InterruptedException {
    Log.println("BEGIN: used = " + (permits - semaphore.availablePermits()));
    TimeUnit.MILLISECONDS.sleep(RANDOM.nextInt(500));
    Log.println("END:   used = " + (permits - semaphore.availablePermits()));
  }

}
