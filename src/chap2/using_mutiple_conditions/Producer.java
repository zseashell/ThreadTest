package chap2.using_mutiple_conditions;

public class Producer implements Runnable {

	private FileMock fileMock;

	private Buffer buffer;

	public Producer(FileMock fileMock, Buffer buffer) {
		this.fileMock = fileMock;
		this.buffer = buffer;
	}

	@Override
	public void run() {
		buffer.setPendingLines(true);
		while (fileMock.hasMoreLines()) {
			String line = fileMock.getLine();
			buffer.insert(line);
		}
		buffer.setPendingLines(false);
	}

}
