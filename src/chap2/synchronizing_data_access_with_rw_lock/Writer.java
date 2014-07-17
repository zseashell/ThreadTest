package chap2.synchronizing_data_access_with_rw_lock;

public class Writer implements Runnable {
	
	private PriceInfo priceInfo;
	
	public Writer(PriceInfo priceInfo) {
		this.priceInfo = priceInfo;
	}

	@Override
	public void run() {
		for (int i=0; i<3; i++) {
			System.out.println("Writer tries to modify the price");
			priceInfo.setPrice(Math.random() * 10, Math.random() * 8);
			System.out.println("Witer has modified the price.");
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
