
import java.io.IOException;
import java.util.*;


public class CourseDBStructure implements CourseDBStructureInterface{

	public LinkedList[] hashTable;
	public int sizeOfArray; 



	public CourseDBStructure(int size) {
		hashTable = new LinkedList[size];
		sizeOfArray = size;
	}

	public CourseDBStructure(String test, int size) {
		hashTable = new LinkedList[size];
		sizeOfArray = size;
	}


	public void add(CourseDBElement element) {
		int hashcode = ((element.CRN+"").hashCode())%sizeOfArray;
		if(hashTable[hashcode] == null) 
			hashTable[hashcode] = new LinkedList();
		hashTable[hashcode].add(element);


	}


	public CourseDBElement get(int crn) throws IOException {
		int hashcode = ((crn+"").hashCode())%sizeOfArray;
		if(hashTable[hashcode] == null) 
			throw new IOException();
		
		ListIterator h = hashTable[hashcode].listIterator();
		while(h.hasNext()) {
			CourseDBElement yes = (CourseDBElement) h.next();
			if(yes.getCRN() == crn)
				return yes;
				
		}

		return null;
	}


	public int getTableSize() {

		return sizeOfArray;
	}

}
