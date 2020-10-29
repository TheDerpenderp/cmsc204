import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
	private CourseDBStructure the;

	public CourseDBManager() {

		the = new CourseDBStructure(20);

	}

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		the.add(new CourseDBElement(id, crn, credits, roomNum, instructor));

	}

	@Override
	public CourseDBElement get(int crn) {

		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner scanFile=null;
		try{
			scanFile=new Scanner(input);
		}catch(FileNotFoundException e){
			System.exit(-1);
		}
		while(scanFile.hasNextLine()) {

			add(scanFile.next(),scanFile.nextInt(),scanFile.nextInt(),scanFile.next(),scanFile.nextLine());
		}

	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> toReturn = new ArrayList<String>();

		for(LinkedList l: the.hashTable) {
			if(l != null) {
				for(Object cde: l.toArray()) {
					CourseDBElement yee = (CourseDBElement)cde;
					System.out.println("\nCourse:"+yee.CourseID+ " CRN:"+yee.CRN +" Credits:"+yee.numCredits+" Instructor:"+yee.instructorName+" Room:"+yee.roomNum);
					toReturn.add("\nCourse:"+yee.CourseID+ " CRN:"+yee.CRN +" Credits:"+yee.numCredits+" Instructor:"+yee.instructorName+" Room:"+yee.roomNum);
				}
			}


		}
		return toReturn;

	}

}
