package thread_per_message;

import java.util.concurrent.Executor;

/**
 * @author Yoshimasa Tanabe
 */
public class Host {

  private final Helper helper = new Helper();
  private final Executor executor;

  public Host(Executor executor) {
    this.executor = executor;
  }

  public void request(final int count, final char c) {
    System.out.println(String.format("    request(%d, %s) BEGIN", count, c));
    executor.execute(() -> {
      helper.handle(count, c);
    });
    System.out.println(String.format("    request(%d, %s) END", count, c));
  }

}
