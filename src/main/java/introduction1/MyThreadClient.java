package introduction1;

/**
 * @author Yoshimasa Tanabe
 */
public class MyThreadClient {

  public static void main(String[] args) {
    MyThread t = new MyThread();
//    t.setDaemon(true);
    t.start();

    for (int i = 0; i <  10; i++) {
      System.out.println("Good! : " + i);
    }
  }

}
