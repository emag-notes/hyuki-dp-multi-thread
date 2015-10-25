package active_object.sample1.activeobject;

/**
 * @author Yoshimasa Tanabe
 */
public class ActiveObjectFactory {

  public static ActiveObject createActiveObjcet() {
    Servant servant = new Servant();
    ActivationQueue queue = new ActivationQueue();
    SchedulerThread scheduler = new SchedulerThread(queue);
    Proxy proxy = new Proxy(scheduler, servant);
    scheduler.start();
    return proxy;
  }

}
