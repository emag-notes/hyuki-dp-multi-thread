package worker_thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    try {
      new ClientThread("Alice", executorService).start();
      new ClientThread("Bobby", executorService).start();
      new ClientThread("Chris", executorService).start();

      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      executorService.shutdown();
    }

  }

}
