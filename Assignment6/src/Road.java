
public class Road implements Comparable<Road>{

	private Town start;
	private Town end;
	private int distance;
	private String name;
	
	public Road(Town source, Town destination, int degrees, String name) {
		this.name = name;
		start = source;
		end = destination;
		distance = degrees;
	}
	
	public Road(Town source, Town destination, String name) {
		this.name = name;
		start = source;
		end = destination;
		distance = 1;
		
	}
	
	public boolean contains(Town town) {
		return town.getName().equals(start.getName()) ||town.getName().equals(end.getName());
	}
	
	public String toString() {
		return name;
	}
	
	public Town getDestination() {
		return end;
	}
	
	public Town getSource() {
		return start;
	}
	
	public int compareTo(Road o) {
		
		if(o.equals(this)) {
				return 0;
			}
			return -1;
		
	}
	
	public int getWeight() {
		return distance;
	}
	
	public boolean equals(Object r) {
		if(r == null)
			return false;
		if(!(r instanceof Road))
			return false;
			
		
		return (this.end.equals(((Road) r).getDestination()));
		
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

}
