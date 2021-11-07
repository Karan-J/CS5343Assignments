
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Vertex {

	public String name;
	public Map<Vertex, Integer> adjacentVertices = new HashMap<>();
	public List<Vertex> shortestPath = new LinkedList<>();

	// when we are adding the vertices, we are adding them at infinite distance from
	// the source vertex
	public Integer distance = Integer.MAX_VALUE;

	public Vertex(String name) {
		this.name = name;
	}

	public void addEdge(Vertex toVertex, int distance) {
		adjacentVertices.put(toVertex, distance);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Map<Vertex, Integer> getAdjacentVertices() {
		return adjacentVertices;
	}

	public void setAdjacentVertices(Map<Vertex, Integer> adjacentVertices) {
		this.adjacentVertices = adjacentVertices;
	}

	public List<Vertex> getShortestPath() {
		return shortestPath;
	}

	public void setShortestPath(List<Vertex> shortestPath) {
		this.shortestPath = shortestPath;
	}

	@Override
	public String toString() {
		return name;
	}

}