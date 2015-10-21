package worker_thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class ClientThread extends Thread {

  private static final Random RANDOM = new Random();

  private final Channel channel;

  public ClientThread(String name, Channel channel) {
    super(name);
    this.channel = channel;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; true; i++) {
        Request request = new Request(getName(), i);
        channel.putRequest(request);
        TimeUnit.MILLISECONDS.sleep(RANDOM.nextInt(1_000));
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
