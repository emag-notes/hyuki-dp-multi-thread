package future;

/**
 * @author Yoshimasa Tanabe
 */
public class Host {

  public Data request(int count, char c) {
    System.out.println(String.format("    request(%d, %s) BEGIN", count, c));

    FutureData future = new FutureData();

    new Thread(() -> {
      try {
        RealData realData = new RealData(count, c);
        future.setRealData(realData);
      } catch (Exception e) {
        future.setException(e);
      }
    }).start();

    System.out.println(String.format("    request(%d, %s) END", count, c));

    return future;
  }

}
