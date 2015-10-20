package thread_per_message.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Yoshimasa Tanabe
 */
public class MiniServer {

  private final int portNumber;

  public MiniServer(int portNumber) {
    this.portNumber = portNumber;
  }

  public void execute() throws IOException {
    ServerSocket serverSocket = new ServerSocket(portNumber);
    ExecutorService executorService = Executors.newCachedThreadPool();
    System.out.println("Listening on " + serverSocket);
    try {
      while (true) {
        System.out.println("Accepting...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Connected to " + clientSocket);
        executorService.execute(() -> {
            try {
              Service.service(clientSocket);
            } catch (IOException e) {
              e.printStackTrace();
            }
          }
        );
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      serverSocket.close();
    }
  }

}
