
import java.util.ArrayList;
import java.util.List;

public class TopologicalSortBfs {
		
	public static List<Integer> performBfsTopologicalSort(GraphBfs graph, int numberOfVertices) {
		
		List<Integer> topologicallyOrderedList = new ArrayList<Integer>();
		List<Integer> inDegree = graph.getInDegree();
		
		List<Integer> queue = new ArrayList<>();
		for ( int i = 0 ; i < numberOfVertices + 1 ; i++ ) {
			if( inDegree.get(i) != null && inDegree.get(i) == 0 ) {
				queue.add(i);
			}
		}
		
		while ( !queue.isEmpty() ) {
			Integer poppedInteger = queue.remove(0);
			topologicallyOrderedList.add(poppedInteger);
			
			for (int j : graph.getAdjacencyList().get(poppedInteger)) {
				inDegree.set(j, inDegree.get(j) - 1);
				if (inDegree.get(j) == 0 ) {
					queue.add(j);
				}
			}
		}
		
		for ( int i = 0 ; i < numberOfVertices + 1 ; i++ ) {
			if (inDegree.get(i) != null && inDegree.get(i) != 0 ) {
				return null;
			}
		}
		
		return topologicallyOrderedList;
		
	}

}
