package guarded_suspension;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  public static void main(String[] args) {
    RequestQueue requestQueue = new RequestQueue();
    new ClientThread("Alice", requestQueue, 3141592L).start();
    new ServerThread("Bobby", requestQueue, 6535897L).start();
  }

}
