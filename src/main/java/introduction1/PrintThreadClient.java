package introduction1;

/**
 * @author Yoshimasa Tanabe
 */
public class PrintThreadClient {

  public static void main(String[] args) {
    new PrintThread("Good").start();
    new PrintThread("Nice!").start();
  }

}
