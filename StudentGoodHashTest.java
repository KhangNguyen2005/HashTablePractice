package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * This class contains unit tests for the StudentGoodHash class. It covers
 * various scenarios including testing getter methods, equals method, and
 * hashCode method.
 * 
 * @author Erin Parker and Phuc Do and Khang Nguyen
 * 
 * @version April 04, 2024
 */
class StudentGoodHashTest {

	StudentGoodHash student1;
	StudentGoodHash student2;
	StudentGoodHash student3;
	StudentGoodHash student4;
	StudentGoodHash student5;
	StudentGoodHash student6;

	@BeforeEach
	void setUp() throws Exception {
		StudentGoodHash student1 = new StudentGoodHash(01234567, "Khang", "Nguyen");
		StudentGoodHash student2 = new StudentGoodHash(01435671, "Micheal", "Kors");
		StudentGoodHash student3 = new StudentGoodHash(02453433, "Jimmy", "Choo");
		StudentGoodHash student4 = new StudentGoodHash(01111111, "Saint", "Laurent");
		StudentGoodHash student5 = new StudentGoodHash(02345327, "Louis", "Vuiton");
		StudentGoodHash student6 = new StudentGoodHash(001111111, "Saint", "Laurent");

		this.student1 = student1;
		this.student2 = student2;
		this.student3 = student3;
		this.student4 = student4;
		this.student5 = student5;
		this.student6 = student6;
	}

	@Test
	void testGetUid() {
		assertEquals(01234567, student1.getUid());
		assertEquals(01435671, student2.getUid());
		assertEquals(02453433, student3.getUid());
		assertEquals(01111111, student4.getUid());
		assertEquals(02345327, student5.getUid());
	}

	@Test
	void testGetFirstName() {
		assertEquals("Khang", student1.getFirstName());
		assertEquals("Micheal", student2.getFirstName());
		assertEquals("Jimmy", student3.getFirstName());
		assertEquals("Saint", student4.getFirstName());
		assertEquals("Louis", student5.getFirstName());

	}

	@Test
	void testGetLastName() {
		assertEquals("Nguyen", student1.getLastName());
		assertEquals("Kors", student2.getLastName());
		assertEquals("Choo", student3.getLastName());
		assertEquals("Laurent", student4.getLastName());
		assertEquals("Vuiton", student5.getLastName());
	}

	@Test
	void testEquals() {
		assertTrue(student4.equals(student6));

		assertFalse(student1.equals(student2));
		assertFalse(student1.equals(student3));
		assertFalse(student1.equals(student4));
		assertFalse(student1.equals(student5));
		assertFalse(student1.equals(student6));

	}

	@Test
	void testHashCode() {
		
		assertEquals(hashTemp(student1.getUid(), student1.getFirstName(), student1.getLastName()), student1.hashCode());
		assertEquals(hashTemp(student2.getUid(), student2.getFirstName(), student2.getLastName()), student2.hashCode());
		assertEquals(hashTemp(student3.getUid(), student3.getFirstName(), student3.getLastName()), student3.hashCode());
		assertEquals(hashTemp(student4.getUid(), student4.getFirstName(), student4.getLastName()), student4.hashCode());
		assertEquals(hashTemp(student5.getUid(), student5.getFirstName(), student5.getLastName()), student5.hashCode());
		assertEquals(hashTemp(student6.getUid(), student6.getFirstName(), student6.getLastName()), student6.hashCode());


	}
	private int hashTemp(int uid, String firstName, String lastName) {
		int hash = 7;
        hash = 31 * hash + uid;
        hash = 31 * hash + firstName.hashCode();
        hash = 31 * hash + lastName.hashCode();
        return hash;
	}
}
