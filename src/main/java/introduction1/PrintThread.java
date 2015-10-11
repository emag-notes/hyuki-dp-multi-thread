package introduction1;

/**
 * @author Yoshimasa Tanabe
 */
public class PrintThread extends Thread {

  private final String message;

  public PrintThread(String message) {
    this.message = message;
  }

  @Override
  public void run() {
    for (int i = 0; i < 1_000_000; i++) {
      System.out.println(message + " : " + i);
    }
  }

}
