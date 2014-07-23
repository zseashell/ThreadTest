package chap6.using_atomic_variables;

public class Main {

	public static void main(String[] args) {
		Account account = new Account();
		account.setBalance(1000l);

		Deposit deposit = new Deposit(account);
		Thread deposit_thread = new Thread(deposit);

		WithDraw withDraw = new WithDraw(account);
		Thread withDraw_thread = new Thread(withDraw);

		System.out.println("Initial balance: " + account.getBalance());
		
		deposit_thread.start();
		withDraw_thread.start();
		
		try {
			deposit_thread.join();
			withDraw_thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Final balance: " + account.getBalance());
	}

}
