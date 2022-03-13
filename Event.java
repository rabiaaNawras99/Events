import java.util.*;

public class Event // I changed the variable type of count to Static due to the code not working
					// properly otherwise!
{
	private int eId;
	private String type;
	private ArrayList<Comment> comments;
	private Date startedEvent;
	private static int count = 0;
	private Level level;
	private Citizen citizen;

	public Event(String type, Date startedEvent, Level level, Citizen citizen) {
		Event.count++;
		this.eId = count;
		this.type = type;
		this.startedEvent = startedEvent;
		this.level = level;
		this.citizen = citizen;
		this.comments = new ArrayList<Comment>();
	}
	// getters and setters

	public int getEId() {
		return this.eId;
	}

	public String getType() {
		return this.type;
	}

	public ArrayList<Comment> getComments() {
		return this.comments;
	}

	public Date getStartedEvent() {
		return this.startedEvent;
	}

	public int getCount() {
		return Event.count;
	}

	public Level getLevel() {
		return this.level;
	}

	public Citizen getCitizen() {
		return this.citizen;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

	public void setStartedEvent(Date startedEvent) {
		this.startedEvent = startedEvent;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	// equals
	public boolean equals(Object e) {
		if (e instanceof Event)
			if (this.getEId() == ((Event) e).getEId()) // �� ����� ����� �����
				return true;
		return false;
	}

	// toString
	public String toString() {
		return getClass().getName() + "\nID: " + this.eId + "\nType: " + this.type + "\nDate: " + this.startedEvent
				+ "\nLevel: " + this.level;
	}

	// getCommentsNumber
	public int getCommentsNumber() {
		return this.comments.size();
	}

	// addComment
	public void addComment(Comment comment) {
		this.comments.add(comment);
	}

	// removeComment
	public boolean removeComment(Comment comment) {
		for (Comment c : this.comments) // ���� ����� �����
			if (c.equals(comment)) // �� ����
			{
				comments.remove(c);
				return true;
			}
		return false;
	}

	public int priority() {
		int x = 0;
		if (this.getLevel() == Level.HIGH)
			x = x + 5;
		if (this.getLevel() == Level.MID)
			x = x + 3;
		if (this.getLevel() == Level.LOW)
			x = x + 1;
		return x;
	}

}
