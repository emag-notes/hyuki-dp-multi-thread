package active_object.sample2.activeobject;

import java.util.concurrent.Future;

/**
 * @author Yoshimasa Tanabe
 */
public interface ActiveObject {

  Future<String> makeString(int count, char fillChar);
  void displayString(String string);
  Future<String> add(String x, String y);

  void shutdown();

}
