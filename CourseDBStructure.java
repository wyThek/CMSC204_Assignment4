import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * CourseDBStructure class - implements CourseDBStructureInterface. It
 * implements a hash table with buckets. Each bucket will be an array of linked
 * lists of CourseDBElements.
 * 
 * @author Yei Thek Wang
 */

public class CourseDBStructure implements CourseDBStructureInterface {

	protected int hashSize;
	protected ArrayList<LinkedList<CourseDBElement>> hashTable;
	private final double loadFactor = 1.5;

	/**
	 * Constructor
	 * 
	 * @param cds
	 */
	public CourseDBStructure(int cds) {
		int i = (int) (cds / loadFactor);

		for (int j = 0; j < i; j++) {
			if ((4 * j + 3) > i) {
				if (isPrime(4 * j + 3)) {
					int size = 4 * j + 3;
					hashSize = size;
					break;
				}
			}
		}

		hashTable = new ArrayList<LinkedList<CourseDBElement>>(hashSize);

		for (int k = 0; k < hashSize; k++) {
			hashTable.add(new LinkedList<CourseDBElement>());
		}
	}

	/**
	 * Constructor
	 * 
	 * @param string
	 * @param cds
	 */
	public CourseDBStructure(String string, int cds) {
		hashSize = cds;
		hashTable = new ArrayList<LinkedList<CourseDBElement>>(hashSize);

		for (int i = 0; i < hashSize; i++) {
			hashTable.add(new LinkedList<CourseDBElement>());
		}
	}

	/**
	 * Add method which takes a CourseDBElement and then add it into the data
	 * structure
	 * 
	 * @param element a courseDBElement
	 */
	@Override
	public void add(CourseDBElement element) {
		int cds = element.getCRN() % hashSize;

		if (!(hashTable.get(cds).contains(element))) {
			hashTable.get(cds).add(element);
		}

		for (int i = 0; i < hashTable.get(cds).size(); i++) {
			if (!((CourseDBElement) hashTable.get(cds).get(i)).getID().equals(element.getID())) {
				if (((CourseDBElement) hashTable.get(cds).get(i)).getCRN() == element.getCRN()) {
					hashTable.get(cds).remove(i);
					hashTable.get(cds).add(element);
				}
			}
		}

	}

	/**
	 * Get method which takes a CRN number and gets the CourseDBElement of the data
	 * structure
	 * 
	 * @param crn
	 * @return CourseDBElement element
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		int index = crn % hashSize;

		if (!(hashTable.get(index).isEmpty())) {
			for (int i = 0; i < hashTable.get(index).size(); i++) {
				if (((CourseDBElement) hashTable.get(index).get(i)).getCRN() == crn) {
					return ((CourseDBElement) hashTable.get(index).get(i));
				}
			}
		}
		throw new IOException();
	}

	
	/**
	 * Checks if a number is prime or not.
	 * 
	 * @param num the number that is being checked to see if it is prime or not
	 * @return true if the num is prime
	 * @return false if the num is not prime
	 */
	private static boolean isPrime(int num) {
		boolean prime = false;
		if (num <= 1) {
			return prime;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return prime;
			}
		}
		prime = true;
		return prime;
	}

	
	/**
	 * Shows all of the elements in the hash table.
	 * 
	 * @return cds an ArrayList that contains all the elements in the hash table.
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> cds = new ArrayList<String>();

		for (int i = 0; i < hashSize; i++) {
			if (!(hashTable.get(i).isEmpty())) {
				cds.add(hashTable.get(i).toString().replace("[", "").replace("]", ""));
			}
		}
		return cds;
	}

	/**
	 * get the hash table size
	 * @return hashSize, integer of the size.
	 */
	@Override
	public int getTableSize() {
		return hashSize;
	}

}