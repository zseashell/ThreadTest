package chap1.create_daemon_thread;

import java.util.Date;

public class Event {

	private Date date;

	private String event;

	public Event(Date date, String event) {
		this.date = date;
		this.event = event;
	}

	public Date getDate() {
		return date;
	}

	public String getEvent() {
		return event;
	}

}
