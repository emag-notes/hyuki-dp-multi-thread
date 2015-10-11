package introduction1;

/**
 * @author Yoshimasa Tanabe
 */
public class Bank {

  private int money;
  private final String name;

  public Bank(int money, String name) {
    this.money = money;
    this.name = name;
  }

  public synchronized void deposit(int money) {
    this.money += money;
  }

  public synchronized boolean withdraw(int money) {
    if (this.money > money) {
      this.money -= money;
      return true;
    } else {
      return false;
    }
  }

  public synchronized void withdrawWithoutCheck(int money) {
    this.money -= money;
  }

  public int getMoney() {
    return money;
  }

  public String getName() {
    return name;
  }

}
