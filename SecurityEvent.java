import java.util.Date;

public class SecurityEvent extends Event implements Danger {
	private int policeCount;
	private int medicCount;

	public SecurityEvent(String type, Date startedEvent, Level level, Citizen citizen, int policeCount,
			int medicCount) {
		super(type, startedEvent, level, citizen);
		this.policeCount = policeCount;
		this.medicCount = medicCount;
	}

	// getters and setters
	public int getPoliceCount() {
		return this.policeCount;
	}

	public int getMedicCount() {
		return this.medicCount;
	}

	public void setPoliceCount(int policeCount) {
		this.policeCount = policeCount;
	}

	public void setMedicCount(int medicCount) {
		this.medicCount = medicCount;
	}

	// equals
	@Override
	public boolean equals(Object e) {
		if (e instanceof SecurityEvent)
			if (this.getEId() == ((SecurityEvent) e).getEId()) // �� ����� ����� �����
				return true;
		return false;
	}

	// toString
	@Override
	public String toString() {
		return super.toString() + " [policeCount=" + policeCount + ", medicCount=" + medicCount + "]";
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
		int temp = this.medicCount + this.policeCount;
		if (temp % 2 != 0)
			temp++;
		x = x + temp / 2;
		return x;
	}

//isDanger
	@Override
	public boolean isDanger() {
		if (getMedicCount() / getPoliceCount() > 3) {
			return true;
		}
		return false;
	}

}
