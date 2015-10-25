package active_object.sample1.activeobject;

/**
 * @author Yoshimasa Tanabe
 */
public class RealResult<T> implements Result<T> {

  private final T resultValue;

  public RealResult(T resultValue) {
    this.resultValue = resultValue;
  }

  @Override
  public T getResultValue() {
    return resultValue;
  }

}
