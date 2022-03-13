import java.util.*;

public class Citizen implements Danger {
	private String id;
	private String fullName;
	private Date birthDate;
	private String email;
	private Gender gender;

	// constructor
	public Citizen(String id, String fullName, Date birthDate, String email, Gender gender) // ����
	{
		this.id = id;
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.email = email;
		this.gender = gender;
	}

	// get and set
	public String getId() {
		return this.id;
	}

	public String getFullName() {
		return this.fullName;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public String getEmail() {
		return this.email;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	// equals
	public boolean equals(Object c) {
		if (c instanceof Citizen)
			if (this.getId() == ((Citizen) c).getId() && this.getEmail() == ((Citizen) c).getEmail()) // �� ������� ���
																										// ��"� ����
				return true;
		return false;
	}

	// to string
	public String toString() {
		return "Citizen:\nID: " + this.id + "\nFullName: " + this.fullName + "\nBirthDate: " + this.birthDate
				+ "\nEmail: " + this.email + "\nGender: " + this.gender;
	}
//isDander
	@Override
	public boolean isDanger() {
		if (getEmail().contains("gun")) {
			return true;
		}
		return false;
	}
}
