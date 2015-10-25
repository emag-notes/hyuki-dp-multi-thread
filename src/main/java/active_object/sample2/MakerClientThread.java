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
public class MakerClientThread extends Thread {

  private final ActiveObject activeObject;
  private final char fillChar;

  public MakerClientThread(String name, ActiveObject activeObject) {
    super(name);
    this.activeObject = activeObject;
    this.fillChar = name.charAt(0);
  }

  @Override
  public void run() {
    try {
      for (int i = 0; true; i++) {
        Future<String> future = activeObject.makeString(i, fillChar);
        TimeUnit.MILLISECONDS.sleep(10);
        String value = future.get();
        System.out.println(Thread.currentThread().getName() + ": value = " + value);
      }
    } catch (RejectedExecutionException | CancellationException | ExecutionException | InterruptedException e) {
      System.err.println(Thread.currentThread().getName() + ":" + e);
    }
  }

}
