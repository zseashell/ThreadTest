package chap6.using_atomic_variables;

public class Deposit implements Runnable {

	private Account account;

	public Deposit(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			account.addAmount(1000);
		}
	}
}
