import java.util.ArrayList;
import java.sql.*;

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
				DriverManager.getConnection("jdbc:sqlite:database.sqlite3");
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
	* parameters
	* @param first_name		First name of the member to look for
	* @param last_name		Last name of the member to look for
	* @return memberList	An arraylist of member objects which match the 
	*						parameters
	*/
	public static ArrayList<Member> lookupMember(String first_name, String last_name)
	{
		ArrayList<Member> memberList = new ArrayList<Member>();
		
		try
		{
			Connection connection = connectToDatabase();
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM Members WHERE first_name='" + first_name + "' AND last_name='" + last_name + "';");
			while (rs.next())
			{
				Member m = new Member(
					rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getString("email"),
					new Date( (long) rs.getInt("last_signup_date") ),
					rs.getInt("membership_length"),
					rs.getInt("membership_type"),
					rs.getInt("year_in_school"),
					(rs.getInt("receive_email") != 0),
					(rs.getInt("is_active") != 0)
					);
				memberList.add(m);
			}
			connection.close();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return memberList;
	}
}