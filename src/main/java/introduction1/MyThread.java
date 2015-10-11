package introduction1;

/**
 * @author Yoshimasa Tanabe
 */
public class MyThread extends Thread {

  @Override
  public void run() {
    for (int i = 0; i < 10_000_000; i++) {
      System.out.println("Nice! : " + i);
    }
  }

}
