package chap2.synchronizing_method;

public class Withdraw implements Runnable {

	private Account account;

	public Withdraw(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			account.substractBalance(100);
		}
	}
}
