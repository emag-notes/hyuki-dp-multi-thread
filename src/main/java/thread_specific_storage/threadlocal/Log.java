package thread_specific_storage.threadlocal;

/**
 * @author Yoshimasa Tanabe
 */
public class Log {

  private static final ThreadLocal<TSLog> TS_LOG_COLLECTION = new ThreadLocal<>();

  public static void println(String s) {
    getTSLog().println(s);
  }

  public static void close() {
    getTSLog().close();
  }

  public static TSLog getTSLog() {
    TSLog tsLog = TS_LOG_COLLECTION.get();

    if (tsLog == null) {
      tsLog = new TSLog("build/" + Thread.currentThread().getName() + "-log.txt");
      TS_LOG_COLLECTION.set(tsLog);
      startWatcher(tsLog);
    }

    return tsLog;
  }

  private static void startWatcher(TSLog tsLog) {
    Thread target = Thread.currentThread();

    new Thread(() -> {
      System.out.println("startWatcher for " + target.getName() + " BEGIN");
      try {
        target.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      tsLog.close();
      System.out.println("startWatcher for " + target.getName() + " END");
    }).start();
  }

}
