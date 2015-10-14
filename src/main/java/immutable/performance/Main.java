package immutable.performance;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  private static final long CALL_COUNT = 1_000_000_000L;

  public static void main(String[] args) {
    trial("NotSynch", CALL_COUNT, new NotSynch());
    trial("Synch", CALL_COUNT, new Synch());
  }

  private static void trial(String message, long count, Object object) {
    System.out.println(message + ": BEGIN");

    long startTime = System.currentTimeMillis();
    for (long i = 0; i < count; i++) {
      object.toString();
    }
    System.out.println(message + " END");

    System.out.println("Elapsed time = " + (System.currentTimeMillis() - startTime) + " msec.");
  }

  static class NotSynch {
    private final String name = "NotSynch";

    @Override
    public String toString() {
      return String.format("[ %s ]", name);
    }
  }

  static class Synch {
    private final String name = "Synch";

    @Override
    public synchronized String toString() {
      return String.format("[ %s ]", name);
    }
  }

}
