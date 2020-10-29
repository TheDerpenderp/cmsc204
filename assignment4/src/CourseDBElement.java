
public class CourseDBElement implements Comparable{

	public String CourseID;
	public int CRN;
	public int numCredits;
	public String roomNum;
	public String instructorName;
	
	public CourseDBElement(String CourseID,int CRN,int numCredits,String roomNum,String instructorName) {
		this.CourseID = CourseID;
		this.CRN = CRN;
		this.numCredits = numCredits;
		this.roomNum = roomNum;
		this.instructorName = instructorName;
		
	}
	
	
	public int compareTo(CourseDBElement element) {
		
		return this.CRN-element.CRN;
	}


	public int getCRN() {
		return CRN;
	}

}
