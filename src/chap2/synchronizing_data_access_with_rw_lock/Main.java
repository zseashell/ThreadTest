package chap2.synchronizing_data_access_with_rw_lock;

public class Main {
	
	public static void main(String[] args) {
		PriceInfo priceInfo = new PriceInfo(0, 0);
		
		// multiple readers
		Reader[] readers = new Reader[5];
		Thread[] readerThreads = new Thread[5];
		for (int i=0; i<5; i++) {
			readers[i] = new Reader(priceInfo);
			readerThreads[i] = new Thread(readers[i]);
		}
		
		// one writer
		Writer writer = new Writer(priceInfo);
		Thread writerThread = new Thread(writer);
		
		// start all threads
		for (int i=0; i<5; i++) {
			readerThreads[i].start();
		}
		writerThread.start();
	}

}
