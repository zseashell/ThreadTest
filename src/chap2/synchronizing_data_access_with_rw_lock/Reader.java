package chap2.synchronizing_data_access_with_rw_lock;

public class Reader implements Runnable {

	private PriceInfo priceInfo;

	public Reader(PriceInfo priceInfo) {
		this.priceInfo = priceInfo;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s read price1 : %f\n", Thread.currentThread()
					.getName(), priceInfo.getPrice1());
			System.out.printf("%s read price2 : %f\n", Thread.currentThread()
					.getName(), priceInfo.getPrice2());
		}
	}

}
