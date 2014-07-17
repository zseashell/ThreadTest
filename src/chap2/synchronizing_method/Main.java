package chap2.synchronizing_method;

public class Main {

	public static void main(String[] args) {
		// inital account balance is 1000
		double balance = 1000;
		Account account = new Account(balance);
		System.out.printf("Initial balance: %f\n", balance);
		
		// deposit task
		Deposit deposit = new Deposit(account);
		Thread deposit_thread = new Thread(deposit);
		
		// withdraw task
		Withdraw withdraw = new Withdraw(account);
		Thread withdraw_thread = new Thread(withdraw);
		
		// start thread
		deposit_thread.start();
		withdraw_thread.start();
		
		// main thread wait for all thread complete
		try {
			deposit_thread.join();
			withdraw_thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("Final balance: %f\n", account.getBalance());
	}

}
