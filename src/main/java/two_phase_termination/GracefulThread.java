package two_phase_termination;

import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
public abstract class GracefulThread extends Thread {

  private volatile boolean shutdownRequested;

  public final void shutdownRequest() {
    shutdownRequested = true;
    interrupt();
  }

  public final boolean isShutdownRequested() {
    return shutdownRequested;
  }

  @Override
  public final void run() {
    try {
      while (!isShutdownRequested()) {
        doWork();
      }
    } catch (InterruptedException e) {
//      e.printStackTrace();
    } finally {
      doShutdown();
    }
  }

  abstract protected void doWork() throws InterruptedException;
  abstract protected void doShutdown();

}
