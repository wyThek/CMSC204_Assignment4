/**
 * CourseDBElement class - implements Comparable
 * 
 * @author Yei Thek Wang
 */

public class CourseDBElement implements Comparable<CourseDBElement> {

	protected String course;
	protected int crn;
	protected int credit;
	protected String room;
	protected String instructor;

	/**
	 * Constructor that sets all to null
	 */
	public CourseDBElement() {
		this(null, 00000, 0, null, null);
	}

	/**
	 * Constructor create new object with CRN
	 * 
	 * @param CRN
	 */
	public CourseDBElement(int CRN) {
		this.crn = CRN;
	}

	/**
	 * Constructor with multiple parameters.
	 * 
	 * @param id
	 * @param crn
	 * @param credits
	 * @param room
	 * @param teacher
	 */
	public CourseDBElement(String course, int crn, int credit, String room, String instructor) {
		this.course = course;
		this.crn = crn;
		this.credit = credit;
		this.room = room;
		this.instructor = instructor;
	}

	/**
	 * Returns the hash number
	 * 
	 * @return hash
	 */
	public int getHash() {
		int a = 31;
		int hash = 0;
		String str = String.valueOf(getCRN());
		for (int i = 0; i < str.length(); i++) {
			hash = a * hash + str.charAt(i);
		}
		return hash;
	}

	/**
	 * Returns the id of class
	 * 
	 * @return course
	 */
	public String getID() {
		return course;
	}

	/**
	 * Returns the CRN of a class
	 * 
	 * @return crn
	 */
	public int getCRN() {
		return crn;
	}

	/**
	 * Returns the credit number of a class
	 * 
	 * @return credit
	 */
	public int getCredit() {
		return credit;
	}

	/**
	 * Returns the room number of a class
	 * 
	 * @return room
	 */
	public String getRoomNum() {
		return room;
	}

	/**
	 * Return the name of the instructor of a class
	 * 
	 * @return instructor
	 */
	public String getInstructor() {
		return instructor;
	}

	/**
	 * Set the name of the course
	 * 
	 * @param course
	 */
	public void setCourse(String course) {
		this.course = course;
	}

	/**
	 * Set the CRN number of the class
	 * 
	 * @param crn
	 */
	public void setCRN(int crn) {
		this.crn = crn;
	}

	/**
	 * Set the credit hours for the class
	 * 
	 * @param credit
	 */
	public void setCredits(int credit) {
		this.credit = credit;
	}

	/**
	 * Set the classroom number
	 * 
	 * @param room
	 */
	public void setRoomNum(String room) {
		this.room = room;
	}

	/**
	 * Set the instructor for the class
	 * 
	 * @param instructor
	 */
	public void setinstructorName(String instructor) {
		this.instructor = instructor;
	}

	/**
	 * Compare two DataElements
	 * 
	 * @param CourseDBElement e
	 * @return Integer, comparison result
	 */
	@Override
	public int compareTo(CourseDBElement e) {
		if (e.crn == crn) {
			return 0;
		} else if (e.crn < crn) {
			return -1;
		} else {
			return 1;
		}
	}

	/**
	 * ToString method
	 */
	@Override
	public String toString() {
		String str = "\nCourse:" + course + " CRN:" + crn + " Credits:" + credit + " Instructor:" + instructor
				+ " Room:" + room;
		return str;
	}

}