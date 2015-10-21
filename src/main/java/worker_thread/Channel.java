package worker_thread;

import java.util.Arrays;

/**
 * @author Yoshimasa Tanabe
 */
public class Channel {

  private static final int MAX_REQUEST = 100;

  private final Request[] requestQueue;
  private final WorkerThread[] threadPool;

  private int tail;
  private int head;
  private int count;


  public Channel(int threads) {
    this.requestQueue = new Request[MAX_REQUEST];

    this.threadPool = new WorkerThread[threads];
    for (int i = 0; i < threadPool.length; i++) {
      threadPool[i] = new WorkerThread("Worker-" + i, this);
    }

    this.head = 0;
    this.tail = 0;
    this.count = 0;
  }

  public void startWorkers() {
    Arrays.stream(threadPool).forEach(Thread::start);
  }

  public synchronized void putRequest(Request request) {
    while (count >= requestQueue.length) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    requestQueue[tail] = request;
    tail = (tail + 1) % requestQueue.length;
    count++;
    notifyAll();
  }

  public synchronized Request takeRequest() {
    while (count <= 0) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    Request request = requestQueue[head];
    head = (head + 1) % requestQueue.length;
    count--;
    notifyAll();
    return request;
  }

}
