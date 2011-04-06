import java.util.ArrayList;
import java.util.Date;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MainFrame test = new MainFrame();
		
		ArrayList <Member> testArray = new ArrayList<Member>();

		Date date = new Date(1111111111);
		Member test1 = new Member(1, "Michael", "Wang", "mwang10@binghamton.edu",date ,1,1,1,true,false);
		testArray.add(test1);
		test.printSearchResult(testArray);
		//System.out.println(test1.getLastName());
		//testArray.add("Michael Wang Coordinator mwang10@binghamton.edu");
		//testArray.add("Jeremy Kloner Coordinator jklon1@binghamton.edu");
		//testArray.add("Jeremy Simpson Core jsimpso1@binghamton.edu");
		//testArray.add("Jeremy Smith Volunteer jsmith1@binghamton.edu");
		//test.printSearchResult(testArray);

		//test.lookUpError("LULZZZ");

	}

}
