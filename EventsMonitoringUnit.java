
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.*;

public class EventsMonitoringUnit implements Serializable {
	private ArrayList<Citizen> citizens;
	private ArrayList<Event> events;

	// constructor
	public EventsMonitoringUnit() {
		citizens = new ArrayList<Citizen>();
		events = new ArrayList<Event>();
	}

	// addEvent
	public void addEvent(Event event) {
		for (Event e : this.events) // ���� ����� �����
			if (e.equals(event)) // �� ������ ��� ������ �������
				return;
		events.add(event);
	}

	// addCitizen
	public void addCitizen(Citizen citizen) {
		for (Citizen c : this.citizens) // ���� ���� �����
			if (c.equals(citizen)) // �� ����� ��� ����� �������
				return;
		citizens.add(citizen);
	}

	// addComment
	public void addComment(Comment comment, int eventId) {
		for (Event e : this.events) // ���� ����� �����
			if (e.getEId() == eventId) // �� ���� ����� �� ����� ���� ����� ����� �������
			{
				e.addComment(comment);
				return;
			}
		System.out.println("The event ID entered is not in the list."); // �� �� ���� �� ����� ������� �� ������, �����
																		// �� �����
	}

	// getEventsByType
	public ArrayList<Event> getEventsByType(String type) {
		ArrayList<Event> list = new ArrayList<Event>(); // ���� ����
		for (Event e : this.events) // ���� ����� �����
			if (e.getType().equals(type)) // �� ���� ���� ���� �������
				list.add(e);
		if (list.isEmpty()) // �� ����� ���� ���
			return null;
		return list;
	}

	// getNumOfEventsByLevel
	public int getNumOfEventsByLevel(Level level) {
		int counter = 0;
		for (Event e : this.events) // ���� ����� �����
			if (e.getLevel() == level) // �� ���� �� ������ ���� ���� ������ ������
				counter++;
		return counter;
	}

	// getSecurityEvents
	public ArrayList<SecurityEvent> getSecurityEvents() {
		ArrayList<SecurityEvent> list = new ArrayList<SecurityEvent>();
		for (Event e : this.events) // ���� ����� �����
			if (e instanceof SecurityEvent
					&& ((SecurityEvent) e).getPoliceCount() > ((SecurityEvent) e).getMedicCount()) // �� ���� ���� ����
																									// �������
				list.add((SecurityEvent) e);
		if (list.isEmpty()) // �� ����� ���� ���
			return null;
		return list;
	}

//getTopPriority
	public Event getTopPriority() {
		Event temp = new Event("murder", new Date(), Level.LOW,
				new Citizen("1", "temp", new Date(), "null", Gender.MALE));
		for (Event e : this.events) {
			if (e instanceof SecurityEvent || e instanceof HostileEvent)
				if (e.priority() > temp.priority())
					temp = e;
		}
		return temp;
	}

	// getDanderList
	public ArrayList<Danger> getDangerList() {
		ArrayList<Danger> isDangerLst = new ArrayList<>();
		for (Citizen c : citizens) {
			if (c instanceof Danger) {
				Danger dc = ((Danger) c);
				isDangerLst.add(dc);
			}
		}
		for (Event e : events) {
			if (e instanceof Danger) {
				Danger de = ((Danger) e);
				isDangerLst.add(de);
			}
		}
		return isDangerLst;
	}

	// getAvgPriortiy
	public double getAvgPriority() {
		int sum = 0;
		for (Event e : events) {
			sum += e.priority();
		}
		return sum / events.size();

	}

	// getSortedEvents
	public ArrayList<Event> getSortedEvents() {
		ArrayList<Event> sortedlist = new ArrayList<Event>(events);
		Comparator<Event> comparator = new Comparator<Event>() {
			@Override
			public int compare(Event o1, Event o2) {
				Integer i1 = o1.priority();
				Integer i2 = o2.priority();

				return i2.compareTo(i1);
			}
		};
		Collections.sort(sortedlist, comparator);
		return sortedlist;

	}

	// getSortedEventsBySerialNUmber
	public ArrayList<Event> getSortedEventsBySerialNo() {
		ArrayList<Event> sortedlist = new ArrayList<Event>(events);
		Comparator<Event> comparator = new Comparator<Event>() {
			@Override
			public int compare(Event o1, Event o2) {
				Integer i1 = o1.getEId();
				Integer i2 = o2.getEId();

				return i1.compareTo(i2);
			}
		};
		Collections.sort(sortedlist, comparator);
		return sortedlist;
	}

	// loadEventsDAte()
	public void loadEventsData() {
		try {
			FileInputStream load = new FileInputStream("Events.bn");
			ObjectInputStream in = new ObjectInputStream(load);
			Object o = in.readObject();
			if (o instanceof ArrayList) {
				this.events = ((ArrayList<Event>) o);
			}
			load.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// saveEventsDate
	public void saveEventsData() {
		try {
			FileOutputStream fos = new FileOutputStream("Events.bn");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(events);
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// wrireCitizenListToFile
	public void writeCitizenListToFile() {
		try {
			PrintWriter fileOut = new PrintWriter("citizens.txt ");
			fileOut.println(citizens.toString()); // ???
			fileOut.close();
		} catch (FileNotFoundException e) { // ????????
			e.printStackTrace();
		}
	}

	// getTopReporters
	// 1
	public int Count_Events_For_Citizen(Citizen c) {
		int count = 0;
		for (Event ev : events) {
			if (ev.getCitizen() == c) {
				count++;
			}
		}
		return count;
	}

	// 2
	public int CountCommentsForCitizen(Citizen c) {
		int cnt = 0;
		for (Event ev2 : events) {
			ArrayList<Comment> tmpComments = ev2.getComments();
			for (Comment comm : tmpComments) {
				if (comm.getCitizen() == c) {
					cnt++;

				}
			}
		}
		return cnt;
	}

	// 3
	public List<Citizen> getTopReporters() {
		List<Citizen> topcitizens = new ArrayList<>();
		int numofevents = 0;
		int numofcomments = 0;
		for (Citizen c : citizens) {
			numofevents = Count_Events_For_Citizen(c);
			numofcomments = CountCommentsForCitizen(c);
			if (numofevents > numofcomments) {
				topcitizens.add(c);
			}
		}
		return topcitizens;
	}

	// checkMultiple
	public boolean checkIfMultiple(Event e) {
		int num_of_citizens = 0;
		for (Event e1 : events) {
			if (e1.equals(e)) {
				num_of_citizens++;
			}
		}
		if (num_of_citizens > 1)
			return true;
		return false;
	}
}
