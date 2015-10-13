package single_threaded_execution.semaphore;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class UserThread extends Thread {

  private final static Random RANDOM = new Random(26535);
  private final BoundedResource resource;

  public UserThread(BoundedResource resource) {
    this.resource = resource;
  }

  @Override
  public void run() {
    try {
      while (true) {
        resource.use();
        TimeUnit.MILLISECONDS.sleep(RANDOM.nextInt(3_000));
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
