package balking.timeout;

import java.util.concurrent.TimeoutException;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  public static void main(String[] args) {
    Host host = new Host(10_000);
    System.out.println("execute BEGIN");

    try {
      host.execute();
    } catch (TimeoutException | InterruptedException e) {
      e.printStackTrace();
    }
  }

}
