import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;


public class MemberTest {
	private Member testMember;

	@Before
	public void setUp() throws Exception {
		testMember = new Member(1, "Foo", "Bar", "fbar@example.com",
				new Date(1234567890), 1, 1, 2, false, true
		);
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
		fail("Not yet implemented (cannot yet be programmatically checked)");
	}

	@Test
	public void testGetFirstName() {
		assertEquals("Foo", testMember.getFirstName());
	}

	@Test
	public void testSetFirstName() {
		testMember.setFirstName("Baz");
		assertEquals("Baz", testMember.getFirstName());
	}

	@Test
	public void testGetLastName() {
		assertEquals("Bar", testMember.getLastName());
	}

	@Test
	public void testSetLastName() {
		testMember.setLastName("Baz");
		assertEquals("Baz", testMember.getLastName());
	}

	@Test
	public void testGetId() {
		assertEquals(1, testMember.getId());
	}

}
