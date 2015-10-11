package introduction1;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author Yoshimasa Tanabe
 */
public class BankClient {

  public static void main(String[] args) {
    Bank bank = new Bank(0, "bank");

    ThreadFactory factory = Executors.defaultThreadFactory();
    Thread depositThread = factory.newThread(new DepositThread(bank, 100));
    depositThread.start();
    Thread withdrawThread = factory.newThread(new WithdrawThread(bank, 100));
    withdrawThread.start();

    try {
      depositThread.join();
      withdrawThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(bank.getMoney());
  }

}
