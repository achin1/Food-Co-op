import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MainFrame test = new MainFrame();	
		/**
		 * Test arrays in place of missing methods (Wang)
		 * 
		 * 
		 */
		ArrayList <String> testArray = new ArrayList<String>();
		testArray.add("Michael Wang Coordinator mwang10@binghamton.edu");
		testArray.add("Jeremy Kloner Coordinator jklon1@binghamton.edu");
		testArray.add("Jeremy Simpson Core jsimpso1@binghamton.edu");
		testArray.add("Jeremy Smith Volunteer jsmith1@binghamton.edu");
		test.printSearchResult(testArray);
		//test.printSearchResult();
		//test.lookUpError("LULZZZ");

	}

}
