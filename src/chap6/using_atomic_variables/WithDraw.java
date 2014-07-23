package chap6.using_atomic_variables;

public class WithDraw implements Runnable {

	private Account account;

	public WithDraw(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			account.substractAmount(1000);
		}
	}

}
