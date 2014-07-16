package chap2.arranging_attributes_in_synchronized_classes;

public class Main {

	public static void main(String[] args) {
		Cinema cinema = new Cinema();

		// ticket office1 task
		TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
		Thread thread1 = new Thread(ticketOffice1);

		// ticket office2 task
		TicketOffice2 ticketOffice2 = new TicketOffice2(cinema);
		Thread thread2 = new Thread(ticketOffice2);

		// start thread
		thread1.start();
		thread2.start();

		// main thread wait all thread to complete
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("Vacancies for cinema1: %d\n",
				cinema.getVacanciesCinema1());
		System.out.printf("Vacancies for cinema2: %d\n",
				cinema.getVacanciesCinema2());
	}
}
