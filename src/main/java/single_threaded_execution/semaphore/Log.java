package single_threaded_execution.semaphore;

/**
 * @author Yoshimasa Tanabe
 */
class Log {

  public static void println(String s) {
    System.out.println(Thread.currentThread().getName() + ": " + s);
  }

}
