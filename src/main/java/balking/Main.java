package balking;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  public static void main(String[] args) {
    Data data = new Data("build/data.txt", "empty");
    new ChangerThread("ChangerThread", data).start();
    new SaverThread("SaverThread", data).start();
  }

}
