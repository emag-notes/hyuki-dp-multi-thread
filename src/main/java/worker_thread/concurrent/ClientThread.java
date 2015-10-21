package worker_thread.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class ClientThread extends Thread {

  private static final Random RANDOM = new Random();

  private final ExecutorService executorService;

  public ClientThread(String name, ExecutorService executorService) {
    super(name);
    this.executorService = executorService;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; true; i++) {
        Request request = new Request(getName(), i);
        executorService.execute(request);
        TimeUnit.MILLISECONDS.sleep(RANDOM.nextInt(1_000));
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (RejectedExecutionException e) {
      System.err.println(getName() + " : " + e);
    }
  }

}
