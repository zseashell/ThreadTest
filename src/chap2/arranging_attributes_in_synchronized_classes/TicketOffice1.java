package chap2.arranging_attributes_in_synchronized_classes;

public class TicketOffice1 implements Runnable {

	private Cinema cinema;

	public TicketOffice1(Cinema cinema) {
		this.cinema = cinema;
	}

	@Override
	public void run() {
		cinema.sellTicket1(1);
		cinema.sellTicket1(2);
		cinema.returnTicket1(1);
		cinema.sellTicket1(3);
		cinema.sellTicket1(5);
		cinema.returnTicket1(10);
	}

}
