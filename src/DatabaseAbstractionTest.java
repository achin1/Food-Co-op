import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


/**
 * @author Jonathan
 *
 */
public class DatabaseAbstractionTest{

	/**
	 * Test method for {@link DatabaseAbstraction#lookupMember(String, String)}.
	 */
	@Test
	public void testLookupMember() {
		//fail("Not yet implemented");
		if(DatabaseAbstraction.lookupMember("john", "doe").isEmpty()){
			assertEquals("Empty List should return 0", 0, DatabaseAbstraction.lookupMember("john", "doe").size());
		}else{
			ArrayList<Member> testList = DatabaseAbstraction.lookupMember("john","doe");
			for(Member m: testList){
				assertEquals("john", m.getFirstName());
				assertEquals("doe", m.getLastName());				
			}
		}		
	} 
}
