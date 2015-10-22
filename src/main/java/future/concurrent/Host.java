package future.concurrent;

/**
 * @author Yoshimasa Tanabe
 */
public class Host {

  public Data request(int count, char c) {
    System.out.println(String.format("    request(%d, %s) BEGIN", count, c));

    FutureData future = new FutureData(
      () -> new RealData(count, c)
    );

    new Thread(future).start();

    System.out.println(String.format("    request(%d, %s) END", count, c));

    return future;
  }

}
