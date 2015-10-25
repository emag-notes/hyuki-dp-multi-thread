package active_object.sample2;

import active_object.sample2.activeobject.ActiveObject;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class AddClientThread extends Thread {

  private final ActiveObject activeObject;

  private String x = "1";
  private String y = "1";

  public AddClientThread(String name, ActiveObject activeObject) {
    super(name);
    this.activeObject = activeObject;
  }

  @Override
  public void run() {
    try {
      while (true) {
        Future<String> future = activeObject.add(x, y);
        TimeUnit.MILLISECONDS.sleep(100);
        String z = future.get();
        System.out.println(Thread.currentThread().getName() + ": " + x + " + " + y + " = " + z);
        x = y;
        y = z;
      }
    } catch (RejectedExecutionException | CancellationException | ExecutionException | InterruptedException e) {
      System.err.println(Thread.currentThread().getName() + ":" + e);
    }
  }

}
