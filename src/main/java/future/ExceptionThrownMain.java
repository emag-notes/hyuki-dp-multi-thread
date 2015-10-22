package future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class ExceptionThrownMain {

  public static void main(String[] args) {
    System.out.println("main BEGIN");

    Host host = new Host();
    Data data = host.request(-1, 'N');

    System.out.println("main otherJob BEGIN");
    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("main otherJob END");

    try {
      System.out.println("data = " + data.getContent());
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("main END");
  }

}

