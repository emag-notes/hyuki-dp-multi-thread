package active_object.sample2;

import active_object.sample2.activeobject.ActiveObject;
import active_object.sample2.activeobject.ActiveObjectFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  public static void main(String[] args) {
    ActiveObject activeObject = ActiveObjectFactory.createActiveObjcet();

    try {
      new MakerClientThread("Alice", activeObject).start();
      new MakerClientThread("Bobby", activeObject).start();
      new DisplayClientThread("Chris", activeObject).start();
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      System.out.println("**** shutdown ****");
      activeObject.shutdown();
    }
  }

}
