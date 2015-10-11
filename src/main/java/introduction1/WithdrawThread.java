package introduction1;

/**
 * @author Yoshimasa Tanabe
 */
public class WithdrawThread implements Runnable {

  private final Bank bank;
  private final int money;

  public WithdrawThread(Bank bank, int money) {
    this.bank = bank;
    this.money = money;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100_000_000; i++) {
      bank.withdrawWithoutCheck(money);
    }
  }

}
