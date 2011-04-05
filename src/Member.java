import java.util.ArrayList;
import java.util.Date;

public class Member extends Model {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private Date lastSignupDate;
	private int membershipLength;
	private int membershipType;
	private int yearInSchool;
	private boolean receiveEmail;
	private boolean isActive;
	
	public Member() {}
	
	public Member(int id, String firstName, String lastName, String email,
			Date last_signup_date, int membership_length, int membership_type,
			int year_in_school, boolean recieve_email, boolean is_active) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.lastSignupDate = last_signup_date;
		this.membershipLength = membership_length;
		this.membershipType = membership_type;
		this.yearInSchool = year_in_school;
		this.receiveEmail = recieve_email;
		this.isActive = is_active;
	}
	
	public static ArrayList<Member> findByName(String firstName, String lastName) {
		return DatabaseAbstraction.lookupMember(firstName, lastName);
	}
	
	/**
	 * @deprecated Use findByName() instead.
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public static ArrayList<Member> lookupMember(String firstName, String lastName) {
		return findByName(firstName, lastName);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}
}
