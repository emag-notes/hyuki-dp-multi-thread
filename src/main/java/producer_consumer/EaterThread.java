package producer_consumer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class EaterThread extends Thread {

  private final Random random;
  private final Table table;


  public EaterThread(String name, Table table, long seed) {
    super(name);
    this.table = table;
    this.random = new Random(seed);
  }

  @Override
  public void run() {
    try {
      while (true) {
        String cake = table.take();
        TimeUnit.MILLISECONDS.sleep(random.nextInt(1_000));
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
