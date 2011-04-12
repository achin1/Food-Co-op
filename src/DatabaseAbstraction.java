import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;

public class DatabaseAbstraction
{
	/**
	* Connects to the hardcoded database file "database.sqlite3".
	* @return connection 	The connection to the database
	* @return null   		If no connection can be made.
	*/
	private static Connection connectToDatabase()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			Connection connection = 
				DriverManager.getConnection("jdbc:sqlite:db/database.sqlite3");
			connection.setAutoCommit(false);
			connection.setAutoCommit(true);
			return connection;
		} 
		catch (Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	/**
	* Connects to the queries the database and then queries it given the input
	* parameters.  Uses a PreparedStatement instead of a regular Statement so 
	* that no matter what characters are in the input strings, they are placed
	* directly in the database and won't affect the statement in any way.
	* @param first_name		First name of the member to look for
	* @param last_name		Last name of the member to look for
	* @return memberList	An arraylist of member objects which match the 
	*						parameters
	*/
	public static ArrayList<Member> lookupMember(String first_name, 
		String last_name)
	{
		ArrayList<Member> memberList = new ArrayList<Member>();

		try
		{
			Connection connection = connectToDatabase();
			PreparedStatement ps = connection.prepareStatement(
				"SELECT * FROM members WHERE first_name = ? AND " +
				"last_name = ?");
			ps.setString(1, first_name);
			ps.setString(2, last_name);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next())
			{
				Member m = new Member(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("email_address"),
					new Date((long)rs.getInt("last_signup_date")),
					rs.getInt("membership_length"),
					rs.getInt("membership_type"),
					rs.getInt("year_in_school"),
					(rs.getInt("receive_email") != 0),
					(rs.getInt("is_active") != 0)
				);
				memberList.add(m);
			}
			rs.close();
			ps.close();
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return memberList;
	}
	
	/**
	* Adds a member to the database.  Uses a PreparedStatement.
	* @param first_name			First name of the member to look for
	* @param last_name			Last name of the member to look for
	* @param membership_length	Length of member's membership, 0 for
									half semester, 1 for full ??
	* @param membership_type	Membership type ??
	* @param year_in_school		Member's year in school 0 for freshman
									1 for sophomore, 2 for junior,
									3 for senior, 4 for graduate,
									5 for faculty ??
	* @param receive_email		Can the member receive emails from the
									Food Co-op?
	* @param is_active			Is this member active?
	*/
	public static void addMember(String first_name, 
		String last_name,
		String email_address,
		int membership_length,
		int membership_type,
		int year_in_school,
		int is_active)
	{
		Date last_signup_date = new Date();
		try
		{
			Connection connection = connectToDatabase();
			PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO members VALUES(?,?,?,?,?,?,?,?,?,?)");
			ps.setNull(1, java.sql.Types.INTEGER);
			ps.setString(2, first_name);
			ps.setString(3, last_name);
			ps.setString(4, email_address);
			ps.setLong(5, last_signup_date.getTime()); // Is setLong correct?
			ps.setInt(6, membership_length);
			ps.setInt(7, membership_type);
			ps.setInt(8, year_in_school);
			ps.setInt(9, is_active);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}		
	}
	
	/**
	* Updates a member in the database.  Uses a PreparedStatement.
	* @param m 	updated Member object.
	*/
	public static void updateMember(Member m)
	{
		try
		{
			Connection connection = connectToDatabase();
			PreparedStatement ps = connection.prepareStatement(
				"UPDATE members SET " +
				"first_name = ?, " +
				"last_name = ?, " +
				"email_address = ?, " +
				"membership_length = ?, " +
				"membership_type = ?, " +
				"year_in_school = ?, " +
				"is_active = ? " +
				"WHERE id = ?"
			);
			ps.setString(1, m.getFirstName());
			ps.setString(2, m.getLastName());
			ps.setString(3, m.getEmailAddress());
			ps.setInt(4, m.getMembershipLengthInt());
			ps.setInt(5, m.getMembershipTypeInt());
			ps.setInt(6, m.getYearInSchool());
			ps.setInt(7, 1); // set to true by default
			ps.setInt(8, m.getId());
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}		
	}
	
	/**
	* Deactives a member.  Uses a PreparedStatement.
	* @param m 	Member to deactivate
	*/
	public static void deactivateMember(Member m)
	{
		try
		{
			Connection connection = connectToDatabase();
			PreparedStatement ps = connection.prepareStatement(
				"UPDATE members SET " +
				"is_active = 0 " +
				"WHERE id = ?"
			);
			ps.setInt(1, m.getId());
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}		
	}
	
	/**
	* Reactivates a member.  Uses a PreparedStatement.
	* @param m 	Member to reactivate
	*/
	public static void reactivateMember(Member m)
	{
		try
		{
			Connection connection = connectToDatabase();
			PreparedStatement ps = connection.prepareStatement(
				"UPDATE members SET " +
				"is_active = 1 " +
				"WHERE id = ?"
			);
			ps.setInt(1, m.getId());
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}		
	}
	
	/**
	* Extends a member's membership.  Uses a PreparedStatement.
	* @param m 					Member to receive extension
	* @param membership_length 	New membership_length
	*/
	public static void extendMembership(Member m, int membership_length)
	{
		try
		{
			Connection connection = connectToDatabase();
			PreparedStatement ps = connection.prepareStatement(
				"UPDATE members SET " +
				"membership_length = ? " +
				"WHERE id = ?"
			);
			ps.setInt(1, membership_length);
			ps.setInt(2, m.getId());
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}		
	}
	
	// TODO: what if an IOU already exists?  it makes sense to add to it
	/**
	* Extends a member's membership.  Uses a PreparedStatement.
	* @param m 					Member to receive extension
	* @param membership_length 	New membership_length
	*/
	public static void addIOU(Member m, int amount)
	{
		try
		{
			Connection connection = connectToDatabase();
			PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO member_iou values(?, ?) ");
			ps.setInt(1, m.getId());
			ps.setInt(2, amount);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}		
	}
	
	/**
	* Adds a shift to the.  Uses a PreparedStatement.
	* @param m 					Member to receive extension
	* @param startTime		 	start_time in the database
	* @param numberOfMinutes 	How long the shift lasted, in minutes
	* @param workType		 	job_type in the database
	*/
	public static void addShift(Member m, Date startTime, 
		int numberOfMinutes, String workType)
	{
		try
		{
			Connection connection = connectToDatabase();
			PreparedStatement ps = connection.prepareStatement(
				"INSERT INTO shifts values(?, ?, ?, ?, ?) ");
			ps.setNull(1, java.sql.Types.INTEGER);
			ps.setInt(2, mgetID());
			ps.setInt(3, startTime);
			ps.setInt(4, numberOfMinutes);
			ps.setInt(5, workType);
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}		
	}
}