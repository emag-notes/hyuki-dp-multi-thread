package introduction1;

/**
 * @author Yoshimasa Tanabe
 */
public class PrinterClient {

  public static void main(String[] args) {
    new Thread(new Printer("Good!")).start();
    new Thread(new Printer("Nice!")).start();
  }

}
