package active_object.sample2.activeobject;

import java.math.BigInteger;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
class ActiveObjectImpl implements ActiveObject {

  private final ExecutorService service = Executors.newSingleThreadExecutor();

  public Future<String> makeString(int count, char fillChar) {
    return service.submit(() -> {
      char[] buffer = new char[count];
      for (int i = 0; i < count; i++) {
        buffer[i] = fillChar;
        try {
          TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      return new String(buffer);
    });
  }

  @Override
  public void displayString(String string) {
    service.execute(() -> {
      try {
        System.out.println("displayString: " + string);
        TimeUnit.MILLISECONDS.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
  }

  @Override
  public Future<String> add(String x, String y) {
    return service.submit(() ->
      new BigInteger(x).add(new BigInteger(y)).toString());
  }

  @Override
  public void shutdown() {
    service.shutdown();
  }

}
