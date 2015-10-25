package active_object.sample2;

import active_object.sample2.activeobject.ActiveObject;

import java.util.concurrent.CancellationException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class DisplayClientThread extends Thread {

  private final ActiveObject activeObject;

  public DisplayClientThread(String name, ActiveObject activeObject) {
    super(name);
    this.activeObject = activeObject;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; true; i++) {
        String string = Thread.currentThread().getName() + " " + i;
        activeObject.displayString(string);
        TimeUnit.MILLISECONDS.sleep(200);
      }
    } catch (RejectedExecutionException | CancellationException | InterruptedException e) {
      System.err.println(Thread.currentThread().getName() + ":" + e);
    }
  }

}
