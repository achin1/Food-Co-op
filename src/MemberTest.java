import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;


public class MemberTest {
	private Member testMember;

	@Before
	public void setUp() throws Exception {
		testMember = DatabaseAbstraction.lookupMember("John", "Smith").get(0);
	}

	@Test
	public void testMemberIntStringStringStringDateIntIntIntBooleanBoolean() {
		Member tmp = new Member(2, "Foo", "Bar", "fbar@example.com",
				new Date(1234567890), 1, 3, 1, false, true
		);
		assertEquals(2, tmp.getId());
		assertEquals("Foo", tmp.getFirstName());
		assertEquals("Bar", tmp.getLastName());
		assertEquals("Year", tmp.getMembershipLength());
		assertEquals("Coordinator", tmp.getMembershipType());
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
	
	@Test
	public void testGetMembershipType() {
		assertEquals("Working", testMember.getMembershipType());
	}
	
	@Test
	public void testGetMembershipLength() {
		assertEquals("Year", testMember.getMembershipLength());
	}
}
