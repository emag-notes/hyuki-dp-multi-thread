package active_object.sample2.activeobject;

/**
 * @author Yoshimasa Tanabe
 */
public class ActiveObjectFactory {

  public static ActiveObject createActiveObjcet() {
    return new ActiveObjectImpl();
  }

}
