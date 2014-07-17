package chap2.arranging_attributes_in_synchronized_classes;

public class TicketOffice2 implements Runnable {

	private Cinema cinema;

	public TicketOffice2(Cinema cinema) {
		this.cinema = cinema;
	}

	@Override
	public void run() {
		cinema.sellTicket2(5);
		cinema.returnTicket2(2);
		cinema.sellTicket2(2);
		cinema.sellTicket2(5);
		cinema.returnTicket2(10);
		
	}

}
