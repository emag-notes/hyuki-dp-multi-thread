package thread_specific_storage.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class ClientThread extends Thread {

  public ClientThread(String name) {
    super(name);
  }

  @Override
  public void run() {
    System.out.println(getName() + " BEGIN");

    for (int i = 0; i < 10; i++) {
      Log.println("i = " + i);
      try {
        TimeUnit.MILLISECONDS.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
//    Log.close();

    System.out.println(getName() + " END");
  }

}
