import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


/*
 * @author JonathanGarcia
 */
public class DatabaseAbstractionTest{

	/*
	 * Test method for {@link DatabaseAbstraction#lookupMember(String, String)}.
	 */
	@Test
	public void testLookupMember() {
		//fail("Not yet implemented");
		ArrayList<Member> testList = DatabaseAbstraction.lookupMember("John","Smith");

		if(testList.size() != 0){
			for(Member m: testList){			
				assertEquals("John Smith", m.getFirstName()+" "+m.getLastName());				
			}
		}else{
			assertEquals("Empty List should return a size of 0", 0, testList.size());			
		}		
	} 
}