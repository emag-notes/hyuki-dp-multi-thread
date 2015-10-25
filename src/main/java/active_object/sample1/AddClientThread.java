package active_object.sample1;

import active_object.sample1.activeobject.ActiveObject;
import active_object.sample1.activeobject.Result;

import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class AddClientThread extends Thread {

  private final ActiveObject activeObject;

  private String x = "1";
  private String y = "2";

  public AddClientThread(String name, ActiveObject activeObject) {
    super(name);
    this.activeObject = activeObject;
  }

  @Override
  public void run() {
    try {
      while (true) {
        Result<String> result = activeObject.add(x, y);
        TimeUnit.MILLISECONDS.sleep(100);
        String z = result.getResultValue();
        System.out.println(Thread.currentThread().getName() + ": " + x + " + " + y + " = " + z);
        x = y;
        y = z;
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
