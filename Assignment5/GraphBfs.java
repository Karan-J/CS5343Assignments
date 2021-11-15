
import java.util.ArrayList;
import java.util.List;

public class GraphBfs {

		List<List<Integer>> adjacencyList = null;

		List<Integer> inDegree = null;

		public GraphBfs(List<Edge> edges, int numberOfVertices) {

			adjacencyList = new ArrayList<List<Integer>>();

			for (int i = 0; i < numberOfVertices + 1 ; i++) {
				adjacencyList.add(new ArrayList<Integer>());
			}
			
//			since I started numbering my vertices from 1, i had to set vertex 0 as null
			adjacencyList.set(0, null);

			inDegree = new ArrayList<Integer>();
			for (int i = 0; i < numberOfVertices + 1; i++) {
				inDegree.add(0);
			}

//			since I started numbering my vertices from 1, i had to set vertex 0 as null
			inDegree.set(0, null);

//			System.out.println(edges.size());
//			System.out.println(inDegree.size());
			
			for (Edge edge : edges) {

				Integer source = edge.getSource();
				Integer destination = edge.getDestination();

				adjacencyList.get(source).add(destination);

				inDegree.set(destination, inDegree.get(destination) + 1);

			}

		}

		public List<List<Integer>> getAdjacencyList() {
			return adjacencyList;
		}

		public void setAdjacencyList(List<List<Integer>> adjacencyList) {
			this.adjacencyList = adjacencyList;
		}

		public List<Integer> getInDegree() {
			return inDegree;
		}

		public void setInDegree(List<Integer> inDegree) {
			this.inDegree = inDegree;
		}
		
		

}
