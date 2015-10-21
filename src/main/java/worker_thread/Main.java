package worker_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  public static void main(String[] args) {
    Channel channel = new Channel(5);
    channel.startWorkers();

    new ClientThread("Alice", channel).start();
    new ClientThread("Bobby", channel).start();
    new ClientThread("Chris", channel).start();
  }

}
