package worker_thread.concurrent;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class Request implements Runnable {

  private static final Random RANDOM = new Random();

  private final String name;
  private final int number;

  public Request(String name, int number) {
    this.name = name;
    this.number = number;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " executes " + this);
    try {
      TimeUnit.MILLISECONDS.sleep(RANDOM.nextInt(1_000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String toString() {
    return String.format("[ Request from %s No. %d]", name, number);
  }

}
