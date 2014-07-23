package chap6.blocking_thread_safe_list_by_priority;

public class Event implements Comparable<Event> {

	private int id;

	private int priority;

	public Event(int id, int priority) {
		this.id = id;
		this.priority = priority;
	}

	@Override
	public int compareTo(Event e) {
		if (priority > e.getPriority()) {
			return -1;
		} else if (priority < e.getPriority()) {
			return 1;
		} else {
			return 0;
		}
	}

	public int getId() {
		return id;
	}

	public int getPriority() {
		return priority;
	}
	
	

}
