package balking;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class ChangerThread extends Thread {

  private final Data data;
  private final Random random = new Random();

  public ChangerThread(String name, Data data) {
    super(name);
    this.data = data;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; true; i++) {
        data.change("No." + i);
        TimeUnit.MILLISECONDS.sleep(random.nextInt(1_000));
        data.save();
      }
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
