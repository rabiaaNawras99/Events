import java.util.ArrayList;
import java.util.Date;

public class EventMain {

	public static void printList(ArrayList<Event> array) {
		for (Event event : array) {
			System.out.println(event);
		}
	}

	public static void main(String[] args) {
		EventsMonitoringUnit eventsUnit = new EventsMonitoringUnit();
		Citizen citizen1 = new Citizen("1234", "name1", new Date(2001, 3, 3), "mail1@mail.com", Gender.MALE);
		Citizen citizen2 = new Citizen("5678", "name2", new Date(1994, 6, 4), "mail2@mail.com", Gender.FEMALE);
		Citizen citizen3 = new Citizen("1346", "name3", new Date(1999, 5, 3), "mail3@mail.com", Gender.MALE);
		Citizen citizen4 = new Citizen("7896", "name4", new Date(1980, 3, 7), "mail4@mail.com", Gender.MALE);
		Citizen citizen5 = new Citizen("9875", "name5", new Date(1988, 6, 3), "mail5@mail.com", Gender.MALE);

		eventsUnit.addCitizen(citizen1);
		eventsUnit.addCitizen(citizen2);
		eventsUnit.addCitizen(citizen3);
		eventsUnit.addCitizen(citizen4);
		eventsUnit.addCitizen(citizen5);

		Event event11 = new SecurityEvent("party", new Date(1988, 6, 3), Level.LOW, citizen5, 3, 5);
		Event event22 = new SecurityEvent("kill", new Date(1988, 6, 3), Level.HIGH, citizen1, 7, 5);
		Event event33 = new SecurityEvent("party", new Date(1994, 6, 4), Level.LOW, citizen3, 2, 5);

		Event event1 = new HostileEvent("kill", new Date(1994, 6, 4), Level.HIGH, citizen5, 7);
		Event event2 = new HostileEvent("event", new Date(1994, 6, 4), Level.MID, citizen5, 2);
		Event event3 = new HostileEvent("kill", new Date(1994, 6, 4), Level.LOW, citizen5, 3);

		eventsUnit.addEvent(event11);
		eventsUnit.addEvent(event22);
		eventsUnit.addEvent(event33);
		eventsUnit.addEvent(event1);
		eventsUnit.addEvent(event2);
		eventsUnit.addEvent(event3);

		Comment comment1 = new Comment(new Date(), "so dangerous!", citizen4);
		eventsUnit.addComment(comment1, 1);

		ArrayList<Event> arr = eventsUnit.getEventsByType("kill");
		if (arr != null) {
			printList(arr);

		}

		int x = eventsUnit.getNumOfEventsByLevel(Level.LOW);
		System.out.println(x);

		ArrayList<SecurityEvent> arr2 = eventsUnit.getSecurityEvents();
		for (SecurityEvent securityEvent : arr2) {
			System.out.println(securityEvent.toString());

		}

		Event y = eventsUnit.getTopPriority();
		System.out.println(y.toString());

		ArrayList<Event> z = eventsUnit.getSortedEvents();
		printList(z);

		eventsUnit.saveEventsData();
		System.out.println("data  saved");

	}
}
