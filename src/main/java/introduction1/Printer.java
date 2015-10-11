package introduction1;

/**
 * @author Yoshimasa Tanabe
 */
public class Printer implements Runnable {

  private String message;

  public Printer(String message) {
    this.message = message;
  }

  @Override
  public void run() {
    for (int i = 0; i < 1_000_000; i++) {
      System.out.println(message + " : " + i);
    }
  }

}
