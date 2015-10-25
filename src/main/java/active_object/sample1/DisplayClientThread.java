package active_object.sample1;

import active_object.sample1.activeobject.ActiveObject;

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
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
