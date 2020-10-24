package hashingLab;

public class problem1b {

	public static void main(String[] args) {
		int[] hash= new int[10];
		for(int i=0;i<hash.length;i++) 
			hash[i]=-20000;
			
		
		int[] added = {27, 53, 13, 10, 138, 109, 49, 174, 26, 24};
		for(int i:added) {
			
			if(hash[i%10] == -20000) {
				hash[i%10]= i;
			}
			else {
				int counter = 0;
				do {
					counter++;
				}while(hash[(i+counter)%10] != -20000);
				hash[(i+counter)%10]= i;
			}
		}
		for(int i:hash) 
			System.out.println(i);
		

	}

}
