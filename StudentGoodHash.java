package assign09;

import java.text.DecimalFormat;

/**
 * Represents a student with attributes optimized for generating hash codes.
 * This class provides fields to store a unique identifier (UID), first name,
 * and last name of a student. It implements a good hash code generation method
 * to minimize collisions in hash-based data structures.
 * 
 * @author Erin Parker and Phuc Do and Khang Nguyen
 * 
 * @version April 04, 2024
 */
public class StudentGoodHash {

	private int uid;
	private String firstName;
	private String lastName;

	/**
	 * Creates a new student with the specified uid, firstName, and lastName.
	 *
	 * @param uid
	 * @param firstName
	 * @param lastName
	 */
	public StudentGoodHash(int uid, String firstName, String lastName) {
		this.uid = uid;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the UID for this student object
	 */
	public int getUid() {
		return this.uid;
	}

	/**
	 * @return the first name for this student object
	 */

	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * @return the last name for this student object
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * @return true if this student and 'other' have the same UID, first name, and
	 *         last name; false otherwise
	 */
	public boolean equals(Object other) {
		// change to StudentMediumHash and StudentGoodHash for two new classes
		if (!(other instanceof StudentGoodHash))
			return false;

		StudentGoodHash rhs = (StudentGoodHash) other;

		return this.uid == rhs.uid && this.firstName.equals(rhs.firstName) && this.lastName.equals(rhs.lastName);
	}

	/**
	 * @return a textual representation of this student
	 */
	public String toString() {
		DecimalFormat formatter = new DecimalFormat("0000000");
		return firstName + " " + lastName + " (u" + formatter.format(uid) + ")";
	}

	/**
	 * Generates a hash code for this StudentGoodHash object. This method overrides
	 * the hashCode() method from the Object class. It calculates the hash code
	 * based on the UID, first name, and last name of the student using a formula
	 * that incorporates the properties of the Object.hashCode() method and aims to
	 * distribute hash codes more evenly to reduce collisions.
	 *
	 * @return The hash code generated for this StudentGoodHash object.
	 */
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + uid;
		hash = 31 * hash + firstName.hashCode();
		hash = 31 * hash + lastName.hashCode();
		return hash;
	}
}
