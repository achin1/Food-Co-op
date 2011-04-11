
import java.util.ArrayList;

public class Controller
{
	private Model model;
	private MainFrame mainFrame;

	public Controller (Model model)
	{
		this.model = model;
		mainFrame = new MainFrame(this, model);
	}
	
	/**
	 * Try Catch Method.
	 * Executes when a query is sent to the model and handles the response.
	 * View will call this method on lookUpMember(). 
	 * If an exception is made, it runs the createEmptyArrayList method as the return
	 * @param first name, last name
	 * @return array list of members 
	 **/
	public ArrayList<Member> lookUpMember(String firstName, String lastName)
	{
		ArrayList<Member> searchResult = new ArrayList<Member>();
		
		try
		{
			searchResult = model.lookupMember(firstName,lastName);
		} 
		catch(Exception e)
		{
			mainFrame.displayException(e.getMessage());
		}
		
		return searchResult;
	}
}
