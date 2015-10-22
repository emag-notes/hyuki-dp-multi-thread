package future;

import java.util.concurrent.ExecutionException;

/**
 * @author Yoshimasa Tanabe
 */
public class FutureData implements Data {

  private RealData realData;
  private boolean ready;
  private ExecutionException exception;

  public synchronized void setRealData(RealData realData) {
    if (ready) {
      return;
    }
    this.realData = realData;
    this.ready = true;
    notifyAll();
  }

  public synchronized void setException(Throwable throwable) {
    if (ready) {
      return;
    }
    this.exception = new ExecutionException(throwable);
    this.ready = true;
    notifyAll();
  }

  @Override
  public synchronized String getContent() throws ExecutionException {
    while (!ready) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    if (exception != null) {
      throw exception;
    }

    return realData.getContent();
  }

}
