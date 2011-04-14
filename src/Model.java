import java.sql.Time;
import java.util.ArrayList;

public class Model 
{
	
	private ArrayList<Member> signedIntoKitchen = new ArrayList<Member>();
	private ArrayList<Member> signedIntoStore = new ArrayList<Member>();
	
	public ArrayList<Member> lookupMember(String firstName, 
			String lastName) throws Exception
	{
		//throw new Exception();
		return DatabaseAbstraction.lookupMember(firstName, lastName);
	}

	public ArrayList<Member> getSignedIntoKitchen() {
		return signedIntoKitchen;
	}

	public ArrayList<Member> getSignedIntoStore() {
		return signedIntoStore;
	}
	
	public ArrayList<Member> signIntoKitchen(int index) throws Exception
	{
		if(matches.get(index).canSignIn())
		{
			for(int i = 0; i < signedIntoKitchen.size(); i++)
			{
				if(signedIntoKitchen.get(i).equals(matches.get(index)))
				{
					throw new Exception("Already Signed into Kitchen");
				}
			}
			for(int i = 0; i < signedIntoStore.size(); i++)
			{
				if(signedIntoStore.get(i).equals(matches.get(index)))
				{
					throw new Exception("Already Signed into Store");
				}
				long time;
			matches.get(index).setLastSignIn(new Time(time));
			signedIntoKitchen.add(matches.get(index));
			}
		}
		else
		{
			throw new Exception();
		}
		
		return signedIntoKitchen;
	}
	
	public ArrayList<Member> signIntoStore(int index) throws Exception
	{
		if(matches.get(index).canSignIn())
		{
			for(int i = 0; i < signedIntoStore.size(); i++)
			{
				if(signedIntoStore.get(i).equals(matches.get(index)))
				{
					throw new Exception("Already Signed into Kitchen");
				}
			}
			for(int i = 0; i < signedIntoKitchen.size(); i++)
			{
				if(signedIntoKitchen.get(i).equals(matches.get(index)))
				{
					throw new Exception();
				}
				long time;
			matches.get(index).setLastSignIn(new Time(time));
			throw new Exception("Already Signed into Store");
			}
		}
		else
		{
			throw new Exception();
		}
		return signedIntoStore;
	}
	

}