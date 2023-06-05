package grid;
import java.awt.*;
import java.util.*;

public class Vertex implements Comparable<Vertex>{	
	protected Point position;
	private double distanceFromStart = Double.POSITIVE_INFINITY;
	private double cost;
	private Vertex predecessor;
	private ArrayList<Edge> edges;
	
	public Vertex(Point position){
		this.position = position;
		this.distanceFromStart = Double.POSITIVE_INFINITY;
		this.edges = new ArrayList<Edge>();
	}
		
	public void addEdge(Edge edge){
		edges.add(edge);		
	}
	
	public void setDistanceFromStart(double distanceFromStart){
		this.distanceFromStart = distanceFromStart;
	}	
	
	public void setCost(double cost){
		this.cost = cost;
	}
	
	public void setPredecessor(Vertex predecessor){
		this.predecessor = predecessor;
	}
	
	public double getDistanceFromStart(){
		return distanceFromStart;
	}
	
	public double getCost(){
		return cost;
	}
	
	public Point getPosition(){
		return position;
	}
	
	public Edge getEdge(int index){
		return edges.get(index);
	}
	
	public ArrayList<Edge> getEdges(){
		return edges;
	}
	
	public Vertex getPredecessor(){
		return predecessor;
	}
	
	public int compareTo(Vertex other){
		return Double.compare(cost, other.cost);
	}
	
	@Override
	public String toString(){
		return "Vertex " + position.getX() + ", " + position.getY();
	}
	
}
