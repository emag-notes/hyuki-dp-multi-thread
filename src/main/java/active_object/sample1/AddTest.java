package active_object.sample1;

import active_object.sample1.activeobject.ActiveObject;
import active_object.sample1.activeobject.ActiveObjectFactory;

/**
 * @author Yoshimasa Tanabe
 */
public class AddTest {

  public static void main(String[] args) {
    ActiveObject activeObject = ActiveObjectFactory.createActiveObjcet();
    new AddClientThread("Diana", activeObject).start();
  }

}
