package chap3.waiting_for_multiple_concurrent_events;

public class Main {

	public static void main(String[] args) {
		VideoConference videoConference = new VideoConference(10);

		Thread threadConference = new Thread(videoConference);
		threadConference.start();

		for (int i = 0; i < 10; i++) {
			Participant participant = new Participant(videoConference,
					"Participant " + i);
			Thread threadParticipant = new Thread(participant);
			threadParticipant.start();
		}
	}

}
