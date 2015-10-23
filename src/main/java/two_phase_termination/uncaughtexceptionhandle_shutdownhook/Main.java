package two_phase_termination.uncaughtexceptionhandle_shutdownhook;

import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  public static void main(String[] args) {
    System.out.println("main: BEGIN");

    Thread.setDefaultUncaughtExceptionHandler(
      (thread, exception) -> {
        System.err.println("*****");
        System.err.println("UncaughtExceptionHandler:BEGIN");
        System.err.println("currentThread = " + Thread.currentThread());
        System.err.println("thread = " + thread);
        System.err.println("exception = " + exception);
        System.err.println("UncaughtExceptionHandler:END");
      }
    );

    Runtime.getRuntime().addShutdownHook(
      new Thread(() -> {
        System.out.println("*****");
        System.out.println("shutdown hook:BEGIN");
        System.out.println("currentThread = " + Thread.currentThread());
        System.out.println("shutdown hook:END");
      })
    );

    new Thread(() -> {
      System.out.println("MyThread:BEGIN");

      System.out.println("MyThread:SLEEP...");
      try {
        TimeUnit.SECONDS.sleep(3);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println("MyThread:DIVIDE");
      int x = 1 / 0;

      // never through
      System.out.println("MyThread:END");
    }, "MyThread").start();

    System.out.println("main: END");
  }

}

