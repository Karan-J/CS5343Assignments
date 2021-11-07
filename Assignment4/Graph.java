
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Graph {

	public List<Vertex> vertices = new ArrayList<>();

	public void addVertex(Vertex vertex) {
		vertices.add(vertex);
	}

	public List<Vertex> getVertices() {
		return vertices;
	}

	public void printVertices(Graph graph) {
		for (Vertex v : vertices) {
			System.out.println(v.getName() + " -> " + v.getAdjacentVertices().keySet());
		}
	}

	public void printEdges(Graph graph) {
		int edgeCount = 0;
		for (Vertex v : vertices) {
			Map<Vertex, Integer> adjacentVertices = v.getAdjacentVertices();
			int adjacentCount = 0;
			for (Entry<Vertex, Integer> temp : adjacentVertices.entrySet()) {
				edgeCount += 1;
				adjacentCount += 1;
				Vertex av = temp.getKey();
				Integer distance = temp.getValue();
				System.out.println(v + " -> " + av + " : " + distance);
			}
			System.out.println(v + "'s " + adjacentCount + " edges printed");
		}
		System.out.println("Printed total of " + edgeCount + " edges");
	}

	public Graph calculateShortestPathToAllVerticesFromSource(Graph graph, Vertex source) {

		System.out.println("------------Running Dijkstra's algorithm on the graph------------");
		source.distance = 0;

		Set<Vertex> settledVertices = new HashSet<>();
		Set<Vertex> minQueue = new HashSet<>();

		minQueue.add(source);

		while (minQueue.size() != 0) {

			Vertex tempVertex = getLeastDistanceVertex(minQueue);
			System.out.println("Queue: " + minQueue);
			System.out.println("Removing minimum " + tempVertex + " = " + tempVertex.getDistance() + " from queue");
			minQueue.remove(tempVertex);

			for (Entry<Vertex, Integer> adjacentPair : tempVertex.getAdjacentVertices().entrySet()) {

				Vertex adjacentVertex = adjacentPair.getKey();
				Integer edgeWeight = adjacentPair.getValue();

				if (!settledVertices.contains(adjacentVertex)) {
					calculateMinimumDistanceForCurrentVertex(tempVertex, adjacentVertex, edgeWeight);
					minQueue.add(adjacentVertex);
				}

			}

			settledVertices.add(tempVertex);
		}
		return graph;
	}

	public Vertex getLeastDistanceVertex(Set<Vertex> minQueue) {
		Vertex closestVertex = null;
		int minimumDistance = Integer.MAX_VALUE;

		for (Vertex vertex : minQueue) {
			int distance = vertex.getDistance();
			if (distance < minimumDistance) {
				minimumDistance = distance;
				closestVertex = vertex;
			}
		}

		return closestVertex;
	}

	public void calculateMinimumDistanceForCurrentVertex(Vertex sourceVertex, Vertex destinationVertex,
			Integer edgeWeight) {

		Integer sourceDistance = sourceVertex.getDistance();
		List<Vertex> shortestPath = new LinkedList<>(sourceVertex.getShortestPath());

		if ((sourceDistance + edgeWeight) < destinationVertex.getDistance()) {
			destinationVertex.setDistance(sourceDistance + edgeWeight);
			shortestPath.add(sourceVertex);
			destinationVertex.setShortestPath(shortestPath);
		}

	}

}
