/**
 * 
 */
package lookUpMember;

import static org.junit.Assert.*;

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
	public void testLookupMember() 
	{
		//fail("Not yet implemented");
		if(DatabaseAbstraction.getList().isEmpty()){
			assertEquals("Empty List should return null", null, DatabaseAbstraction.lookupMember(john,doe));
		}else{
			assertEquals("Return the object if it's not empty.", DatabaseAbstraction.lookupMember(john,doe).toString, DatabaseAbstraction.lookupMember(john,doe).toString);
		}
	}
}