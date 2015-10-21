package worker_thread;

/**
 * @author Yoshimasa Tanabe
 */
public class WorkerThread extends Thread {

  private final Channel channel;

  public WorkerThread(String name, Channel channel) {
    super(name);
    this.channel = channel;
  }

  @Override
  public void run() {
    while (true) {
      channel.takeRequest().execute();
    }
  }

}
