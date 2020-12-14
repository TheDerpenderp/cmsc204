
public class Town implements Comparable<Town>{

	private String name;
	
	
	public Town(String name) {
		this.name =name;
	}
	
	public Town(Town other) {
		
	}
	
	public  boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(!(obj instanceof Town))
			return false;
			
		
		return (this.name.equals(obj.toString()));
		
		
	}
	
	public String getName(){
		return name;
	}
	
	public int hashcode() {
		return name.hashCode();
	}
	
	public int compareTo(Town o) {
		
		if(o.equals(this)) {
			return 0;
		}
		return -1;
	}
	
	public String toString() {
		return name;
	}

}
