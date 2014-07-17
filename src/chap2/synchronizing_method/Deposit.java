package chap2.synchronizing_method;

public class Deposit implements Runnable {

	private Account account;

	public Deposit(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			account.addBalance(100);
		}
	}
}
