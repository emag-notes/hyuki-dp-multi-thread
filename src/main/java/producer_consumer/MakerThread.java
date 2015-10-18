package producer_consumer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class MakerThread extends Thread {

  private final Random random;
  private final Table table;
  private static int id = 0;

  public MakerThread(String name, Table table, long seed) {
    super(name);
    this.table = table;
    this.random = new Random(seed);
  }

  @Override
  public void run() {
    try {
      while (true) {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(1_000));
        String cake = String.format("[ Cake No.%d by %s ]", nextId(), getName());
        table.put(cake);

      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static synchronized int nextId() {
    return id++;
  }

}
