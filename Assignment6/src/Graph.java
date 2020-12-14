import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Graph implements GraphInterface<Town, Road>{

	private Set<Town> townSet;
	private Set roadSet;
	private ArrayList<ArrayList<Road>> graph;
	
	
	public Graph() {
		townSet = new HashSet<Town>();
		roadSet = new HashSet<Road>();
		graph = new ArrayList<ArrayList<Road>>();
	}
	
	
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		
		int x = (new ArrayList(Arrays.asList(townSet.toArray()))).indexOf(sourceVertex);
		int y = (new ArrayList(Arrays.asList(townSet.toArray()))).indexOf(destinationVertex);
		
		return graph.get(x).get(y);
	}

	
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		
		Road toAdd =new Road(sourceVertex, destinationVertex, weight, description);
		Road toAdd1 =new Road(destinationVertex, sourceVertex, weight, description);
		int x = (new ArrayList(Arrays.asList(townSet.toArray()))).indexOf(sourceVertex);
		int y = (new ArrayList(Arrays.asList(townSet.toArray()))).indexOf(destinationVertex);
		
		
		graph.get(x).set(y, toAdd);
		graph.get(y).set(x, toAdd1);
		roadSet.add(toAdd);
		roadSet.add(toAdd1);
		
		return toAdd;
	}

	
	public boolean addVertex(Town v) {
		if(v == null)
			
			throw new NullPointerException();
		if(townSet.contains(v))
			return true;
		
		townSet.add(v);
		int size  = graph.size()+2;
		ArrayList<Road> toAdd = new ArrayList<Road>();
		for(int i = 0; i<size; i++)
			toAdd.add(null);
		
		graph.add(toAdd);
		
		for(int i = 0; i<graph.size();i++)
			graph.get(i).add(null);
		return true;
	}

	
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		int x = (new ArrayList(Arrays.asList(townSet.toArray()))).indexOf(sourceVertex);
		int y = (new ArrayList(Arrays.asList(townSet.toArray()))).indexOf(destinationVertex);
		System.out.println(graph.get(x));
		if(x == -1 ||y == -1)
			return false;
		else 
			return true;
	}

	
	public boolean containsVertex(Town v) {
		//System.out.println(townSet.toString());
		return townSet.contains(v);
	}

	
	public Set<Road> edgeSet() {
		return roadSet;
	}

	
	public Set<Road> edgesOf(Town vertex) {
		int x = (new ArrayList(Arrays.asList(townSet.toArray()))).indexOf(vertex);
		Set<Road> toReturn = new HashSet<Road>();
		for(Road r: graph.get(x))
			if(r != null)
				toReturn.add(r);
		
		return toReturn;
	}

	
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean removeVertex(Town v) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Set<Town> vertexSet() {
		return townSet;
	}

	
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void dijkstraShortestPath(Town sourceVertex) {
		// TODO Auto-generated method stub
		
	}

}
