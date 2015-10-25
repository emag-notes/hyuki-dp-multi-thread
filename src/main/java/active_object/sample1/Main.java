package active_object.sample1;

import active_object.sample1.activeobject.ActiveObject;
import active_object.sample1.activeobject.ActiveObjectFactory;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  public static void main(String[] args) {
    ActiveObject activeObject = ActiveObjectFactory.createActiveObjcet();
    new MakerClientThread("Alice", activeObject).start();
    new MakerClientThread("Bobby", activeObject).start();
    new DisplayClientThread("Chris", activeObject).start();
  }

}
