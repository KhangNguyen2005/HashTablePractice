package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the StudentBadHash class. It covers
 * various scenarios including testing getter methods, equals method, and
 * hashCode method.
 * 
 * @author Erin Parker and Phuc Do and Khang Nguyen
 * 
 * @version April 04, 2024
 */
class StudentBadHashTest {
	StudentBadHash student1;
	StudentBadHash student2;
	StudentBadHash student3;
	StudentBadHash student4;
	StudentBadHash student5;
	StudentBadHash student6;

	@BeforeEach
	void setUp() throws Exception {
		StudentBadHash student1 = new StudentBadHash(01234567, "Khang", "Nguyen");
		StudentBadHash student2 = new StudentBadHash(01435671, "Micheal", "Kors");
		StudentBadHash student3 = new StudentBadHash(02453433, "Jimmy", "Choo");
		StudentBadHash student4 = new StudentBadHash(01111111, "Saint", "Laurent");
		StudentBadHash student5 = new StudentBadHash(02345327, "Louis", "Vuiton");
		StudentBadHash student6 = new StudentBadHash(001111111, "Saint", "Laurent");

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
		assertEquals(1, student1.hashCode());
		assertEquals(1, student2.hashCode());
		assertEquals(1, student3.hashCode());
		assertEquals(1, student4.hashCode());
		assertEquals(1, student5.hashCode());
		assertEquals(1, student6.hashCode());

	}
}
