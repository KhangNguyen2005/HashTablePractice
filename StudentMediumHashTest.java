package assign09;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the StudentMediumHash class. It covers
 * various scenarios including testing getter methods, equals method, and
 * hashCode method.
 * 
 * @author Erin Parker and Phuc Do and Khang Nguyen
 * 
 * @version April 04, 2024
 */
class StudentMediumHashTest {
	StudentMediumHash student1;
	StudentMediumHash student2;
	StudentMediumHash student3;
	StudentMediumHash student4;
	StudentMediumHash student5;
	StudentMediumHash student6;

	@BeforeEach
	void setUp() throws Exception {
		StudentMediumHash student1 = new StudentMediumHash(01234567, "Khang", "Nguyen");
		StudentMediumHash student2 = new StudentMediumHash(01435671, "Micheal", "Kors");
		StudentMediumHash student3 = new StudentMediumHash(02453433, "Jimmy", "Choo");
		StudentMediumHash student4 = new StudentMediumHash(01111111, "Saint", "Laurent");
		StudentMediumHash student5 = new StudentMediumHash(02345327, "Louis", "Vuiton");
		StudentMediumHash student6 = new StudentMediumHash(001111111, "Saint", "Laurent");

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
		assertEquals(student1.getUid() * student1.getFirstName().hashCode() * student1.getLastName().hashCode(),
				student1.hashCode());
		assertEquals(student2.getUid() * student2.getFirstName().hashCode() * student2.getLastName().hashCode(),
				student2.hashCode());
		assertEquals(student3.getUid() * student3.getFirstName().hashCode() * student3.getLastName().hashCode(),
				student3.hashCode());
		assertEquals(student4.getUid() * student4.getFirstName().hashCode() * student4.getLastName().hashCode(),
				student4.hashCode());
		assertEquals(student5.getUid() * student5.getFirstName().hashCode() * student5.getLastName().hashCode(),
				student5.hashCode());
		assertEquals(student6.getUid() * student6.getFirstName().hashCode() * student6.getLastName().hashCode(),
				student6.hashCode());

		assertNotEquals(student1.getUid() * student1.getFirstName().hashCode() * student1.getLastName().hashCode(),
				student2.hashCode());
		assertNotEquals(student2.getUid() * student2.getFirstName().hashCode() * student2.getLastName().hashCode(),
				student3.hashCode());

	}
}
