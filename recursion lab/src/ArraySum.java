
public class ArraySum {


	public int sumOfArray(Integer[] myArray, int i) {
		if(i==0) {
			return myArray[i];
		}
		
		return +myArray[i]+sumOfArray(myArray,i-1);
		
	}

}
