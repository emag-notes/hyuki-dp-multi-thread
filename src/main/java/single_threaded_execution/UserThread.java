package single_threaded_execution;

/**
 * @author Yoshimasa Tanabe
 */
public class UserThread extends Thread {

  private final Gate gate;
  private final String myName;
  private final String myAddress;

  public UserThread(Gate gate, String myName, String myAddress) {
    this.gate = gate;
    this.myName = myName;
    this.myAddress = myAddress;
  }

  @Override
  public void run() {
    System.out.println(myName + " BEGIN");
    while (true) {
      gate.pass(myName, myAddress);
    }
  }

}
