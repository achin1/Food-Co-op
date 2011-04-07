import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

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
		} catch (Exception e)
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
}