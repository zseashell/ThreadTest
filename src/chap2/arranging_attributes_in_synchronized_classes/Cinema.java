package chap2.arranging_attributes_in_synchronized_classes;

public class Cinema {

	private int vacanciesCinema1;

	private int vacanciesCinema2;

	private final Object controlCinema1 = new Object();

	private final Object controlCinema2 = new Object();

	public Cinema() {
		vacanciesCinema1 = 20;
		vacanciesCinema2 = 20;
	}

	public boolean sellTicket1(int number) {
		synchronized (controlCinema1) {
			if (number < vacanciesCinema1) {
				vacanciesCinema1 -= number;
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean sellTicket2(int number) {
		synchronized (controlCinema2) {
			if (number < vacanciesCinema2) {
				vacanciesCinema2 -= number;
				return true;
			} else {
				return false;
			}
		}
	}

	public boolean returnTicket1(int number) {
		synchronized (controlCinema1) {
			vacanciesCinema1 += number;
			return true;
		}
	}

	public boolean returnTicket2(int number) {
		synchronized (controlCinema2) {
			vacanciesCinema2 += number;
			return true;
		}
	}

	public int getVacanciesCinema1() {
		return vacanciesCinema1;
	}

	public int getVacanciesCinema2() {
		return vacanciesCinema2;
	}
	
	
}
