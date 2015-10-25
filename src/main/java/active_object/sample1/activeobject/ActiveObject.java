package active_object.sample1.activeobject;

/**
 * @author Yoshimasa Tanabe
 */
public interface ActiveObject {
  Result<String> makeString(int count, char fillChar);
  void displayString(String string);
  Result<String> add(String x, String y);
}
