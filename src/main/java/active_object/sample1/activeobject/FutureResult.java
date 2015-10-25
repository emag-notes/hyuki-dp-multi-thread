package active_object.sample1.activeobject;

/**
 * @author Yoshimasa Tanabe
 */
class FutureResult<T> implements Result<T> {

  private Result<T> result;
  private boolean ready;

  public synchronized void setResult(Result<T> result) {
    this.result = result;
    this.ready = true;
    notifyAll();
  }

  @Override
  public synchronized T getResultValue() {
    while (!ready) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    return result.getResultValue();
  }

}
