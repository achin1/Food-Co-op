import java.util.ArrayList;
import java.util.Date;

public class Member extends Model {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private Date last_signup_date;
	private int membership_length;
	private int membership_type;
	private int year_in_school;
	private boolean recieve_email;
	private boolean is_active;
	
	public Member() {}
	
	public Member(int id, String firstName, String lastName, String email,
			Date last_signup_date, int membership_length, int membership_type,
			int year_in_school, boolean recieve_email, boolean is_active) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.last_signup_date = last_signup_date;
		this.membership_length = membership_length;
		this.membership_type = membership_type;
		this.year_in_school = year_in_school;
		this.recieve_email = recieve_email;
		this.is_active = is_active;
	}

	public static ArrayList<Member> all() {
		return DatabaseAbstraction.allMember();
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
