package active_object.sample1.activeobject;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

/**
 * @author Yoshimasa Tanabe
 */
class Servant implements ActiveObject {

  @Override
  public Result<String> makeString(int count, char fillChar) {
    char[] buffer = new char[count];
    for (int i = 0; i < count; i++) {
      buffer[i] = fillChar;
      try {
        TimeUnit.MILLISECONDS.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    return new RealResult<>(new String(buffer));
  }

  @Override
  public void displayString(String string) {
    try {
      System.out.println("displayString: " + string);
      TimeUnit.MILLISECONDS.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Result<String> add(String x, String y) {
    return new RealResult<>(new BigInteger(x).add(new BigInteger(y)).toString());
  }

}
