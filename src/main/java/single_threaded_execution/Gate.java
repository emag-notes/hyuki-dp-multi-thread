package single_threaded_execution;

/**
 * @author Yoshimasa Tanabe
 */
public class Gate {

  private int counter = 0;
  private String name = "Nobody";
  private String address = "Nowhere";

  public synchronized void pass(String name, String address) {
    this.counter++;
    this.name = name;
    this.address = address;
    check();
  }

  private void check() {
    if (name.charAt(0) != address.charAt(0)) {
      System.err.println("***** BROKEN ***** " + this);
    }
  }

  @Override
  public synchronized String toString() {
    return String.format("No.%d: %s, %s", counter, name, address);
  }

}
