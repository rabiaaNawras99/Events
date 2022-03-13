import java.util.Date;

public class HostileEvent extends Event {
	private int magenDistance;

	// constructor
	public HostileEvent(String type, Date startedEvent, Level level, Citizen citizen, int magenDistance) {
		super(type, startedEvent, level, citizen);
		this.magenDistance = magenDistance;
	}

	// gtters and setetrs
	public int getMagenDistance() {
		return this.magenDistance;
	}

	public void setMagenDistance(int magenDistance) {
		this.magenDistance = magenDistance;
	}

	// equals
	@Override
	public boolean equals(Object e) {
		if (e instanceof HostileEvent)
			if (this.getEId() == ((HostileEvent) e).getEId()) // �� ����� ����� �����
				return true;
		return false;
	}

	// toString
	@Override
	public String toString() {
		return super.toString() + " [magenDistance=" + magenDistance + "]";
	}

	// priority
	public int priority() {
		int x = 0;
		if (this.getLevel() == Level.HIGH)
			x = x + 5;
		if (this.getLevel() == Level.MID)
			x = x + 3;
		if (this.getLevel() == Level.LOW)
			x = x + 1;
		return x + this.magenDistance;
	}

}
