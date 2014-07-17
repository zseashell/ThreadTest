package chap2.synchronizing_data_access_with_rw_lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PriceInfo {

	private double price1;

	private double price2;

	private final ReadWriteLock lock = new ReentrantReadWriteLock();

	public PriceInfo(double price1, double price2) {
		this.price1 = price1;
		this.price2 = price2;
	}

	public double getPrice1() {
		lock.readLock().lock();
		double value = price1;
		lock.readLock().unlock();
		return value;
	}

	public double getPrice2() {
		lock.readLock().lock();
		double value = price2;
		lock.readLock().unlock();
		return value;
	}

	public void setPrice(double price1, double price2) {
		lock.writeLock().lock();
		this.price1 = price1;
		this.price2 = price2;
		lock.writeLock().unlock();
	}

}
