package thread_per_message;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("main BEGIN");
    ExecutorService executorService = Executors.newCachedThreadPool();
    Host host = new Host(executorService);

    try {
      host.request(10, 'A');
      host.request(20, 'B');
      host.request(30, 'C');
    } finally {
      executorService.shutdown();
      System.out.println("main END");
    }
  }

}
