package future.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("main BEGIN");

    Host host = new Host();
    Data data1 = host.request(10, 'A');
    Data data2 = host.request(20, 'B');
    Data data3 = host.request(30, 'C');

    System.out.println("main otherJob BEGIN");
    try {
      TimeUnit.SECONDS.sleep(2);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("main otherJob END");

    try {
      System.out.println("data1 = " + data1.getContent());
      System.out.println("data2 = " + data2.getContent());
      System.out.println("data3 = " + data3.getContent());
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("main END");
  }

}

