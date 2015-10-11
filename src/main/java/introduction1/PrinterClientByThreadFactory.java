package introduction1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author Yoshimasa Tanabe
 */
public class PrinterClientByThreadFactory {

  public static void main(String[] args) {
    ThreadFactory factory = Executors.defaultThreadFactory();
    factory.newThread(new Printer("Good!")).start();
    factory.newThread(new Printer("Nice!")).start();
  }

}
