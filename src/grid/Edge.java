package grid;

public class Edge {	
	private int cost;	
	private Vertex destination;
	
	public Edge(int cost, Vertex destination){
		this.cost = cost;
		this.destination = destination;
	}
	
	public int getCost(){
		return cost;
	}
	
	public Vertex getDestination(){
		return destination;
	}	
	
	public void setCost(int cost){
		this.cost = cost;
	}
}
