package balking;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class SaverThread extends Thread {

  private final Data data;

  public SaverThread(String name, Data data) {
    super(name);
    this.data = data;
  }

  @Override
  public void run() {
    try {
      while (true) {
        data.save();
        TimeUnit.SECONDS.sleep(1);
      }
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

}
