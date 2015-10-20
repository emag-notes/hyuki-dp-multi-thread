package thread_per_message.webserver;

import java.io.IOException;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  public static void main(String[] args) {
    try {
      new MiniServer(8888).execute();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
