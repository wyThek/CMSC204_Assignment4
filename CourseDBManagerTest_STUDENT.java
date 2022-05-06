
import static org.junit.Assert.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Yei Thek Wang
 *
 */

public class CourseDBManagerTest_STUDENT {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC204", 66532, 4, "SC120", "John Cena");
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	@Test
	public void testShowAll() {
		dataMgr.add("CMSC204", 66532, 4, "SC120", "John Cena");
		dataMgr.add("CMSC204", 17381, 4, "SC220", "Michael Jordan");
		dataMgr.add("CMSC204", 33123, 4, "SC290", "Kim Jong Un");
		ArrayList<String> list = dataMgr.showAll();
		assertEquals(list.get(0), "\nCourse:CMSC204 CRN:66532 Credits:4 Instructor:John Cena Room:SC120");
		assertEquals(list.get(1), "\nCourse:CMSC204 CRN:33123 Credits:4 Instructor:Kim Jong Un Room:SC290");
		assertEquals(list.get(2), "\nCourse:CMSC204 CRN:17381 Credits:4 Instructor:Michael Jordan Room:SC220");

	}

	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("StudentTest.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC204 23415 4 SC220 John Cena");
			inFile.print("CMSC204 66532 2 SC120 Kim Jong Un");
			inFile.close();
			
			dataMgr.readFile(inputFile);
			assertEquals("CMSC204", dataMgr.get(23415).getID());
			assertEquals("CMSC204", dataMgr.get(66532).getID());
			assertEquals("SC120", dataMgr.get(66532).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}