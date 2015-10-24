package thread_specific_storage.threadlocal;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  public static void main(String[] args) {
    new ClientThread("Alice").start();
    new ClientThread("Bobby").start();
    new ClientThread("Chris").start();
  }

}
