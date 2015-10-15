package guarded_suspension;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class ClientThread extends Thread {

  private final RequestQueue requestQueue;
  private final Random random;

  public ClientThread( String name, RequestQueue requestQueue, long seed) {
    super(name);
    this.requestQueue = requestQueue;
    this.random = new Random(seed);
  }

  @Override
  public void run() {
    for (int i = 0; i < 10_000; i++) {
      Request request = new Request("No." + i);
      System.out.println(Thread.currentThread().getName() + " requests " + request);
      requestQueue.putRequest(request);
      try {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(1_000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

}
