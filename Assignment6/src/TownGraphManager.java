import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

public class TownGraphManager implements TownGraphManagerInterface {

	private Graph theGraph;

	public TownGraphManager(){
		theGraph = new Graph();
	}

	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		System.out.println(town1);
		theGraph.addEdge(new Town(town1), new Town(town2), weight, roadName);
		return false;
	}

	@Override
	public String getRoad(String town1, String town2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addTown(String v) {
		
		theGraph.addVertex(new Town(v));
		return true;
	}

	@Override
	public Town getTown(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsTown(String v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> allRoads() {
		java.util.List<Object> yes = Arrays.asList(theGraph.edgeSet().toArray());
		ArrayList<String> toReturn = new ArrayList<String>();
		for(Object o: yes)
			toReturn.add(o.toString());
		return toReturn;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTown(String v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> allTowns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		// TODO Auto-generated method stub
		return null;
	}

}
