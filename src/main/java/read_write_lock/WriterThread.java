package read_write_lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class WriterThread extends Thread {

  private static final Random RANDOM = new Random();

  private final Data data;
  private final String filler;

  private int index = 0;

  public WriterThread(Data data, String filler) {
    this.data = data;
    this.filler = filler;
  }

  @Override
  public void run() {
    try {
      while (true) {
        char c = nextChar();
        data.write(c);
        TimeUnit.MILLISECONDS.sleep(RANDOM.nextInt(3_000));
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private char nextChar() {
    char c = filler.charAt(index);
    index++;
    if (index >= filler.length()) {
      index = 0;
    }
    return c;
  }

}
