import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MemberTest {
	private Member testMember;

	@Before
	public void setUp() throws Exception {
		testMember = DatabaseAbstraction.lookupMember("John", "Smith").get(0);
	}

	@Test
	public void testMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testMemberIntStringStringStringDateIntIntIntBooleanBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByName() {
		assertEquals(testMember.getId(), Member.findByName("John", "Smith").get(0).getId());
	}

	@Test
	public void testGetFirstName() {
		assertEquals("John", testMember.getFirstName());
	}

	@Test
	public void testSetFirstName() {
		testMember.setFirstName("John");
		assertEquals("John", testMember.getFirstName());
	}

	@Test
	public void testGetLastName() {
		assertEquals("Smith", testMember.getLastName());
	}

	@Test
	public void testSetLastName() {
		testMember.setLastName("Smith");
		assertEquals("Smith", testMember.getLastName());
	}

	@Test
	public void testGetId() {
		assertEquals(1, testMember.getId());
	}

}
